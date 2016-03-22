package com.mycompany.codesformatter.writers;

/**
 *
 * @author nick
 */
public interface StreamWriter {
    

    /**
     * Push substring into stream
     * @param nextString substrutg to push into stream
     * @throws com.mycompany.codesformater.WriterException 
     * if substring cannot pushed
     */
    public void pushString(String nextString) throws WriterException;

    /**
     * Push char into stream
     * @param nextChar char to push into stream
     * @throws com.mycompany.codesformater.WriterException 
     * if char cannot pushed
     */
    public void pushChar(char nextChar) throws WriterException;

    /**
     * Close the stream
     * @throws com.mycompany.codesformater.WriterException 
     * if substring cannot be closed
     */
    public void close() throws WriterException;
}
