package listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import model.data.db.AdminStorage;

/**
 * Application Lifecycle Listener implementation class SessionCountListeners
 * 
 */
@WebListener
public class SessionCountListeners implements HttpSessionListener {

	private static int sessionCounter = 0;
	public SessionCountListeners() {
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent arg0) {
		sessionCounter++;
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		if (sessionCounter > 0)
			sessionCounter--;
	}

	public static int getActiveSessions() {
		return sessionCounter;
	}
	
	
}
