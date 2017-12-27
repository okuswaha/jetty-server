package com.prakash;

import com.prakash.Endpoints.Calculator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Hello world!
 *
 */
public class RestServer
{
    public static void main( String[] args ) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8090);
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet( ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        jerseyServlet.setInitParameter("jersey.config.server.provider.classnames", Calculator.class.getCanonicalName());

        jettyServer.start();
        jettyServer.join();
    }
}
