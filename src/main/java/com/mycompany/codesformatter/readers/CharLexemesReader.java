/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codesformatter.readers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CharLexemesReader implements StreamReader {

    FileInputStream source;

    public CharLexemesReader(File file) throws ReaderException {
        if (file == null || !file.exists()) {
            throw new ReaderException("Source not exists");
        }
        try {
            source = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            throw new ReaderException("Source cannot be open");
        }
    }
    
    public CharLexemesReader(String fileName) throws ReaderException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new ReaderException("Source not exists");
        }
        try {
            source = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            throw new ReaderException("Source cannot be open");
        }
    }

    @Override
    public String next() throws ReaderException {
        int next;
        try {
            next = source.read();
        } catch (IOException ex) {
            throw new ReaderException("Char cannot be read");
        }
        if (next == -1) {
            throw new ReaderException("End of source");
        }
        return "" + (char) next;
    }

    @Override
    public void close() throws ReaderException {
        try {
            source.close();
        } catch (IOException ex) {
            throw new ReaderException("Source cannot be closed");
        }
    }

    @Override
    public boolean hasNext() throws ReaderException {
        try {
            return source.available() != 0;
        } catch (IOException ex) {
            throw new ReaderException("Stream was closed");
        }
    }
}
