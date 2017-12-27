package com.prakash.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProviderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest servletRequest , HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/html");
        servletResponse.setStatus(HttpServletResponse.SC_OK);
        servletResponse.getWriter().println("<h1>Hello from Provider servlet: GET Request </h1>");

    }
    @Override
    protected void doPost(HttpServletRequest servletRequest , HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("application/json");
        servletResponse.setStatus(HttpServletResponse.SC_OK);
        servletResponse.getWriter().println("{\"text\" : \"Hello from provider servlet\", \"request\" : \"POST Request\" }");

    }
}
