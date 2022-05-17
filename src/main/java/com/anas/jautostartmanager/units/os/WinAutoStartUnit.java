package com.anas.jautostartmanager.units.os;

import com.anas.jautostartmanager.units.AbstractAutoStartUnit;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class WinAutoStartUnit extends AbstractAutoStartUnit {
    public WinAutoStartUnit() {
        super("C:\\" + System.getProperty("user.name") +
                "\\AppData\\Microsoft\\Windows\\Start Menu\\Programs\\Startup");
    }

    @Override
    public void addToAutoStart(File file) throws IOException {
        FileUtils.copyFile(file,
                new File(super.getAutoStartFilePath() + File.separator + file.getName()));
    }

    @Override
    public boolean removeFromAutoStart(File file) {
        return new File(super.getAutoStartFilePath() + File.separator + file.getName()).delete();
    }
}
