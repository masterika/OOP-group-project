package listeners;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
<<<<<<< HEAD

import model.data.db.HotelStorage;
import model.data.db.AgencyStorage;
import model.data.db.StaticStorage;
=======
>>>>>>> 7813c3a15bfb0b5a26ca8ae59432b297468af762
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
<<<<<<< HEAD
    	ArrayList<Hotel> hotelsList =  StaticStorage.getHotelsFromDB();
    	ServletContext context = arg0.getServletContext();
    	context.setAttribute("hotels", hotelsList);
    	
    	ArrayList<Agency> agencyList = StaticStorage.getAgenciesFromDB();
    	context.setAttribute("agencies", agencyList);
=======
//    	HotelStorage hotelStorage = new HotelStorage();
//    	ArrayList<Hotel> hotelsList =  hotelStorage.getHotelsFromDB();
//    	ServletContext context = arg0.getServletContext();
//    	context.setAttribute("hotels", hotelsList);
//    	
//    	AgencyStorage agencyStorage = new AgencyStorage();
//    	ArrayList<Agency> agencyList = agencyStorage.getAgenciesFromDB();
//    	context.setAttribute("agencies", agencyList);
>>>>>>> 7813c3a15bfb0b5a26ca8ae59432b297468af762
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
