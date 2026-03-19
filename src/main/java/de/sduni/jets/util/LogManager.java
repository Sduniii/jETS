package de.sduni.jets.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.util.StatusPrinter;

public class LogManager {
    private static final List<Consumer<String>> listeners = new ArrayList<>();
    private static final List<String> history = new ArrayList<>();
    private static PrintWriter fileWriter;
    private static String logFilePath = "N/A";

    static {
        try {
            // Bridge java.util.logging to SLF4J
            SLF4JBridgeHandler.removeHandlersForRootLogger();
            SLF4JBridgeHandler.install();

            // Manually force Logback to use our XML configuration
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
            try {
                JoranConfigurator configurator = new JoranConfigurator();
                configurator.setContext(context);
                context.reset(); 
                configurator.doConfigure(LogManager.class.getResourceAsStream("/logback.xml"));
                
                // Force Debug levels
                context.getLogger("ROOT").setLevel(Level.DEBUG);
                context.getLogger("tuwien.auto.calimero").setLevel(Level.DEBUG);
            } catch (Exception e) {
                System.err.println("Failed to force logback config: " + e.getMessage());
            }
            StatusPrinter.printInCaseOfErrorsOrWarnings(context);

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = "openets_" + timestamp + ".log";
            File file = new File(fileName);
            logFilePath = file.getAbsolutePath();
            fileWriter = new PrintWriter(new FileWriter(file, true), true);
            logDirect("[" + timestamp + "] [SYSTEM] Log file initialized: " + logFilePath);
        } catch (IOException e) {
            System.err.println("Failed to initialize log file: " + e.getMessage());
        }
    }

    public static String getLogFilePath() { return logFilePath; }

    public static List<String> getHistory() {
        synchronized (history) { return new ArrayList<>(history); }
    }

    public static void addListener(Consumer<String> listener) {
        synchronized (listeners) { listeners.add(listener); }
    }

    public static void logDirect(String formattedMessage) {
        synchronized (history) {
            history.add(formattedMessage);
            if (history.size() > 1000) history.remove(0);
        }
        System.out.println(formattedMessage);
        if (fileWriter != null) {
            fileWriter.println(formattedMessage);
        }
        synchronized (listeners) {
            for (Consumer<String> l : listeners) {
                l.accept(formattedMessage);
            }
        }
    }
}
