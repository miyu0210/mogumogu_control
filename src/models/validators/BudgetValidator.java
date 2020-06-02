package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Budget;

public class BudgetValidator {
    public static List<String> validate(Budget b) {
        List<String> errors = new ArrayList<String>();
        
        String startday_error = _validateStartday(b.getStartday());
        if(!startday_error.equals("")) {
            errors.add(startday_error);
        }
        
        return errors;
    }
    
    private static String _validateStartday(String startday) {
        if(startday == null || startday.equals("")) {
            return "開始日を入力してください。";
        }
        
        return "";
    }
}
