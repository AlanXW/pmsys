package net.teamx.web;

import net.teamx.bean.User;
import net.teamx.service.UserService;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends BaseServlet {
    // Login by checking username and password inputted.
    public void login(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService=new UserService();
        User user=null;
        try {
            user = userService.login(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (user!=null){
            response.sendRedirect(request.getContextPath()+"/transaction?method=getTransaction");
            request.getSession().setAttribute("user",user);
        }else{
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println ("<script language=javascript>alert('Wrong username or password! Please try again.');window.location='index.jsp'</script>");
        }
    }

    // Logout and redirect to login page.
    public void logout(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getSession().removeAttribute("user");
        response.sendRedirect(request.getContextPath());
    }
}
