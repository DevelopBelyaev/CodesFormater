package com.mycompany.codesformatter.handlers;

import com.mycompany.codesformatter.formatter.FormatterContext;

/**
 *
 * @author nick
 */
public class SpaceHandler extends SpecialCharHandler{
    public SpaceHandler(char etalon, FormatterContext context) { 
        setEtalon(etalon);
        if(!context.containsKey("needSpace")) 
            context.setStateForKey((Boolean)true, "needSpace");
        if(!context.containsKey("isNewLine")) 
            context.setStateForKey((Boolean)true, "isNewLine");
    }

    @Override
    public String format(FormatterContext context) {
        boolean needSpace = (Boolean)context.getStateForKey("needSpace");
        boolean isNewLine = (Boolean)context.getStateForKey("isNewLine");
        String res = (needSpace && !isNewLine) ? " " : "";
        context.setStateForKey((Boolean)false, "needSpace");
        context.setStateForKey((Boolean)true, "isHandled");
        return res;
    }

}
