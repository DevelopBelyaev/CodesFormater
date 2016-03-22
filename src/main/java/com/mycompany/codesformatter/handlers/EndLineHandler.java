package com.mycompany.codesformatter.handlers;

import com.mycompany.codesformatter.formatter.FormatterContext;

/**
 *
 * @author nick
 */
public class EndLineHandler extends SpecialCharHandler{
    public EndLineHandler(char etalon, FormatterContext context) { 
        setEtalon(etalon);
        if(!context.containsKey("needTabing")) 
            context.setStateForKey((Boolean)true, "needTabing");
        if(!context.containsKey("isNewLine")) 
            context.setStateForKey((Boolean)true, "isNewLine");
    }
    @Override
    public String format(FormatterContext context) {
        context.setStateForKey((Boolean)false, "needTabing");
        context.setStateForKey((Boolean)true, "isNewLine");
        context.setStateForKey((Boolean)true, "isHandled");
        return ";\n";
    }
        
}
