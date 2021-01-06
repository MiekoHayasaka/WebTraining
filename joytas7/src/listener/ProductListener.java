package listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.Product;

@WebListener
public class ProductListener implements ServletContextListener {


    public void contextDestroyed(ServletContextEvent sce)  {

    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	ServletContext Application=sce.getServletContext();
    	List<Product> list=new ArrayList<>();
    	Application.setAttribute("list",list);
    }

}
