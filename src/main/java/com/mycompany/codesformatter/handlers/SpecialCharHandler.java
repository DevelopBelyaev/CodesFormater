/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codesformatter.handlers;

import com.mycompany.codesformatter.formatter.FormatException;
import com.mycompany.codesformatter.formatter.FormatterContext;

/**
 *
 * @author nick
 */
public abstract class SpecialCharHandler implements CharHandler{
    private char etalon;
    
    public void setEtalon(char etalon) {
        this.etalon = etalon;
    }
    @Override 
    public String handle(char nextChar, FormatterContext context)throws FormatException {
        if(nextChar != etalon) return "";
        boolean isHandled = (Boolean)context.getStateForKey("isHandled");
        if(isHandled) return "";
        context.setStateForKey((Boolean)true, "needTabing");
        String result = format(context);
        boolean needHandle = (Boolean)context.getStateForKey("needHandle");
        if(!needHandle) return ""+nextChar;
        boolean isNewLine = (Boolean)context.getStateForKey("isNewLine");
        boolean needTabing = (Boolean)context.getStateForKey("needTabing");
        int level = (Integer)context.getStateForKey("level");
        String shift = (isNewLine && needTabing)? 
                Tabulator.tabing(level).toString(): "";
        if(result.length() == 0) return "";
        return shift + result;
    }

    abstract String format(FormatterContext context) throws FormatException;
    
}
