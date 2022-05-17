package com.anas.jautostartmanager.exceptions;

public class IsNotInAutoStartException extends Exception {
    public IsNotInAutoStartException() {
        super("File is not in autostart programs");
    }
}
