
package com.example;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/students/update")
public class UpdateStudentServlet extends HttpServlet {
    private final StudentDAO dao = new StudentDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String idStr = req.getParameter("id");
        String name = req.getParameter("name");
        String ageStr = req.getParameter("age");

        if (idStr == null || idStr.isBlank() ||
            ageStr == null || ageStr.isBlank()) {

            req.getSession().setAttribute("msg", "ID, Name and Age are required.");
            resp.sendRedirect(req.getContextPath() + "/update.jsp?id=" + idStr);
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            int age = Integer.parseInt(ageStr);
            

            boolean updated = dao.UpdateStudentServlet(id, name.trim(), age);

            if (updated) {
            
                resp.sendRedirect(req.getContextPath() + "/students");
            } else {
                req.getSession().setAttribute("msg", "Student not found or update failed.");
                resp.sendRedirect(req.getContextPath() + "/update.jsp?id=" + id);
            }
        } catch (NumberFormatException nfe) {
            req.getSession().setAttribute("msg", "ID and Age must be numbers.");
            resp.sendRedirect(req.getContextPath() + "/update.jsp?id=" + idStr);
        }
    }
}
