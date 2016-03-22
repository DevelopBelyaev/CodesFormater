package com.mycompany.codesformater.Tests;

import com.mycompany.codesformatter.ObjectsFactory;
import com.mycompany.codesformatter.SpringObjectsFactory;
import com.mycompany.codesformatter.handlers.EndLineHandler;
import com.mycompany.codesformatter.handlers.SpaceHandler;
import com.mycompany.codesformatter.handlers.NewLineHandler;
import com.mycompany.codesformatter.handlers.CloseBraceHandler;
import com.mycompany.codesformatter.handlers.OpenBraceHandler;
import com.mycompany.codesformatter.formatter.Formatter;
import com.mycompany.codesformatter.formatter.FormatterState;
import com.mycompany.codesformatter.formatter.FormatException;
import com.mycompany.codesformatter.readers.ReaderException;
import com.mycompany.codesformatter.writers.WriterException;
import com.mycompany.codesformatter.readers.StreamReader;
import com.mycompany.codesformatter.readers.StringStreamReader;
import com.mycompany.codesformatter.writers.StringStreamWriter;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author nick
 */
public class HandlersTest {
    
    public HandlersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void spaceTest(){
        ObjectsFactory factory = new SpringObjectsFactory(new String[]{"config.xml"});
        FormatterState context = (FormatterState)factory.getObjectFromClass("context");
        Formatter formatter = (Formatter)factory.getObjectFromClass("formatter");
        
        StreamReader reader = null;
        StringStreamWriter writer = new StringStreamWriter();
        try {
            reader = new StringStreamReader("  abcd e   f");
        } catch (ReaderException ex) {
            assert false;
        }
        try {
            formatter.format(reader, writer, context);
        } catch (ReaderException | WriterException | FormatException ex) {
            assert false;
        }
        assert(writer.getWriting().equals("abcd e f"));
    }
    @Test
    public void newLineTest(){
        ObjectsFactory factory = new SpringObjectsFactory(new String[]{"config.xml"});
        FormatterState context = (FormatterState)factory.getObjectFromClass("context");
        Formatter formatter = (Formatter)factory.getObjectFromClass("formatter");
        
        StreamReader reader = null;
        StringStreamWriter writer = new StringStreamWriter();
        try {
            reader = new StringStreamReader("abcd"+'\n'+"efg");
        } catch (ReaderException ex) {
            assert false;
        }
        try {
            formatter.format(reader, writer, context);
        } catch (ReaderException | WriterException | FormatException ex) {
            assert false;
        }
        assert writer.getWriting().equals("abcdefg");
    }
    @Test
    public void endLineTest(){
        ObjectsFactory factory = new SpringObjectsFactory(new String[]{"config.xml"});
        FormatterState context = (FormatterState)factory.getObjectFromClass("context");
        Formatter formatter = (Formatter)factory.getObjectFromClass("formatter");
        
        StreamReader reader = null;
        StringStreamWriter writer = new StringStreamWriter();
        try {
            reader = new StringStreamReader("abcd;efg");
        } catch (ReaderException ex) {
            assert false;
        }
        try {
            formatter.format(reader, writer, context);
        } catch (ReaderException | WriterException | FormatException ex) {
            assert false;
        }
        assert(writer.getWriting().equals("abcd;\nefg"));
    }
    @Test
    public void braceTest(){
        ObjectsFactory factory = new SpringObjectsFactory(new String[]{"config.xml"});
        FormatterState context = (FormatterState)factory.getObjectFromClass("context");
        Formatter formatter = (Formatter)factory.getObjectFromClass("formatter");
        
        StreamReader reader = null;
        StringStreamWriter writer = new StringStreamWriter();
        try {
            reader = new StringStreamReader("abc{def}g");
        } catch (ReaderException ex) {
            assert false;
        }
        try {
            formatter.format(reader, writer, context);
        } catch (ReaderException | WriterException | FormatException ex) {
            assert false;
        }
        assert(writer.getWriting().equals("abc{\n  def\n}\ng"));
    }
    @Test
    public void openBraceErrorTest(){
        ObjectsFactory factory = new SpringObjectsFactory(new String[]{"config.xml"});
        FormatterState context = (FormatterState)factory.getObjectFromClass("context");
        Formatter formatter = (Formatter)factory.getObjectFromClass("formatter");
        
        StreamReader reader = null;
        StringStreamWriter writer = new StringStreamWriter();
        try {
            reader = new StringStreamReader("abc{defg");
        } catch (ReaderException ex) {
            assert false;
        }
        try {
            formatter.format(reader, writer, context);
        } catch (ReaderException | WriterException ex) {
            assert false;
        } catch (FormatException ex)
        {
            assert true;
        }
    }
    @Test
    public void closeBraceErrorTest(){
        ObjectsFactory factory = new SpringObjectsFactory(new String[]{"config.xml"});
        FormatterState context = (FormatterState)factory.getObjectFromClass("context");
        Formatter formatter = (Formatter)factory.getObjectFromClass("formatter");
        
        StreamReader reader = null;
        StringStreamWriter writer = new StringStreamWriter();
        try {
            reader = new StringStreamReader("abcdef}g");
        } catch (ReaderException ex) {
            assert false;
        }
        try {
            formatter.format(reader, writer, context);
        } catch (ReaderException | WriterException ex) {
            assert false;
        } catch (FormatException ex)
        {
            assert true;
        }
    }
    @Test
    public void commentTest() {
        ObjectsFactory factory = new SpringObjectsFactory(new String[]{"config.xml"});
        FormatterState context = (FormatterState)factory.getObjectFromClass("context");
        Formatter formatter = (Formatter)factory.getObjectFromClass("formatter");
        
        StreamReader reader = null;
        StringStreamWriter writer = new StringStreamWriter();
        try {
            reader = new StringStreamReader("ab /*c\n{de\n\nf}g*/h");
        } catch (ReaderException ex) {
            assert false;
        }
        try {
            formatter.format(reader, writer, context);
        } catch (ReaderException | WriterException | FormatException ex) {
            assert false;
        }        
        assert(writer.getWriting().equals("ab /*c\n{de\n\nf}g*/h"));
    }
    @Test
    public void stringTest() {
        ObjectsFactory factory = new SpringObjectsFactory(new String[]{"config.xml"});
        FormatterState context = (FormatterState)factory.getObjectFromClass("context");
        Formatter formatter = (Formatter)factory.getObjectFromClass("formatter");
        
        StreamReader reader = null;
        StringStreamWriter writer = new StringStreamWriter();
        try {
            reader = new StringStreamReader("ab \"c\n{de\n\nf}g\"h");
        } catch (ReaderException ex) {
            assert false;
        }
        try {
            formatter.format(reader, writer, context);
        } catch (ReaderException | WriterException | FormatException ex) {
            assert false;
        }        
        assert(writer.getWriting().equals("ab \"c\n{de\n\nf}g\"h"));
    }
}
