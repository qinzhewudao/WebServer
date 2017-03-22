package xmlrpc;


import java.io.IOException;
import java.net.InetAddress;

import org.apache.xmlrpc.XmlRpcHandler;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.webserver.WebServer;
public class toStringServer {

	public WebServer    web_server;

    public toStringServer()
    {
        try
        {
            this.web_server = new WebServer(11111,
                    InetAddress.getByAddress(new byte[] { 127, 0, 0, 1 })); //Setting the IP Address and Port Number
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void initServer()
    {
        XmlRpcServer xmlRpcServer = web_server.getXmlRpcServer(); //get XMLRPC Server Instance
        PropertyHandlerMapping phm = new PropertyHandlerMapping(); //create Handler instance
        try
        {
            phm.addHandler("int", toString.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        xmlRpcServer.setHandlerMapping(phm);
        try
        {
        	// start the server
        	System.out.println("Attempting to start XML-RPC Server...");
            web_server.start();
            System.out.println("Server is ready, waiting for client calling...");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

   
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
    	toStringServer mySer = new toStringServer();
        mySer.initServer();
    }
}
