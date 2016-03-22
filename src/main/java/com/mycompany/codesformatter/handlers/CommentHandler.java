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
public class CommentHandler implements CharHandler{
    public CommentHandler(FormatterContext context) {
        if(!context.containsKey("lastChars"))
            context.setStateForKey("  ", "lastChars");
    }
    
    @Override
    public String handle(char nextChar, FormatterContext context)throws FormatException {
        String lastChars = (String)context.getStateForKey("lastChars");
        String twoLast = lastChars.substring(lastChars.length()-2);
        String quotType = (String)context.getStateForKey("quotType");
        if(twoLast.equals("/*") && 
                (quotType == null || quotType.length() == 0)) {
            context.setStateForKey((Boolean)false, "needHandle");
            context.setStateForKey("comment", "quotType");
            context.setStateForKey((Boolean)true, "isHandled");
            return "*";
        }
        if(twoLast.equals("*/") && quotType.equals("comment")) {
            context.setStateForKey(null, "quotType");            
            context.setStateForKey((Boolean)true, "needHandle");
            context.setStateForKey((Boolean)true, "isHandled");
            return "/";            
        }
        return "";
    }
}
