package com.heu.cs.jettyserver;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by memgq on 2017/5/14.
 */
public class JettyServerStart {
    public static void main(String[] args)
    {
        System.setProperty("org.eclipse.jetty.LEVEL","INFO");
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.addConnector(connector);

        // The filesystem paths we will map
//        String homePath = System.getProperty("user.home");
        String pwdPath = System.getProperty("user.dir");

        // Setup the basic application "context" for this application at "/"
        // This is also known as the handler tree (in jetty speak)
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setResourceBase(pwdPath);
        context.setContextPath("/");
        server.setHandler(context);


        ServletHolder servletHolder = new ServletHolder(ServletContainer.class);
        Map<String, String> parameterMap = new HashMap<String, String>();
//        parameterMap.put("jersey.config.server.provider.classnames", "org.glassfish.jersey.server.ResourceConfig");
        parameterMap.put("jersey.config.server.provider.packages", "com.heu.cs.service");
        servletHolder.setInitParameters(parameterMap);
        context.addServlet(servletHolder, "/dynamic/*");


        // add special pathspec of "/home/" content mapped to the homePath
        ServletHolder holderHome = new ServletHolder("static-home", DefaultServlet.class);
        holderHome.setInitParameter("dirAllowed","true");
        holderHome.setInitParameter("pathInfoOnly","true");
        context.addServlet(holderHome,"/static/*");




        // Lastly, the default servlet for root content (always needed, to satisfy servlet spec)
        // It is important that this is last.
//        ServletHolder holderPwd = new ServletHolder("default", DefaultServlet.class);
//        holderPwd.setInitParameter("resourceBase",homePath);
//        holderPwd.setInitParameter("dirAllowed","true");
//        context.addServlet(holderPwd,"/");

        try
        {
            server.start();
            server.dump(System.err);
            server.join();
        }
        catch (Throwable t)
        {
            t.printStackTrace(System.err);
        }
    }
}
