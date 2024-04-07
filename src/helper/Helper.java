package helper;

import java.io.File;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.UUID;

public class Helper {
    /** Generate a random id */
    public static String uuid() {
        UUID uuid = UUID.randomUUID();
        long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
        return Long.toString(l, Character.MAX_RADIX);
    }

    /** Clear the terminal */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * List the files inside a directory
     * @param filepath - The path to the directory
     */
    public static File[] listFiles(String filepath) {
        File file = new File(filepath);
        return file.listFiles();
    }

    /**
     * Format a price to euro syntax
     * @param price - The price
     */
    public static String formatToEuro(double price) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(price);
    }

    /**
     * Handle an exception
     * @param error - The exception to handle
     */
    public static void handleException(Exception error) {
        System.out.println("Oeps... Er is iets misgegaan, geef onderstaande gegevens door:");
        error.printStackTrace();
    }
}
