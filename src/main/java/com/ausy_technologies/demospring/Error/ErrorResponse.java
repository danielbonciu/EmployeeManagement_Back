package com.ausy_technologies.demospring.Error;

import java.util.logging.*;

public class ErrorResponse extends RuntimeException {
    public static final Logger lgr = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static boolean isDebug = java.lang.management.ManagementFactory.getRuntimeMXBean().
            getInputArguments().toString().contains("jdwp");

    private String errorMessage;
    private int errorId;
    public ErrorResponse(){

    }

    public ErrorResponse(String errorMessage, int errorId) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorId = errorId;
    }


    public static void LogError(ErrorResponse e){
        if(isDebug) {
            e.printStackTrace();
        }
        else {
            lgr.log(Level.SEVERE,e.getErrorMessage());
        }

    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorId() {
        return errorId;
    }
}