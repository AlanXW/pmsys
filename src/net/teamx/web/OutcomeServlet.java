package net.teamx.web;

import net.teamx.service.OutcomeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "OutcomeServlet", urlPatterns = "/outcome")
public class OutcomeServlet extends HttpServlet {
    // Add outcomes by doPost method.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String outcome = request.getParameter("outcome");
        // If user click add button without input.
        if(outcome.equals("")){
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print("<html><body><script type='text/javascript'>alert('Please input outcome.');window.history.go(-1)</script></body></html>");
            response.getWriter().close();
        }else{
            OutcomeService outcomeService = new OutcomeService();
            int row = 0;
            try {
                row = outcomeService.addOutcome(outcome);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (row>0){
                // Add successfully.
                response.setContentType("text/html; charset=UTF-8");
                response.getWriter().print("<html><body><script type='text/javascript'>alert('Add successfully!');window.history.go(-1)</script></body></html>");
                response.getWriter().close();
            }else{
                // Can not add this outcome. eg. SQLException.
                response.setContentType("text/html; charset=UTF-8");
                response.getWriter().print("<html><body><script type='text/javascript'>alert('Can not add this outcome!');window.history.go(-1)</script></body></html>");
                response.getWriter().close();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
