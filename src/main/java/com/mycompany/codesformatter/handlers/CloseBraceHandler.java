package com.mycompany.codesformatter.handlers;

import com.mycompany.codesformatter.formatter.FormatterContext;
import com.mycompany.codesformatter.formatter.FormatException;

/**
 *
 * @author nick
 */
public class CloseBraceHandler extends SpecialCharHandler {
    public CloseBraceHandler(char etalon, FormatterContext context) {   
        setEtalon(etalon);
        if(!context.containsKey("needTabing")) 
            context.setStateForKey((Boolean)true, "needTabing");
        if(!context.containsKey("isNewLine")) 
            context.setStateForKey((Boolean)true, "isNewLine");
        if(!context.containsKey("level")) 
            context.setStateForKey((Integer)0, "level");
    }
    @Override
    String format(FormatterContext context) throws FormatException {
        if(!context.containsKey("level")) return "";
        int level = (Integer)context.getStateForKey("level");
        if (level == 0) {
            throw new FormatException("Syntax error around '}'");
        }
        context.setStateForKey(--level, "level");
        context.setStateForKey((Boolean)false, "needTabing"); 
        String result = Tabulator.tabing(level)
                .append("}\n").toString();
        boolean isNewLine = (Boolean)context.getStateForKey("isNewLine");
        if(!isNewLine) result = "\n" + result;
        context.setStateForKey((Boolean)true, "isNewLine");
        context.setStateForKey((Boolean)true, "isHandled");
        return result;
    }

}
