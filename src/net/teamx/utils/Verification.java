package net.teamx.utils;

import net.teamx.bean.Module;
import net.teamx.bean.Programme;
import net.teamx.service.ModuleService;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
// Verification tool.
public class Verification {
// Verify repetition of core and optional modules in the same programme.
    public boolean repeat(Programme programme){
        String[] a = programme.getCore_modules();
        String[] b = programme.getOptional_modules();
        HashSet<String> set = new HashSet<>(Arrays.asList(a));
        set.retainAll(Arrays.asList(b));
        if(set.size() > 0)
            return false;
        else
            return true;
    }
// Verify whether the outcomes of program are duplicated or missing.
    public String mismatch(Programme programme){
        ModuleService moduleService = new ModuleService();
        StringUtils stringUtils = new StringUtils();
        String[] existOutcomes = null;
        try {
            int i = 0;
            for (String item : stringUtils.concat(programme.getCore_modules(),programme.getOptional_modules())){
                String code = item.substring(0,item.indexOf(" "));
                Module module = moduleService.getM_array(code);
                if(i==0)
                    existOutcomes = module.getOutcomes();
                else
                    existOutcomes = stringUtils.concat(existOutcomes, module.getOutcomes());
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (String item : programme.getOutcomes()){
            int count = 0;
            for (String outcome : existOutcomes){
                if(outcome.equals(item)) count++;
            }
            if(count == 0){
                return ("The modules selected must contribute this outcome: " + item);
            }else if(count > 5){
                return ("Many modules contribute duplicate outcome: " + item);
            }
        }
        return "Go";
    }
}
