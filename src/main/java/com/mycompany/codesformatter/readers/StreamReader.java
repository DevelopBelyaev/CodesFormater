package com.mycompany.codesformatter.readers;

/**
 *
 * @author nick
 */
public interface StreamReader {
    
    /**
     *
     * @return next char if it can be reading
     * @throws com.mycompany.codesformater.ReaderException if next char cannot
     * be read
     */
    public String next() throws ReaderException;
    
    /**
     *
     * @throws com.mycompany.codesformater.ReaderException if cannot be closed
     */
    public void close() throws ReaderException;

    /**
     *
     * @return true, if next char can be reading
     * @throws com.mycompany.codesformater.ReaderException if stream was closed
     */
    public boolean hasNext() throws ReaderException;
}
