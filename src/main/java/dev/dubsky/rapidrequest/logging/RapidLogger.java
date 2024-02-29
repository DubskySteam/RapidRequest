package dev.dubsky.rapidrequest.logging;

import dev.dubsky.rapidrequest.config.LogConfig;

public class RapidLogger {

    private static RapidLogger instance;

    private RapidLogger() {
    }

    /**
     * Get the instance of the RapidLogger
     * @return the instance of the RapidLogger
     */
    public static RapidLogger getInstance() {
        if (instance == null) {
            instance = new RapidLogger();
        }
        return instance;
    }

    private String getCurrentTime() {
        return java.time.LocalDateTime.now().toString();
    }

    public void log(String message) {
        if (!LogConfig.LOGGING)
            return;
        System.out.println("[RapidRequest | " + LoggingLevel.INFO + " | " + getCurrentTime() + "]\n" + message);
    }

    public void log(String message, Throwable e) {
        if (!LogConfig.LOGGING)
            return;
        System.out.println("[RapidRequest | " + LoggingLevel.ERROR + " | " + getCurrentTime() + "]\n" + message + "\n" + e.getMessage());
    }

}
