package de.sduni.jets.util;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.core.AppenderBase;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogbackAppender extends AppenderBase<ILoggingEvent> {
    private final SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss.SSS");

    @Override
    protected void append(ILoggingEvent eventObject) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[%s] [%s] %s - %s", 
            df.format(new Date(eventObject.getTimeStamp())),
            eventObject.getLevel(), 
            eventObject.getLoggerName(), 
            eventObject.getFormattedMessage()));
        
        IThrowableProxy tp = eventObject.getThrowableProxy();
        if (tp != null) {
            sb.append("\n").append(tp.getClassName()).append(": ").append(tp.getMessage());
            for (StackTraceElementProxy step : tp.getStackTraceElementProxyArray()) {
                sb.append("\n  at ").append(step.getStackTraceElement().toString());
            }
        }
        
        LogManager.logDirect(sb.toString());
    }
}
