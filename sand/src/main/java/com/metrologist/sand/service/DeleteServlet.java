package com.metrologist.sand.service;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String id=request.getParameter("id");
        int no=Integer.parseInt(id);
        int sumcount=0;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sand", "root", "dep33");
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM users WHERE id = '"+no+"'");
            response.sendRedirect("/views/admin.jsp");
        }
        catch(Exception e){}
    }
}