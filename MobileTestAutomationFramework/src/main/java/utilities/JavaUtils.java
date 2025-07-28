package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * Utility class for common Java operations.
 * Provides helper methods for various Java operations.
 */
public class JavaUtils {
    
    /**
     * Private constructor to prevent instantiation.
     */
    private JavaUtils() {
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * Pauses execution for the specified number of seconds.
     *
     * @param seconds The number of seconds to pause
     */
    public static void pauseInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LoggerUtils.error("Thread interrupted during sleep", e);
        }
    }
    
    /**
     * Pauses execution for the specified number of milliseconds.
     *
     * @param milliseconds The number of milliseconds to pause
     */
    public static void pauseInMilliseconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LoggerUtils.error("Thread interrupted during sleep", e);
        }
    }
    
    /**
     * Generates a random number between min and max (inclusive).
     *
     * @param min The minimum value
     * @param max The maximum value
     * @return A random number between min and max
     */
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
    
    /**
     * Gets the current timestamp as a string in the specified format.
     *
     * @param format The date format (e.g., "yyyy-MM-dd HH:mm:ss")
     * @return The formatted timestamp
     */
    public static String getCurrentTimestamp(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
    }
    
    /**
     * Loads properties from a file.
     *
     * @param filePath The path to the properties file
     * @return The loaded Properties object
     * @throws IOException If the file cannot be read
     */
    public static Properties loadProperties(String filePath) throws IOException {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(new File(filePath))) {
            properties.load(fis);
        }
        return properties;
    }
    
    /**
     * Creates a directory if it doesn't exist.
     *
     * @param directoryPath The path of the directory to create
     * @return true if the directory was created or already exists, false otherwise
     */
    public static boolean createDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            return directory.mkdirs();
        }
        return true;
    }
}
