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
 *	��Ϊ�汾���⣬���ܻ�Ӱ�쵽ע�����⣬�漰���������ݿ�ʱ�����ע��service���ɹ���ʵ�����ɣ��Ͼ��汾�������ˡ�����Ҳ�����Ա��
 */
// ��ע������ָ��һ��URI���ͻ��˿���ͨ�����URI�����ӵ�WebSocket��
/**
           ����Servlet��ע��mapping��������web.xml�����á�
 * configurator = SpringConfigurator.class��Ϊ��ʹ�������ͨ��Springע�롣
*/
@Controller
@ServerEndpoint(value = "/websocket.do/{userId}",configurator = SpringConfigurator.class)
public class WebsocketController {
	// ��̬������������¼��ǰ������������Ӧ�ð�����Ƴ��̰߳�ȫ�ġ�
    private static int onlineCount = 0;
    
    private static int index = 0;
    public WebsocketController(){}
    
    
    // concurrent�����̰߳�ȫSet���������ÿ���ͻ��˶�Ӧ��WebsocketController����
    // ��Ҫʵ�ַ�����뵥һ�ͻ���ͨ�ŵĻ�������ʹ��Map����ţ�����Key����Ϊ�û���ʶ
    private static CopyOnWriteArraySet<WebsocketController> webSocketSet = new CopyOnWriteArraySet<WebsocketController>();
    
    private static Hashtable<WebsocketController, Long> webSocketMap = new Hashtable<WebsocketController, Long>();
    // ��ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
    private Session session;
    
    
    /**
     * ���ӽ����ɹ����õķ���
     * @param session  ��ѡ�Ĳ�����sessionΪ��ĳ���ͻ��˵����ӻỰ����Ҫͨ���������ͻ��˷�������
     */
    @OnOpen
    public void onOpen(@PathParam("userId") Long userId,Session session)
    {
    	System.out.println("userId:" + userId);
    	this.session = session;
//    	webSocketSet.add(this);
    	webSocketMap.put(this, userId);
    	addOnlineCount();
    	System.out.println("�������Ӽ��룡��ǰ��������Ϊ:" + getOnlineCount());
    }
    
    /**
     * ���ӹرյ��õķ���
     */
    @OnClose
    public void onClose()
    {
//    	webSocketSet.remove(this);
    	webSocketMap.remove(this);
    	subOnlineCount();
    	System.out.println("��ǰ�������˳�����ǰ��������Ϊ��" + getOnlineCount());
    }
    
    /**
     * �յ��ͻ�����Ϣ����õķ���
     * @param message �ͻ��˷��͹�������Ϣ
     * @param session ��ѡ�Ĳ���
     */
    @OnMessage
    public void onMessage(String message, Session session)
    {
    	 System.out.println("���Կͻ��˵���Ϣ:" + message);
    	 // Ⱥ����Ϣ
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
    				 soc.sendMessage("Сǿ" + ":" + message);
    			 }
    			 else
    			 {
    				 soc.sendMessage("�ֵ�" + ":" + message);
    			 }
				//soc.sendMessage(webSocketMap.get(soc) + ":" + message);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	 }
    	 index ++;
    }
    
    /**
     * ��������ʱ����
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error)
    {
    	System.out.println("�����ˣ�������");
    }
    
    
    /**
     * ������������漸��������һ����û����ע�⣬�Ǹ����Լ���Ҫ��ӵķ�����
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException
    {
    	 this.session.getBasicRemote().sendText(message);
         //this.session.getAsyncRemote().sendText(message);
    }
    
    // ��ȡ��������������ͬ��
    public static synchronized int getOnlineCount() 
    {
        return onlineCount;
    }
    
    // ����������1������ͬ��
    public static synchronized void addOnlineCount() 
    {
        WebsocketController.onlineCount++;
    }
    
    // ����������1������ͬ��
    public static synchronized void subOnlineCount() 
    {
        WebsocketController.onlineCount--;
    }
    

}
