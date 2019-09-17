package net.teamx.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import net.teamx.bean.Module;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class ModuleDao {
    public void addModule(Module module) throws SQLException{
        String assessment = String.join(",", Arrays.asList(module.getAssessment()));
        String dependency = null;
        // Dependency is allowed to be null.
        if (module.getDependency() != null)
            dependency = String.join(",", Arrays.asList(module.getDependency()));
        String outcomes = String.join(",", Arrays.asList(module.getOutcomes()));
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="insert into module values(?,?,?,?,?,?,?,?,?,?,?)";
        queryRunner.update(sql,module.getCode(),module.getTitle(),module.getLevel(),module.getSemester(),module.getCoordinator(),module.getDepartment(),module.getFaculty(),module.getCredit(),assessment,dependency,outcomes);
        dataSource.close();
    }

    public List<Module> getModuleList() throws SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="select code,title,level,semester,coordinator,department,faculty,credit from module";
        List<Module> moduleList = queryRunner.query(sql,new BeanListHandler<Module>(Module.class));
        dataSource.close();
        return moduleList;
    }

    public Module getModule(String code) throws SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="select code,title,level,semester,coordinator,department,faculty,credit from module where code=?";
        Module module = queryRunner.query(sql,new BeanListHandler<Module>(Module.class),code).get(0);
        dataSource.close();
        return module;
    }

    public Module getM_array(Module module) throws SQLException {
        // Get assessment, dependency and outcomes in module and convert string into string array.
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql1="select assessment from module where code=?";
        String sql2="select dependency from module where code=?";
        String sql3="select outcomes from module where code=?";
        String m_assessments = queryRunner.query(sql1,new ScalarHandler(),module.getCode()).toString();
        String m_dependencies = null;
        if (queryRunner.query(sql2,new ScalarHandler(),module.getCode()) != null)
            m_dependencies = queryRunner.query(sql2,new ScalarHandler(),module.getCode()).toString();
        String m_outcomes = queryRunner.query(sql3,new ScalarHandler(),module.getCode()).toString();
        module.setAssessment(m_assessments.split(","));
        // Dependency is allowed to be null.
        if (m_dependencies != null)
            module.setDependency(m_dependencies.split(","));
        module.setOutcomes(m_outcomes.split(","));
        dataSource.close();
        return module;
    }

    public void updateModule(Module module) throws SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="update module set title=?,level=?,semester=?,coordinator=?,department=?,faculty=?,credit=? where code=?";
        queryRunner.update(sql,module.getTitle(),module.getLevel(),module.getSemester(),module.getCoordinator(),module.getDepartment(),module.getFaculty(),module.getCredit(),module.getCode());
        dataSource.close();
    }

    public void deleteModule(String code) throws SQLException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        QueryRunner queryRunner=new QueryRunner(dataSource);
        String sql="delete from module where code=?";
        queryRunner.update(sql,code);
        dataSource.close();
    }
}
