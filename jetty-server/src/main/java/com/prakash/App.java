package com.prakash;

import com.prakash.handlers.HelloHandler;
import com.prakash.handlers.IndexHandler;
import com.prakash.handlers.MainHandler;
import com.prakash.servlets.HelloServlet;
import com.prakash.servlets.ProductServlet;
import com.prakash.servlets.ProviderServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.*;
import org.eclipse.jetty.servlet.ServletHandler;

import java.security.Provider;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        Server server = new Server(8080);
        /*
        HelloHandler helloHandler = new HelloHandler();
        server.setHandler(helloHandler);
        */
//        ContextHandler contextHello = new ContextHandler("/");
//        contextHello.setContextPath("/hello");
//        contextHello.setHandler(new HelloHandler());
//
//        ContextHandler contextIndex = new ContextHandler("/index");
//        contextIndex.setHandler(new IndexHandler());
//
//        ContextHandler contextMain = new ContextHandler("/main");
//        contextMain.setHandler(new MainHandler());
//
//
//        ContextHandlerCollection contexts = new ContextHandlerCollection();
//        contexts.setHandlers(new Handler[] { contextHello, contextIndex, contextMain});

        // now adding servletHandler
        ServletHandler servletHandler = new ServletHandler();
       // server.setHandler(servletHandler);

        // now adding servlet

        servletHandler.addServletWithMapping(HelloServlet.class, "/*");
        servletHandler.addServletWithMapping(ProductServlet.class, "/product");
        servletHandler.addServletWithMapping(ProviderServlet.class, "/provider");

//        server.setHandler(contexts);

        // for resource handlling
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[] {"index.html"});
        resourceHandler.setResourceBase(".");

        HandlerList handlerList = new HandlerList();
        handlerList.setHandlers(new Handler[] {resourceHandler, servletHandler});


        server.start();
    }
}
