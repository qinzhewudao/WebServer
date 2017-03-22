package xmlrpc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class DAClient extends JFrame{

	
	static JButton b1 = new JButton("Please enter the string:");
	static JPanel p = new JPanel();
	static JPanel p1 = new JPanel();
	static JLabel l = new JLabel();
	static JTextField tf = new JTextField(15);	
	static JTextArea ta = new JTextArea(20,30);
	static JScrollPane js = new JScrollPane(ta);
	
	public DAClient()
	{
		this.add(p,BorderLayout.NORTH);
		this.add(p1,BorderLayout.CENTER);
		this.setBounds(0, 0, 500, 500);
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public String invoke(String radius, String type)
    {
        String result = null;
        XmlRpcClient client = new XmlRpcClient();
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        try
        {
            config.setServerURL(new URL("http://127.0.0.1:10090"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        client.setConfig(config);
        try
        {
        	if (type.trim().equals("circle"))
        		result = (String) client.execute("document.documentWithoutSymbol", new Object[] { radius });
        	//else if (type.trim().equals("sphere"))
        		//result = (Double) client.execute("sphereAreaHandler.sphereArea", new Object[] { radius });
//        		result = (Double) client.execute("sphereArea.sphereAreaOfNums", new Object[] { radius,2.5 });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //System.out.println("after modifyed the string change to : " + result);
        return "after modifyed the string change to : " + result;
    }

   
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
//        if (args.length < 1)
//        {
//            System.out.println("缺少命令行参数!");
//        }
    	p.add(b1);
		p.add(l);
		p.add(tf);
		ta.setLineWrap(true);
		p1.add(js);
		
        final DAClient myTest = new DAClient();
        
        
        b1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			String radius = tf.getText();
    			 if (!radius.equals("")){
    				 String result = myTest.invoke(radius, "circle");
    				 ta.setText(result);
    			 }   			
    		}        	  
        });        
         
   }
    	
    
}
