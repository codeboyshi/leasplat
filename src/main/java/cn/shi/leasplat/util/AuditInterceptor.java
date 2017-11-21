package cn.shi.leasplat.util;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.shi.leasplat.entity.User;
import cn.shi.leasplat.service.AccessTokenService;
import cn.shi.leasplat.service.UserService;

public class AuditInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AccessTokenService accessTokenService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		 User user = getLoginUser(request,response);
		 request.setAttribute("login_user", user);
		 //System.out.println(user);
		 if(user == null) {
	            response.sendRedirect(
	                request.getContextPath() + "/user/toLogin.do");
//			 response.sendRedirect(request.getContextPath());
	            return false;
	        }
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
	
	private User getLoginUser(HttpServletRequest request, HttpServletResponse response)
    {
        // ªÒ»°access_token
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
        if (null == user) return null;

        String token = cookies.get("token").trim();
        if (null == token) return null;
        if (!token.matches("^\\w{32}$")) return null;

        String ip = request.getHeader("X-Forwarded-For");
        if (null == ip) ip = request.getRemoteAddr();
        if (ip.indexOf(',') > -1) ip = ip.substring(0, ip.indexOf(',')).trim();
        if (accessTokenService.check(user, token, request, response) == false) return null;
        return user;
    }
	
}
