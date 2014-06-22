package listeners;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.data.db.HotelStorage;
import model.data.db.AgencyStorage;
import model.data.db.StaticStorage;
import model.data.users.Agency;
import model.data.users.Hotel;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	ArrayList<Hotel> hotelsList =  StaticStorage.getHotelsFromDB();
    	ServletContext context = arg0.getServletContext();
    	context.setAttribute("hotels", hotelsList);
    	
    	ArrayList<Agency> agencyList = StaticStorage.getAgenciesFromDB();
    	context.setAttribute("agencies", agencyList);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
