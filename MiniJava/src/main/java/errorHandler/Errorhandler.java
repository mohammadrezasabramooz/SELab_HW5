package errorHandler;

/**
 * Created by Alireza on 6/28/2015.
 */
public class ErrorhandlerClass {
    public static boolean hasError = false;

    public static void printError(String msg) {
        hasError = true;
        System.out.println(msg);
    }
}

