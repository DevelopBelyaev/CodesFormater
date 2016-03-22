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
public class SimpleCharHandler implements CharHandler{
    public SimpleCharHandler(FormatterContext context){
        if(!context.containsKey("isHandeled")) 
            context.setStateForKey((Boolean)false, "isHandled");
        if(!context.containsKey("needHandle")) 
            context.setStateForKey((Boolean)true, "needHandle");
        if(!context.containsKey("needTabing")) 
            context.setStateForKey((Boolean)true, "needTabing");
        if(!context.containsKey("isNewLine")) 
            context.setStateForKey((Boolean)true, "isNewLine");
        if(!context.containsKey("level")) 
            context.setStateForKey((Integer)0, "level");
    }


    @Override
    public String handle(char nextChar, FormatterContext context) throws FormatException {
        boolean isHandled = (Boolean)context.getStateForKey("isHandled");
        if(isHandled) return "";
        boolean needHandle = (Boolean)context.getStateForKey("needHandle");
        if(!needHandle) return "" + nextChar;
        context.setStateForKey((Boolean)true, "needTabing"); 
        boolean isNewLine = (Boolean)context.getStateForKey("isNewLine");
        int level = (Integer)context.getStateForKey("level");
        context.setStateForKey((Boolean)true, "needSpace");
        String result = (isNewLine)?
            Tabulator.tabing(level).append(nextChar)
                .toString():"" + nextChar; 
        context.setStateForKey((Boolean)false, "isNewLine");
        return result;
    }
    
}
