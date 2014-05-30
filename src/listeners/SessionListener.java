package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import model.data.users.User;
import model.data.users.Client;
import model.data.users.Agency;
import model.data.users.Hotel;
/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0) {
       User user  = new User();
       Client client = new Client();
       Agency agency = new Agency();
       Hotel hotel = new Hotel();
       arg0.getSession().setAttribute("user", user);
       arg0.getSession().setAttribute("client", client);
       arg0.getSession().setAttribute("agency", agency);
       arg0.getSession().setAttribute("hotel", hotel);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
