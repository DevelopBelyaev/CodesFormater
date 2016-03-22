package com.mycompany.codesformatter.handlers;

import com.mycompany.codesformatter.formatter.FormatterContext;

/**
 *
 * @author nick
 */
public class NewLineHandler extends SpecialCharHandler{
    public NewLineHandler(char etalon, FormatterContext context) {  
        setEtalon(etalon);
        if(!context.containsKey("needHandle")) 
            context.setStateForKey((Boolean)true, "needHandle");
    }

    @Override
    public String format(FormatterContext context) {
        boolean needHandle = (Boolean)context.getStateForKey("needHandle");
        context.setStateForKey((Boolean)true, "isHandled");
        if(needHandle) return "";
        return ""+'\n';
    }
        
}
