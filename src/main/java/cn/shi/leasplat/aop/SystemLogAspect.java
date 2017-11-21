package cn.shi.leasplat.aop;

import java.lang.reflect.Method;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes; 

import cn.shi.leasplat.annotation.Auditable;
import cn.shi.leasplat.entity.SystemLog;
import cn.shi.leasplat.entity.User;
import cn.shi.leasplat.service.SystemLogService;
import cn.shi.leasplat.service.UserService;
import jdk.nashorn.internal.runtime.Context.ThrowErrorManager;
/**
 * 
 * @author shiqiang
 *
 */
@Component
@Aspect
public class SystemLogAspect {
	 public SystemLogAspect() {
		//System.out.println("测试aop日志");
	}
	@Resource
	private SystemLogService systemLogService;
	
	@Autowired
	private UserService userService;
	
	//private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect. class);
	
//	@After("execution (** cn.shi.leasplat.websocket.*Controller.*(..))") 
//	public void before()
//	{
//		System.out.println("测试切入点");
//	}
	
	// 切面设置为controller，后置通知处理数据库日志
	// Controller层切点
	// 后置通知插入数据库日志
	 /** 
       * 后置通知 用于拦截Controller层记录用户的操作 
       * 
       * @param joinPoint 切点 
       */  
	@After("execution (* cn.shi.leasplat.web.*Controller.*(..))") 
	public void after(JoinPoint joinPoint){
		 try {  
//			              System.out.println("XXXXXXX:");
			 // TODO:首先要获取登录的用户，然后将id或者账号保存
	              String targetName = joinPoint.getTarget().getClass().getName();  
	              String methodName = joinPoint.getSignature().getName();  
	              Object[] arguments = joinPoint.getArgs();  
	              Class targetClass = Class.forName(targetName);
	              Method[] methods = targetClass.getMethods();
	              HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	              User user = getLoginUser(request);
	              if (user == null) return;
	              String moduleName = "";
	              String operationName = "";
	               for (Method method : methods) {  
	                   if (method.getName().equals(methodName)) {  
	                      Class[] clazzs = method.getParameterTypes();  
	                       if (clazzs.length == arguments.length) {  
	                    	   // 获取参数
	                    	   if (method.getAnnotation(Auditable.class) == null)
	                    	   {
	                    		   return;
	                    	   }
	                    	   moduleName = method.getAnnotation(Auditable.class).moduleName();
	                           operationName = method.getAnnotation(Auditable.class).operationName();
	                           break;  
	                      }  
	                  }  
	              }
	               SystemLog systemLog = new SystemLog();
	               systemLog.setModuleName(moduleName);
	               systemLog.setOperationName(operationName);
	               systemLog.setUserId(user.getUserId());
	               systemLogService.saveSystemLog(systemLog);
	            //    System.out.println("测试通过");
	               }catch (Exception e) {
			 System.err.println(e.getMessage());
			 e.printStackTrace();
//			 logger.error("==后置通知异常==");  
//			 logger.error("异常信息:{}", e.getMessage());  
		}
	}
	
	private User getLoginUser(HttpServletRequest request)
    {
        // 获取access_token
        HttpSession session = request.getSession();
        Cookie[] items = request.getCookies();
        if (null == items) return null;
        HashMap<String, String> cookies = new HashMap<String, String>();
        for (int i = 0; i < items.length; i++)
        {
            cookies.put(items[i].getName(), items[i].getValue());
        }
        System.err.println("uid: " + cookies.get("userId"));
        System.err.println("token: " + cookies.get("token"));
        if (!cookies.containsKey("userId")) return null;
        if (!cookies.containsKey("token")) return null;

        String uid = cookies.get("userId").trim();
        if (!uid.matches("^\\d+$")) return null;
        User user = userService.findUserById(Integer.parseInt(uid));
        System.out.println("User: " + user);
        if (null == user) return null;

//        String token = cookies.get("token").trim();
//        if (null == token) return null;
//        if (!token.matches("^\\w{32}$")) return null;
//
//        String ip = request.getHeader("X-Forwarded-For");
//        if (null == ip) ip = request.getRemoteAddr();
//        if (ip.indexOf(',') > -1) ip = ip.substring(0, ip.indexOf(',')).trim();
        // if (accesstokenService.check(user, ip, "web", token) == false) return null;
        return user;
    }
	
}
