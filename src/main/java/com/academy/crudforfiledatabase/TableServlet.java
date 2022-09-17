package com.academy.crudforfiledatabase;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet(name = "tableServlet", value = "/table/*")
public class TableServlet extends HttpServlet {
    private String databasePath;
    private String tableName;

    public void init() {
        databasePath = TableServlet.class.
                getClassLoader()
                .getResource("database")
                .getPath();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        tableName = request.getPathInfo();
        PrintWriter writer = response.getWriter();

        try (FileInputStream fis = new FileInputStream(databasePath + tableName)) {
            int temp;
            writer.println("<html><body><pre><h1>");
            while ((temp = fis.read()) != -1) {
                writer.print((char) temp);
            }
            writer.println("</h1></pre></body></html>");
        } catch (FileNotFoundException e) {
            writer.print("<h1>File doesn't exist</h1>");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        tableName = request.getPathInfo();
        File file = new File(databasePath + tableName);

        if (file.delete()) {
            System.out.println("File '" + file.getName() + "' deleted");
        } else {
            System.out.println("File '" + file.getName() + "' doesn't exist");
        }
    }

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        tableName = request.getPathInfo();
        File file = new File(databasePath + tableName);

        if (!file.exists()) {
            System.out.println("User trying to update non-existent file");
            return;
        }

        try (FileWriter fileWriter = new FileWriter(databasePath + tableName)) {
            String content = (String) JsonReader.convertJson(request).get("content");
            fileWriter.write(content.replaceAll(", ", "\n"));
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        tableName = request.getPathInfo();

        if (new File(databasePath + tableName).createNewFile()) {
            System.out.println("File created: " + tableName);
        } else {
            System.out.println("File already exists.");
        }
    }

    public void destroy() {
    }
}
