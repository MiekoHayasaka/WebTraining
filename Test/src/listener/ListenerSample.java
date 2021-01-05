package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ListenerSample
 *
 */
@WebListener
public class ListenerSample implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  {
         ServletContext context=sce.getServletContext();
         Integer count=0;
         context.setAttribute("count", count);
    }

    public void contextInitialized(ServletContextEvent arg0)  {
         // TODO Auto-generated method stub
    }

}
