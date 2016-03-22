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
public class ResetContextHandler implements CharHandler{

    @Override
    public String handle(char nextChar, FormatterContext context) {
        context.setStateForKey((Boolean)false, "isHandled");
        return "";
    }
    
}
