package com.mycompany.codesformatter.formatter;
import com.mycompany.codesformatter.writers.StreamWriter;
import com.mycompany.codesformatter.readers.StreamReader;
import com.mycompany.codesformatter.readers.ReaderException;
import com.mycompany.codesformatter.writers.WriterException;
import com.mycompany.codesformatter.conextManagers.ContextHandler;
import java.util.List;

/**
 *
 * @author nick
 */
public class Formatter {

   // List<CharHandler> handlers;
    ContextHandler contextHandler;
    public Formatter(ContextHandler handler) throws FormatException {
        try {
            handler.getClass();
        } catch (Exception e) {
            throw new FormatException("handlers was not passed");
        }
        contextHandler = handler;
    }
    
    public void format(StreamReader reader, StreamWriter writter, FormatterContext context) throws
            ReaderException, WriterException, FormatException {
       // FormatterContext context = theContext;
        //managersMap.put(" ", new SpaceManager());
        try{
            reader.getClass();
        } catch(NullPointerException e) {
            throw new ReaderException("reader was not passed");    
        }
        try{
            writter.getClass();
        } catch(NullPointerException e) {
            throw new WriterException("writer was not passed");
        }
        while (reader.hasNext()) {
            writter.pushString(contextHandler.handle(reader.next(), context));
        }
        /*
        try{
            theContext.getClass();
        } catch(NullPointerException e) {
            throw new FormatException("Context was not initialized");
        }
        
        while (reader.hasNext()) {
            reader.next();
           
            
            for (CharHandler handler: handlers) {
                writter.pushString(handler.handle(nextChar.charAt(0), context));
            }
        }
               
        if((Integer)context.getStateForKey("level") != 0) 
            throw new FormatException("Syntax error arround '{");*/
    }
}
