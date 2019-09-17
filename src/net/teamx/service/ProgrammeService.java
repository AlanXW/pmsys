package net.teamx.service;

import net.teamx.bean.Programme;
import net.teamx.dao.ProgrammeDao;

import java.sql.SQLException;
import java.util.List;

public class ProgrammeService {
    public void addProgramme(Programme programme) throws SQLException {
        ProgrammeDao programmeDao = new ProgrammeDao();
        programmeDao.addProgramme(programme);
    }

    public List<Programme> getProgrammeList() throws SQLException {
        ProgrammeDao programmeDao = new ProgrammeDao();
        return programmeDao.getProgrammeList();
    }

    public Programme getProgramme(String id) throws SQLException {
        ProgrammeDao programmeDao = new ProgrammeDao();
        return programmeDao.getProgramme(id);
    }

    public Programme getP_array(String id) throws SQLException {
        ProgrammeDao programmeDao = new ProgrammeDao();
        Programme programme = programmeDao.getProgramme(id);
        return programmeDao.getP_array(programme);
    }

    public void updateProgramme(Programme programme) throws SQLException {
        ProgrammeDao programmeDao = new ProgrammeDao();
        programmeDao.updateProgramme(programme);
    }

    public  void deleteProgramme(String id) throws SQLException {
        ProgrammeDao programmeDao = new ProgrammeDao();
        programmeDao.deleteProgramme(id);
    }
}
