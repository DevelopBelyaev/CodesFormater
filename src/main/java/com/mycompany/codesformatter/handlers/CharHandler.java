package com.mycompany.codesformatter.handlers;

import com.mycompany.codesformatter.formatter.FormatterContext;
import com.mycompany.codesformatter.formatter.FormatException;

/**
 *
 * @author nick
 */
public interface CharHandler {

    /**
     *
     * @param nextChar char should be handle
     * @param context the state of formater
     * @return string as result formating
     * @throws com.mycompany.codesformatter.formatter.FormatException if code has synax error
     */
    
    public String handle(char nextChar, FormatterContext context)throws FormatException;
}
