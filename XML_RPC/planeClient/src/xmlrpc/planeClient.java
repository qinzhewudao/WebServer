package xmlrpc;

import java.net.URL;


import javax.swing.JFrame;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
public class planeClient extends JFrame{

		
	public String invoke(String radius)
    {
        String result = "execting";
        XmlRpcClient client = new XmlRpcClient();
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        try
        {
            config.setServerURL(new URL("http://127.0.0.1:12345"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        client.setConfig(config);
        try
        {
        		client.execute("game.planegame", new Object[] { radius });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return result;
    }

   
    public static void main(String[] args)
    {
		
        final planeClient myTest = new planeClient();
                
    	String radius = "execting";
        myTest.invoke(radius);

   }
    	   
}
