package net.teamx.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.teamx.bean.Outcome;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.SQLException;
import java.util.List;

public class OutcomeDao {
    public int addOutcome(String outcome) throws SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="insert into outcome values(1,?)";
        int row = queryRunner.update(sql,outcome);
        dataSource.close();
        return row;
    }

    public List<Outcome> getOutcomes() throws SQLException{
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="select * from outcome";
        List<Outcome> outcomeList = queryRunner.query(sql,new BeanListHandler<Outcome>(Outcome.class));
        dataSource.close();
        return outcomeList;
    }
}
