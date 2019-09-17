package net.teamx.web;

import net.teamx.bean.Module;
import net.teamx.bean.Programme;
import net.teamx.bean.User;
import net.teamx.service.ModuleService;
import net.teamx.service.ProgrammeService;
import net.teamx.service.TransactionService;
import net.teamx.utils.StringUtils;
import net.teamx.utils.Verification;
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

@WebServlet(name = "ProgrammeServlet",urlPatterns = "/programme")
public class ProgrammeServlet extends BaseServlet {
    public void addProgramme(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Add programme.
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Programme programme = new Programme();
            BeanUtils.populate(programme,parameterMap);
            Verification verification = new Verification();
            if(programme.getCore_modules()!=null&&programme.getOptional_modules()!=null) {
                // Verify repetition of core and optional modules in the same programme.
                if (verification.repeat(programme)) {
                    // Verify whether the outcomes of program are duplicated or missing.
                    String mm = verification.mismatch(programme);
                    // "Go" means validation successfully, otherwise error messages will be displayed.
                    if (mm.equals("Go")) {
                        ProgrammeService programmeService = new ProgrammeService();
                        programmeService.addProgramme(programme);
                        TransactionService transactionService = new TransactionService();
                        User user = (User) request.getSession().getAttribute("user");
                        // Generate a transaction when add successfully.
                        transactionService.addTransaction(user.getUsername(), user.getUsername() + " add a programme called " + programme.getTitle());
                        response.setStatus(201);
                        request.getRequestDispatcher("/programme?method=getProgramme").forward(request, response);
                    } else {
                        // Display error messages.
                        response.setContentType("text/html; charset=UTF-8");
                        response.getWriter().print("<html><body><script type='text/javascript'>alert('" + mm + "');window.history.go(-1)</script></body></html>");
                        response.getWriter().close();
                    }

                } else {
                    response.setContentType("text/html; charset=UTF-8");
                    response.getWriter().print("<html><body><script type='text/javascript'>alert('The core and optional modules cannot be repeated!');window.history.go(-1)</script></body></html>");
                    response.getWriter().close();
                }
            }else{
                response.setContentType("text/html; charset=UTF-8");
                response.getWriter().print("<html><body><script type='text/javascript'>alert('Core and Optional modules cannot be null!');window.history.go(-1)</script></body></html>");
                response.getWriter().close();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().print("<html><body><script type='text/javascript'>alert('Form cannot have empty values!');window.history.go(-1)</script></body></html>");
            response.getWriter().close();
        }
    }
    public void getProgramme(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display Programme list.
        try {
            ProgrammeService programmeService = new ProgrammeService();
            List<Programme> programmeList = programmeService.getProgrammeList();
            if(programmeList!=null&&programmeList.size()>0){
                request.setAttribute("list",programmeList);
                request.getRequestDispatcher("/programmes.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("/programmes.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display Programme details.
        try {
            ProgrammeService programmeService = new ProgrammeService();
            String id = request.getParameter("id");
            Programme programme = programmeService.getP_array(id);
            request.setAttribute("programme",programme);
            request.getRequestDispatcher("/programme_details.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateProgramme(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Modify programme.
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Programme programme = new Programme();
            BeanUtils.populate(programme,parameterMap);
            ProgrammeService programmeService=new ProgrammeService();
            programmeService.updateProgramme(programme);
            TransactionService transactionService = new TransactionService();
            User user = (User)request.getSession().getAttribute("user");
            // Generate a transaction when update successfully.
            transactionService.addTransaction(user.getUsername(), user.getUsername() + " update a programme called " + programme.getTitle());
            response.sendRedirect(request.getContextPath()+"/programme?method=getProgramme");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getRelationship (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // This method is used to generate relationship data for relationship diagram.
        try {
            ProgrammeService programmeService = new ProgrammeService();
            ModuleService moduleService = new ModuleService();
            StringUtils stringUtils = new StringUtils();
            // Generate json.
            String json = "links = [";
            String id = request.getParameter("id");
            Programme programme = programmeService.getP_array(id);
            // Connect core and optional modules to one string array.
            for (String item : stringUtils.concat(programme.getCore_modules(),programme.getOptional_modules())){
                // Get module code.
                String code = item.substring(0,item.indexOf(" "));
                Module module = moduleService.getM_array(code);
                if(module.getDependency() != null)
                    for(String temp : module.getDependency()){
                        if(!temp.equals("NULL")){
                            String dependency = temp.substring(temp.indexOf(" ")+1);
                            json = json + "{ source: '" + module.getTitle() + "', target: '" + dependency + "', type: 'depend' },";
                        }
                    }
                for(String outcome : module.getOutcomes()){
                    json = json + "{ source: '" + module.getTitle() + "', target: '" + outcome + "', type: 'contribute' },";
                }
            }
            json = json.substring(0,json.length()-1);
            json = json + "]";
            // Send json to front-end by request.
            request.setAttribute("json",json);
            request.getRequestDispatcher("/relationship.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteProgramme(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Delete programme.
        String id = request.getParameter("id");
        ProgrammeService programmeService = new ProgrammeService();
        try {
            programmeService.deleteProgramme(id);
            TransactionService transactionService = new TransactionService();
            User user = (User)request.getSession().getAttribute("user");
            // Generate a transaction when delete successfully.
            transactionService.addTransaction(user.getUsername(), user.getUsername() + " delete a programme");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect(request.getContextPath()+"/programme?method=getProgramme");
    }

}
