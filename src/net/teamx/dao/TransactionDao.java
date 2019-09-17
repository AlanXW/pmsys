package net.teamx.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.teamx.bean.Transaction;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class TransactionDao {
    public void addTransaction(String username, String description) throws SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="insert into transaction values(null,?,?,?,?)";
        queryRunner.update(sql,new Date(),username,description,"successful");
        dataSource.close();
    }

    public List<Transaction> getTransactionList() throws SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql = "select * from transaction order by id desc";
        List<Transaction> transactionList = queryRunner.query(sql,new BeanListHandler<Transaction>(Transaction.class));
        dataSource.close();
        return transactionList;
    }
}
