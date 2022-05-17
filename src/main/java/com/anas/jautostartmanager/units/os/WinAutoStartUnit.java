package com.anas.jautostartmanager.units.os;

import com.anas.jautostartmanager.units.AbstractAutoStartUnit;

public class WinAutoStartUnit extends AbstractAutoStartUnit {
    public WinAutoStartUnit() {
        super("C:\\" + System.getProperty("user.name") +
                "\\AppData\\Microsoft\\Windows\\Start Menu\\Programs\\Startup");
    }
}
