package models.validators;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import models.Kakeibo;

public class KakeiboValidator {
    public static List<String> validate(Kakeibo k) {
        List<String> errors = new ArrayList<String>();

        String kakeibo_date_error = _validateKakeibo_date(k.getKakeibo_date());
        if(!kakeibo_date_error.equals("")) {
            errors.add(kakeibo_date_error);
        }



        return errors;
    }

    private static String _validateKakeibo_date(Date kakeibo_date) {
        if(kakeibo_date == null || kakeibo_date.equals("")) {
            return "タイトルを入力してください。";
            }

        return "";
    }}