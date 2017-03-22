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

public class toStringClient extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JButton b1 = new JButton("«Î ‰»Î“ª¥Æ ˝◊÷");
	static JPanel p = new JPanel();
	static JPanel p1 = new JPanel();
	static JLabel l = new JLabel();
	static JTextField tf = new JTextField(15);	
	static JTextArea ta = new JTextArea(20,30);
	static JScrollPane js = new JScrollPane(ta);
	
	public toStringClient()
	{
		this.add(p,BorderLayout.NORTH);
		this.add(p1,BorderLayout.CENTER);
		this.setBounds(0, 0, 500, 500);
		this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public String invoke(int radius)
    {
        String result = null;
        XmlRpcClient client = new XmlRpcClient();
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        try
        {
            config.setServerURL(new URL("http://127.0.0.1:11111"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        client.setConfig(config);
        try
        {
        		result = (String) client.execute("nickname.toString", new Object[] { radius });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "The English number is:" + result;
    }

   
    public static void main(String[] args)
    {
    	p.add(b1);
		p.add(l);
		p.add(tf);
		ta.setLineWrap(true);
		p1.add(js);
		
        final toStringClient myTest = new toStringClient();
        
        
        b1.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			String radius = tf.getText();
    			 if (!radius.equals("")){
    				 String result = myTest.invoke(Integer.parseInt(radius));
    				 ta.setText(result);
    			 }   			
    		}        	  
        });
        
         
   }
    	
    
}
