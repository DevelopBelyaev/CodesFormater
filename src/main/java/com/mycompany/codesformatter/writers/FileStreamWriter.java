package com.mycompany.codesformatter.writers;

import com.mycompany.codesformatter.writers.StreamWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author nick
 */
public class FileStreamWriter implements StreamWriter {

    FileOutputStream target;

    public FileStreamWriter(String fileName) throws WriterException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new WriterException("Target not exists");
        }
        try {
            target = new FileOutputStream(file);
        } catch (FileNotFoundException ex) {
            throw new WriterException("Target cannot be open");
        }
    }

    @Override
    public void pushString(String nextString) throws WriterException {
        try {
            target.write(nextString.getBytes());
        } catch (IOException ex) {
            throw new WriterException("String cannot be write");
        }
    }

    @Override
    public void pushChar(char nextChar) throws WriterException {
        try {
            target.write((int) nextChar);
        } catch (IOException ex) {
            throw new WriterException("Char cannot be write");
        }
    }

    @Override
    public void close() throws WriterException {
        try {
            target.close();
        } catch (IOException ex) {
            throw new WriterException("Target cannot be closed");
        }
    }

}
