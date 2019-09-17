package net.teamx.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.teamx.bean.Programme;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ProgrammeDao {
    public void addProgramme(Programme programme) throws SQLException {
        String outcomes = String.join(",", Arrays.asList(programme.getOutcomes()));
        String core_modules = String.join(",", Arrays.asList(programme.getCore_modules()));
        String optional_modules = String.join(",", Arrays.asList(programme.getOptional_modules()));
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="insert into programme values(1,?,?,?,?,?,?,?,?,?,?,?)";
        queryRunner.update(sql,programme.getTitle(),programme.getProposer(),programme.getLevel(),programme.getType(),programme.getAdmin(),programme.getDepartment(),programme.getFaculty(),programme.getRequirements(),outcomes,core_modules,optional_modules);
        dataSource.close();
    }

    public List<Programme> getProgrammeList() throws SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="select id,title,proposer,level,type,admin,department,faculty,requirements from programme";
        List<Programme> programmeList = queryRunner.query(sql,new BeanListHandler<Programme>(Programme.class));
        dataSource.close();
        return programmeList;
    }

    public Programme getP_array(Programme programme) throws SQLException {
        // Get outcomes, core modules and optional modules in programme and convert string into string array.
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql1="select outcomes from programme where id=?";
        String sql2="select core_modules from programme where id=?";
        String sql3="select optional_modules from programme where id=?";
        String p_outcomes = queryRunner.query(sql1,new ScalarHandler(),programme.getId()).toString();
        String p_core_modules = queryRunner.query(sql2,new ScalarHandler(),programme.getId()).toString();
        String p_optional_modules = queryRunner.query(sql3,new ScalarHandler(),programme.getId()).toString();
        programme.setOutcomes(p_outcomes.split(","));
        programme.setCore_modules(p_core_modules.split(","));
        programme.setOptional_modules(p_optional_modules.split(","));
        dataSource.close();
        return programme;
    }

    public Programme getProgramme(String id) throws SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="select id,title,proposer,level,type,admin,department,faculty,requirements from programme where id=?";
        Programme programme = queryRunner.query(sql,new BeanListHandler<Programme>(Programme.class),id).get(0);
        dataSource.close();
        return programme;
    }

    public void updateProgramme(Programme programme) throws SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="update programme set title=?,proposer=?,level=?,type=?,admin=?,department=?,faculty=?,requirements=? where id=?";
        queryRunner.update(sql,programme.getTitle(),programme.getProposer(),programme.getLevel(),programme.getType(),programme.getAdmin(),programme.getDepartment(),programme.getFaculty(),programme.getRequirements(),programme.getId());
        dataSource.close();
    }

    public void deleteProgramme(String id) throws SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="delete from programme where id=?";
        queryRunner.update(sql,id);
        dataSource.close();
    }
}
