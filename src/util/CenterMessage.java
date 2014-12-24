package util;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.smslib.GatewayException;
import org.smslib.SMSLibException;
import org.smslib.Service;
import org.smslib.TimeoutException;
import org.smslib.modem.SerialModemGateway;

/**
 * Application Lifecycle Listener implementation class CenterMessage
 *
 */
public class CenterMessage implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CenterMessage() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent ev) {
    	ServletContext contex = ev.getServletContext();
    	System.out.println( "listener " + contex.getInitParameter("comPort") + " : " +  contex.getInitParameter("centerNumber"));
		SendMessageUtil.init(contex.getInitParameter("comPort"), contex.getInitParameter("centerNumber"));
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
