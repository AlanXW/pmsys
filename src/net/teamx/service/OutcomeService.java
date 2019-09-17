package net.teamx.service;

import net.teamx.bean.Outcome;
import net.teamx.dao.OutcomeDao;

import java.sql.SQLException;
import java.util.List;

public class OutcomeService {
    public int addOutcome(String outcome) throws SQLException {
        OutcomeDao outcomeDao = new OutcomeDao();
        return outcomeDao.addOutcome(outcome);
    }
    public List<Outcome> getOutcomes() throws SQLException {
        OutcomeDao outcomeDao = new OutcomeDao();
        List<Outcome> outcomeList = outcomeDao.getOutcomes();
        return  outcomeList;
    }
}
