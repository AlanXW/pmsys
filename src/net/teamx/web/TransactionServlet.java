package net.teamx.web;

import net.teamx.bean.Transaction;
import net.teamx.service.TransactionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TransactionServlet",urlPatterns = "/transaction")
public class TransactionServlet extends BaseServlet {
    public void getTransaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Display transactions.
        try {
            TransactionService transactionService = new TransactionService();
            List<Transaction> transactionList = transactionService.getTransactionList();
            if(transactionList!=null&&transactionList.size()>0){
                request.setAttribute("list",transactionList);
                request.getRequestDispatcher("/transactions.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("/transactions.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
