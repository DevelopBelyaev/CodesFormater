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
public class StringHandler extends SpecialCharHandler{
    public StringHandler(char etalon, FormatterContext context) {
        setEtalon(etalon);
        if(!context.containsKey("needHandle"))
            context.setStateForKey((Boolean)true, "needHandle");
    }
    @Override
    public String format(FormatterContext context) {
        String quotType = (String)context.getStateForKey("quotType");
        if(quotType == null || quotType.length() == 0) {
            context.setStateForKey((Boolean)false, "needHandle");
            context.setStateForKey("string", "quotType");
            context.setStateForKey((Boolean)true, "isHandled");
            return "\"";
        }
        if(quotType.equals("string")) {
            context.setStateForKey(null, "quotType");            
            context.setStateForKey((Boolean)true, "needHandle");
            context.setStateForKey((Boolean)true, "isHandled");
            return "\"";            
        }
        return "";
    } 
}
