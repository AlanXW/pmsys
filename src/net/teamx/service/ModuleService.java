package net.teamx.service;

import net.teamx.bean.Module;
import net.teamx.dao.ModuleDao;

import java.sql.SQLException;
import java.util.List;

public class ModuleService {

    public void addModule(Module module) throws SQLException {
        ModuleDao moduleDao = new ModuleDao();
        moduleDao.addModule(module);
    }

    public List<Module> getModuleList() throws SQLException {
        ModuleDao moduleDao = new ModuleDao();
        return moduleDao.getModuleList();
    }

    public Module getModule(String code) throws SQLException {
        ModuleDao moduleDao = new ModuleDao();
        return moduleDao.getModule(code);
    }

    public Module getM_array(String code) throws SQLException {
        ModuleDao moduleDao = new ModuleDao();
        Module module = moduleDao.getModule(code);
        return moduleDao.getM_array(module);
    }

    public void updateModule(Module module) throws SQLException {
        ModuleDao moduleDao = new ModuleDao();
        moduleDao.updateModule(module);
    }

    public  void deleteModule(String code) throws SQLException {
        ModuleDao moduleDao = new ModuleDao();
        moduleDao.deleteModule(code);
    }
}
