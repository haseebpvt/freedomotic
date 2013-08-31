/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.freedomotic.plugins.gui;

import it.freedomotic.util.LogFormatter;

import java.util.logging.*;

/**
 *
 * @author Enrico
 */
public class LogWindowHandler extends Handler {

    public LogWindow window = null;
    private static LogWindowHandler handler = null;

    private LogWindowHandler() {
        setLevel(Level.ALL);
        if (window == null) {
            window = new LogWindow(this);
        }
    }

    public static LogWindowHandler getInstance() {
        if (handler == null) {
            handler = new LogWindowHandler();
        }

        return handler;
    }

    @Override
    public void publish(LogRecord record) {
        String message;

        if (!isLoggable(record)) {
            return;
        }

        //message = getFormatter().format(record);
//        message = record.getLevel() + "\t "
//                + record.getSourceClassName() + "\t"
//                + record.getSourceMethodName() + "\t "
//                + record.getMessage();
        window.append(new Object[]{record.getLevel(), //record.getSourceClassName(),
                    //record.getSourceMethodName(),
                    record.getMessage()});
    }

    @Override
    public void close() {
    }

    @Override
    public void flush() {
    }
}
