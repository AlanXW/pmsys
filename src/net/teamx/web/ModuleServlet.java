package net.teamx.web;

import net.teamx.bean.Module;
import net.teamx.bean.User;
import net.teamx.service.ModuleService;
import net.teamx.service.TransactionService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ModuleServlet",urlPatterns = "/module")
public class ModuleServlet extends BaseServlet {
    public void addModule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Add new module.
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Module module=new Module();
            BeanUtils.populate(module,parameterMap);
            TransactionService transactionService = new TransactionService();
            ModuleService moduleService=new ModuleService();
            moduleService.addModule(module);
            User user = (User)request.getSession().getAttribute("user");
            // Generate a transaction when add successfully.
            transactionService.addTransaction(user.getUsername(), user.getUsername() + " add a module called " + module.getTitle());
            response.setStatus(201);
            request.getRequestDispatcher("/module?method=getModule").forward(request,response);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print("<html><body><script type='text/javascript'>alert('code must be unique and form cannot have empty values except dependency!');window.history.go(-1)</script></body></html>");
            response.getWriter().close();
        }
    }
    public void getModule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display module list.
        try {
            ModuleService moduleService = new ModuleService();
            List<Module> moduleList = moduleService.getModuleList();
            if(moduleList!=null&&moduleList.size()>0){
                request.setAttribute("list",moduleList);
                request.getRequestDispatcher("/modules.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("/modules.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display module details.
        try {
            ModuleService moduleService = new ModuleService();
            String code = request.getParameter("code");
            Module module = moduleService.getM_array(code);
            request.setAttribute("module",module);
            request.getRequestDispatcher("/module_details.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateModule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Modify module.
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Module module=new Module();
            TransactionService transactionService = new TransactionService();
            BeanUtils.populate(module,parameterMap);
            ModuleService moduleService=new ModuleService();
            moduleService.updateModule(module);
            User user = (User)request.getSession().getAttribute("user");
            // Generate a transaction when update successfully.
            transactionService.addTransaction(user.getUsername(), user.getUsername() + " update a module called " + module.getTitle());
            response.sendRedirect(request.getContextPath()+"/module?method=getModule");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteModule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Delete Module.
        String code = request.getParameter("code");
        ModuleService moduleService=new ModuleService();
        TransactionService transactionService = new TransactionService();
        try {
            moduleService.deleteModule(code);
            User user = (User)request.getSession().getAttribute("user");
            // Generate a transaction when delete successfully.
            transactionService.addTransaction(user.getUsername(), user.getUsername() + " delete a module");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/module?method=getModule");
    }
}
