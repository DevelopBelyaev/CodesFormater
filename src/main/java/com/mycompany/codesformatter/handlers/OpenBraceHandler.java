/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codesformatter.handlers;

import com.mycompany.codesformatter.formatter.FormatterContext;

/**
 *
 * @author nick
 */
public class OpenBraceHandler extends SpecialCharHandler{
    public OpenBraceHandler(char etalon, FormatterContext context) {
        setEtalon(etalon);
            context.setStateForKey((Boolean)true, "needHandle");
        if(!context.containsKey("needTabing")) 
            context.setStateForKey((Boolean)true, "needTabing");
        if(!context.containsKey("isNewLine")) 
            context.setStateForKey((Boolean)true, "isNewLine");
        if(!context.containsKey("level")) 
            context.setStateForKey((Integer)0, "level");
    }

    @Override
    public String format(FormatterContext context) {
        context.setStateForKey((Boolean)false, "needTabing");
        int level = (Integer)context.getStateForKey("level");
        boolean isNewLine = (Boolean)context.getStateForKey("isNewLine");
        String result = (isNewLine)? Tabulator.tabing(level).append("{\n").toString(): "{\n";
        context.setStateForKey(++level, "level");
        context.setStateForKey((Boolean)true, "isNewLine");
        context.setStateForKey((Boolean)true, "isHandled");
        return result;
    }

}
