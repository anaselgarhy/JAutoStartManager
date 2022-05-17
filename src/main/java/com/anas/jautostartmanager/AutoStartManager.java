package com.anas.jautostartmanager;

import com.anas.jautostartmanager.exceptions.IsInAutoStartException;
import com.anas.jautostartmanager.exceptions.IsNotInAutoStartException;
import com.anas.jautostartmanager.exceptions.OSIsNotSupportedException;
import com.anas.jautostartmanager.units.AbstractAutoStartUnit;
import com.anas.jautostartmanager.units.os.WinAutoStartUnit;

import java.io.File;
import java.io.IOException;

public class AutoStartManager {
    private static final AbstractAutoStartUnit autoStartUnit;

    static {
        autoStartUnit = AutoStartManager.makeAutoStartUnit();
    }

    private static AbstractAutoStartUnit makeAutoStartUnit() {
        return switch (System.getProperty("os.name").toLowerCase()) {
            case "windows" -> new WinAutoStartUnit();
            default -> null; // TODO: 5/15/22 add support for other OS (linux, mac)
        };
    }

    public void add(File file) throws IOException, IsInAutoStartException, OSIsNotSupportedException {
        if (autoStartUnit == null)
            throw new OSIsNotSupportedException("AutoStartManager is not supported on this OS");
        if (autoStartUnit.isInAutoStartPrograms(file))
            throw new IsInAutoStartException();

        autoStartUnit.addToAutoStart(file);
    }

    public boolean remove(File file) throws OSIsNotSupportedException, IsNotInAutoStartException {
        if (autoStartUnit == null)
            throw new OSIsNotSupportedException("AutoStartManager is not supported on this OS");
        if (autoStartUnit.isInAutoStartPrograms(file))
            throw new IsNotInAutoStartException();

        return autoStartUnit.removeFromAutoStart(file);
    }
}
