import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Emil on 2017-09-21.
 */
public class ExceptionsLog {

    public void logException(Exception exception){
        File file = new File("EXCEPTION_LOG.txt");
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream(file, true));
            writer.println("{\"NEW EXCEPTION\":");
            writer.println("\""+exception+"\"}");
            writer.println();
            writer.close();
        } catch (IOException e) {
            logException(e); //LUL
        }
    }
}
