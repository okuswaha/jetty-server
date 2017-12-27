package com.prakash.handlers;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.prakash.handlers.HandlerUtils.handleHttpResponse;

public class MainHandler extends AbstractHandler{
    @Override
    public void handle(String s, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException {
        String body = "Main Page Handler";
        handleHttpResponse(httpServletResponse, body);
        request.setHandled(true);
    }


}
