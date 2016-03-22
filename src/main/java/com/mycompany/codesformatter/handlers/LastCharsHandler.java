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
public class LastCharsHandler implements CharHandler{
    int lastCharsCount;
    public LastCharsHandler(FormatterContext context, int lastCharsCount) {
        StringBuilder initialString = new StringBuilder();
        this.lastCharsCount = lastCharsCount;
        for(int i = 0; i < lastCharsCount; i++) initialString.append(" ");
        context.setStateForKey(initialString.toString(), "lastChars");
    }
    
    @Override
    public String handle(char nextChar, FormatterContext context) throws FormatException {
        String last = (String)context.getStateForKey("lastChars") + nextChar;
        context.setStateForKey(
                last.substring(last.length() - lastCharsCount), "lastChars");
        return "";
    }
    
    
}
