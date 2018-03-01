package com.anlu.springmvc.convert;

import org.springframework.expression.ParseException;

import java.beans.PropertyEditorSupport;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(text);
            setValue(date);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }
}
