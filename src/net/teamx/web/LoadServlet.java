package net.teamx.web;

import net.teamx.bean.Module;
import net.teamx.bean.Outcome;
import net.teamx.bean.Programme;
import net.teamx.service.ModuleService;
import net.teamx.service.OutcomeService;
import net.teamx.service.ProgrammeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
// This servlet is used to load add/update programme/module pages.
// Go through all outcomes and modules to generate check box and data in add/update programme/module pages.
@WebServlet(name = "LoadServlet",urlPatterns = "/load")
public class LoadServlet extends BaseServlet {
    public void loadPM(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ModuleService moduleService = new ModuleService();
        OutcomeService outcomeService = new OutcomeService();
        try {
            List<Module> moduleList = moduleService.getModuleList();
            List<Outcome> outcomeList = outcomeService.getOutcomes();
            request.setAttribute("module",moduleList);
            request.setAttribute("outcome",outcomeList);
            if(request.getParameter("object").equals("P")){
                request.getRequestDispatcher("/add_programmes.jsp").forward(request,response);
            }else if(request.getParameter("object").equals("M")){
                request.getRequestDispatcher("/add_modules.jsp").forward(request,response);
            }else{
                response.setContentType("text/html; charset=UTF-8");
                response.getWriter().print("<html><body><script type='text/javascript'>alert('Can not load the page!');window.history.go(-1)</script></body></html>");
                response.getWriter().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProgramme(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProgrammeService programmeService = new ProgrammeService();
            String id = request.getParameter("id");
            Programme programme = programmeService.getProgramme(id);
            request.setAttribute("programme",programme);
            request.getRequestDispatcher("/update_programme.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateModule(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ModuleService moduleService = new ModuleService();
            String code = request.getParameter("code");
            Module module = moduleService.getModule(code);
            request.setAttribute("module",module);
            request.getRequestDispatcher("/update_module.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
