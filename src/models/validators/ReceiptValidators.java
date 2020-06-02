package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Receipt;

public class ReceiptValidators {
    public static List<String> validate(Receipt r) {
        List<String> errors = new ArrayList<String>();
        
        String payment_error = _validatePayment(r.getPayment());
            if(!payment_error.equals("")) {
                errors.add(payment_error);
            }
        
        return errors;
        
    }
    
    private static String _validatePayment(String payment) {
        if(payment == null || payment.equals("")) {
            return "決済方法を入力してください。";
        }
        
        return "";
    }
}
