package net.teamx.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.teamx.bean.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {
    public User login(String username, String password) throws SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="select * from staff where username=? and password=?";
        User user = queryRunner.query(sql, new BeanHandler<User>(User.class),username,password);
        dataSource.close();
        return  user;
    }
}
