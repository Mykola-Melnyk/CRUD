package com.academy.crudforfiledatabase;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

@WebServlet(name = "databaseServlet", value = "/tables")
public class DatabaseServlet extends HttpServlet {
    URL resourceURL;
    String[] directoryContent;
    public void init() {
        resourceURL = this.getClass()
                .getClassLoader()
                .getResource("database/");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        directoryContent = FileProcessor.directoryContent(new File(resourceURL.getPath()));
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        for (String file : directoryContent) {
            writer.println("<h1>-" + file + "</h1>");
        }
        writer.println("</body></html>");
    }

    public void destroy() {
    }
}
