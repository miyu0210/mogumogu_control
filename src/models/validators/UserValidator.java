package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.User;
import utils.DBUtil;

public class UserValidator {
    public static List<String> validate(User u, Boolean mail_duplicate_check_flag, Boolean password_check_flag) {
        List<String> errors = new ArrayList<String>();
        
        String mail_error = _validateMail(u.getMail(), mail_duplicate_check_flag);
        if(!mail_error.equals("")) {
            errors.add(mail_error);
        }
        
        String password_error = _validatePassword(u.getPassword(), password_check_flag);
        if(!password_error.equals("")) {
            errors.add(password_error);
        }
        
        return errors;
    }
    
    //　メールアドレス
    private static String _validateMail(String mail, Boolean mail_duplicate_check_flag) {
        //　必須入力チェック
        if(mail == null || mail.equals("")) {
            return "メールアドレスを入力してください。";
        }
        
        //　すでに登録されているメールアドレスとの重複チェック
        if(mail_duplicate_check_flag) {
            EntityManager em = DBUtil.createEntityManager();
            long user_count = (long)em.createNamedQuery("checkRegisteredMail", Long.class)
                                        .setParameter("mail", mail)
                                        .getSingleResult();
            em.close();
            if(user_count > 0) {
                return "入力されたメールアドレスの情報はすでに存在しています。";
            }
        }
        
        return "";
    }
    
    // パスワードの必須入力チェック
    private static String _validatePassword(String password, Boolean password_check_flag) {
        //　パスワードを変更する場合のみ実行
        if(password_check_flag && (password == null || password.equals(""))) {
            return "パスワードを入力してください。";
        }
        return "";
    }
}
