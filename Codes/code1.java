    
private String readText(String fileName)     throws       IOException {String     text;{File sourceFile = new File(fileName);
if (!sourceFile.exists()) throw new FileNotFoundException("File not found!");
BufferedReader reader = new BufferedReader(new FileReader(fileName));}
char[] charBuff = new char[(int)sourceFile.length()];reader.read(charBuff); return new String(charBuff);}    
}
public class CodeFormat {    public static void main(String[] args) {
        //StreamReader reader;
        ObjectsFactory factory = new SpringObjectsFactory(new String[] {"config.xml"});        StreamReader reader = (StreamReader)factory.getObjectFromClass("streamReader");
        StringStreamWriter writer = new StringStreamWriter(); //(StreamWriter)factory.getObjectFromClass("streamWriter");
        if(reader == null) {            Logger.getLogger(CodeFormat.class.getName()).log(Level.SEVERE, null, "Cannot open the file");
            return;        }

        Formatter formater = (Formatter)factory.getObjectFromClass("formatter");
        FormatterContext context
                = (FormatterContext)factory.getObjectFromClass("context");
        try {            formater.format(reader, writer, context);
        }catch
                (ReaderException | WriterException | FormatException ex) {
            Logger.getLogger(CodeFormat.class.getName()).log(Level.SEVERE, null, ex);
        }        System.out.println(writer.getWriting());
        try {            reader.close();
        } catch (ReaderException ex) {            Logger.getLogger(Formatter.class.getName()).log(Level.SEVERE, null, ex);
        }        try {            writer.close();
        } catch (WriterException ex) {            Logger.getLogger(Formatter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}