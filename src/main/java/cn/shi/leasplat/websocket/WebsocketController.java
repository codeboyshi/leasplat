package cn.shi.leasplat.websocket;

import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.socket.server.standard.SpringConfigurator;

/**
 * 
 * @author shiqiang
 *	因为版本问题，可能会影响到注入问题，涉及到存入数据库时，如果注入service不成功就实例化吧，毕竟版本都定型了。。。也可试试别的
 */
// 该注解用来指定一个URI，客户端可以通过这个URI来连接到WebSocket。
/**
           类似Servlet的注解mapping。无需在web.xml中配置。
 * configurator = SpringConfigurator.class是为了使该类可以通过Spring注入。
*/
@Controller
@ServerEndpoint(value = "/websocket.do/{userId}",configurator = SpringConfigurator.class)
public class WebsocketController {
	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    
    private static int index = 0;
    public WebsocketController(){}
    
    
    // concurrent包的线程安全Set，用来存放每个客户端对应的WebsocketController对象。
    // 若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<WebsocketController> webSocketSet = new CopyOnWriteArraySet<WebsocketController>();
    
    private static Hashtable<WebsocketController, Long> webSocketMap = new Hashtable<WebsocketController, Long>();
    // 与客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    
    
    /**
     * 连接建立成功调用的方法
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam("userId") Long userId,Session session)
    {
    	System.out.println("userId:" + userId);
    	this.session = session;
//    	webSocketSet.add(this);
    	webSocketMap.put(this, userId);
    	addOnlineCount();
    	System.out.println("有新连接加入！当前在线人数为:" + getOnlineCount());
    }
    
    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose()
    {
//    	webSocketSet.remove(this);
    	webSocketMap.remove(this);
    	subOnlineCount();
    	System.out.println("当前连接已退出！当前在线人数为：" + getOnlineCount());
    }
    
    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session)
    {
    	 System.out.println("来自客户端的消息:" + message);
    	 // 群发消息
//    	 for (WebsocketController soc : webSocketSet)
//    	 {
//    		 try {
//				soc.sendMessage(message);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//    	 }
    	 
    	 for(WebsocketController soc : webSocketMap.keySet())
    	 {
    		 try {
    			 if(index % 2 == 0)
    			 {
    				 soc.sendMessage("小强" + ":" + message);
    			 }
    			 else
    			 {
    				 soc.sendMessage("字典" + ":" + message);
    			 }
				//soc.sendMessage(webSocketMap.get(soc) + ":" + message);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	 }
    	 index ++;
    }
    
    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error)
    {
    	System.out.println("出错了！！！！");
    }
    
    
    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException
    {
    	 this.session.getBasicRemote().sendText(message);
         //this.session.getAsyncRemote().sendText(message);
    }
    
    // 获取连接数量，保持同步
    public static synchronized int getOnlineCount() 
    {
        return onlineCount;
    }
    
    // 连接数量加1，保持同步
    public static synchronized void addOnlineCount() 
    {
        WebsocketController.onlineCount++;
    }
    
    // 连接数量减1，保持同步
    public static synchronized void subOnlineCount() 
    {
        WebsocketController.onlineCount--;
    }
    

}
