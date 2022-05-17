package com.anas.jautostartmanager.exceptions;

public class IsInAutoStartException extends Exception {
    public IsInAutoStartException() {
        super("File is already in auto start programs");
    }
}
