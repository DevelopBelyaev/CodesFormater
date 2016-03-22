/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codesformatter.readers;

import com.mycompany.codesformatter.readers.StreamReader;

/**
 *
 * @author nick
 */
public class StringStreamReader implements StreamReader {

    public String source = null;
    int pointer = 0;
    int length = 0;

    public StringStreamReader(String source) throws ReaderException {
        this.source = source;
        length = source.length();
    }

    @Override
    public String next() throws ReaderException {
        if (source == null) {
            throw new ReaderException("Char cannot be read");
        }
        if (pointer == length) {
            throw new ReaderException("End of source");
        }
        return ""+source.charAt(pointer++);
    }

    @Override
    public void close() {
        source = null;
        pointer = 0;
        length = 0;
    }

    @Override
    public boolean hasNext() {
        return pointer < length;
    }

}
