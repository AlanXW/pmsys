package net.teamx.service;

import net.teamx.bean.Transaction;
import net.teamx.dao.TransactionDao;

import java.sql.SQLException;
import java.util.List;

public class TransactionService {
    public void addTransaction(String username, String description) throws SQLException {
        TransactionDao transactionDao = new TransactionDao();
        transactionDao.addTransaction(username, description);
    }

    public List<Transaction> getTransactionList() throws SQLException {
        TransactionDao transactionDao = new TransactionDao();
        List<Transaction> transactionList = transactionDao.getTransactionList();
        return transactionList;
    }
}
