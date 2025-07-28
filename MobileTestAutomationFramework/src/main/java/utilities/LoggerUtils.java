package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class for logging.
 * Provides methods for logging at different levels.
 */
public class LoggerUtils {
    
    private static final Logger logger = LogManager.getLogger(LoggerUtils.class);
    
    /**
     * Log types enumeration.
     */
    public enum LogType {
        INFO,
        WARN,
        ERROR,
        DEBUG,
        FATAL
    }
    
    /**
     * Private constructor to prevent instantiation.
     */
    private LoggerUtils() {
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * Logs a message at the specified level.
     *
     * @param logType The log level
     * @param message The message to log
     */
    public static void log(LogType logType, String message) {
        switch (logType) {
            case INFO:
                logger.info(message);
                break;
            case WARN:
                logger.warn(message);
                break;
            case ERROR:
                logger.error(message);
                break;
            case DEBUG:
                logger.debug(message);
                break;
            case FATAL:
                logger.fatal(message);
                break;
            default:
                logger.info(message);
                break;
        }
    }
    
    /**
     * Logs an info message.
     *
     * @param message The message to log
     */
    public static void info(String message) {
        logger.info(message);
    }
    
    /**
     * Logs a warning message.
     *
     * @param message The message to log
     */
    public static void warn(String message) {
        logger.warn(message);
    }
    
    /**
     * Logs an error message.
     *
     * @param message The message to log
     */
    public static void error(String message) {
        logger.error(message);
    }
    
    /**
     * Logs a debug message.
     *
     * @param message The message to log
     */
    public static void debug(String message) {
        logger.debug(message);
    }
    
    /**
     * Logs an error message with exception details.
     *
     * @param message The message to log
     * @param e The exception
     */
    public static void error(String message, Throwable e) {
        logger.error(message, e);
    }
}
