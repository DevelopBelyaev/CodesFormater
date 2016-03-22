/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codesformater.Tests;

import com.mycompany.codesformatter.conextManagers.ContextHandler;
import com.mycompany.codesformatter.formatter.FormatException;
import com.mycompany.codesformatter.formatter.Formatter;
import com.mycompany.codesformatter.formatter.FormatterState;
import com.mycompany.codesformatter.handlers.CharHandler;
import com.mycompany.codesformatter.readers.ReaderException;
import com.mycompany.codesformatter.readers.StreamReader;
import com.mycompany.codesformatter.readers.StringStreamReader;
import com.mycompany.codesformatter.writers.StreamWriter;
import com.mycompany.codesformatter.writers.StringStreamWriter;
import com.mycompany.codesformatter.writers.WriterException;
import org.junit.*;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author nick
 */
public class NullReferenceTest {
    
    public NullReferenceTest() {
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
    public void nullReaderTest() {
        
        List<CharHandler> handlers = new LinkedList();
        
        StreamReader reader = null;
        StreamWriter writer = new StringStreamWriter();
        try {
            Formatter formater = new Formatter((ContextHandler) handlers);
            formater.format(reader, writer, new FormatterState());
        } catch (FormatException | WriterException ex) {
            assert (false);
        } catch (ReaderException ex) {
            assert (true);
        }
    }

    @Test
    public void nullWriterTest() {
        
        List<CharHandler> handlers = new LinkedList();
        
        try {
            StreamReader reader = new StringStreamReader("");
            StreamWriter writer = null;
            Formatter formater = new Formatter((ContextHandler) handlers);
            formater.format(reader, writer, new FormatterState());
        } catch (FormatException | ReaderException ex) {
            assert (false);
        } catch (WriterException ex) {
            assert (true);
        }
    }

    @Test
    public void nullHandlersTest() {
        
        List<CharHandler> handlers = null;
        
        try {
        StreamReader reader = new StringStreamReader("");
        StreamWriter writer = new StringStreamWriter();
            Formatter formater = new Formatter((ContextHandler) handlers);
            formater.format(reader, writer, new FormatterState());
        } catch(FormatException ex) {
            assert(true);            
        } catch (WriterException | ReaderException ex) {
            assert (false);
        } 
    }

    @Test
    public void nullContextTest() {
        
        List<CharHandler> handlers = new LinkedList();
        try {        
            StreamReader reader = new StringStreamReader("");
            StreamWriter writer = new StringStreamWriter();
            Formatter formater = new Formatter((ContextHandler) handlers);
            formater.format(reader, writer, null);
        } catch (ReaderException | WriterException ex) {
            assert (false);
        } catch (FormatException ex) {
            assert (true);
        }
    }
}
