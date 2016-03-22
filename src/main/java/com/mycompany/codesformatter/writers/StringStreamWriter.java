/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.codesformatter.writers;

/**
 *
 * @author nick
 */
public class StringStreamWriter implements StreamWriter {

    StringBuilder target;

    public StringStreamWriter() {
        this.target = new StringBuilder();
    }

    @Override
    public void pushString(String nextString) throws WriterException {
        if (nextString == null) {
            throw new WriterException("Nothing to be add");
        }
        target.append(nextString);
    }
    @Override
    public void pushChar(char nextChar) throws WriterException {
      target.append(nextChar);
    }

    @Override
    public void close() throws WriterException {
        target = null;
    }

    /**
     * 
     * @return String to contains in the stream
     */
    public String getWriting() {
        return target.toString();
    }


}
