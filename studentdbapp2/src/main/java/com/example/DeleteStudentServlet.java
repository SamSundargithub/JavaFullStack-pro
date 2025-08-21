package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/students/del")
public class DeleteStudentServlet extends HttpServlet {
 
      private final StudentDAO dao = new StudentDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String ageStr = req.getParameter("id");

        if ( ageStr == null || ageStr.isBlank()) {
            req.getSession().setAttribute("msg", "Name and Age are required.");
            resp.sendRedirect(req.getContextPath() + "/delStudent.jsp");
            return;
        }

        try {
            int id = Integer.parseInt(ageStr);
            dao.delStudent(id);
            // redirect to list after insert (PRG pattern)
            resp.sendRedirect(req.getContextPath() + "/students");
        } catch (NumberFormatException nfe) {
            req.getSession().setAttribute("msg", "Age must be a number.");
            resp.sendRedirect(req.getContextPath() + "/delStudent.jsp");
        }
    }
}

