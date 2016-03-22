/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codesformatter;

import com.mycompany.codesformatter.formatter.FormatException;
import com.mycompany.codesformatter.formatter.Formatter;
import com.mycompany.codesformatter.formatter.FormatterContext;
import com.mycompany.codesformatter.readers.StreamReader;
import com.mycompany.codesformatter.readers.ReaderException;
import com.mycompany.codesformatter.writers.WriterException;
import com.mycompany.codesformatter.writers.StringStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nick
 */
public class CodeFormat {

    public static void main(String[] args) {
        //StreamReader reader;
        ObjectsFactory factory = new SpringObjectsFactory(new String[] {"config.xml"});
        StreamReader reader = (StreamReader)factory.getObjectFromClass("streamReader");
        StringStreamWriter writer = new StringStreamWriter(); //(StreamWriter)factory.getObjectFromClass("streamWriter");
        if(reader == null) {
            Logger.getLogger(CodeFormat.class.getName()).log(Level.SEVERE, null, "Cannot open the file");
            return;
        }
        
        Formatter formater = (Formatter)factory.getObjectFromClass("formatter");
        FormatterContext context = (FormatterContext)factory.getObjectFromClass("context");
        try {
            formater.format(reader, writer, context);
        }catch (ReaderException | WriterException | FormatException ex) {
            Logger.getLogger(CodeFormat.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(writer.getWriting());
        try {
            reader.close();
        } catch (ReaderException ex) {
            Logger.getLogger(Formatter.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            writer.close();
        } catch (WriterException ex) {
            Logger.getLogger(Formatter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    



