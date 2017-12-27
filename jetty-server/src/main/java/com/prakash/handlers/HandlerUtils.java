package com.prakash.handlers;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HandlerUtils {
    public static void handleHttpResponse(HttpServletResponse httpServletResponse, String body) throws IOException {
        httpServletResponse.setContentType("text/html; charset=utf-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.println("<h1> "+body+" </h1>");
    }
}
