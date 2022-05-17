package com.anas.jautostartmanager.units.os.linux;

import com.anas.jautostartmanager.units.AbstractAutoStartUnit;

import java.io.File;
import java.io.IOException;

public class LinuxAutoStartUnit extends AbstractAutoStartUnit {
    public LinuxAutoStartUnit(String autoStartPath) {
        super(System.getProperty("user.home") + "/.config/autostart");
    }

    @Override
    public void addToAutoStart(File file) throws IOException {
        super.addToAutoStart(DesktopFileCreator.creteDesktopFile(file.getName(), System.getProperty("user.home") + "/.local/share/applications"));
    }

    @Override
    public boolean removeFromAutoStart(File file) {
        return super.removeFromAutoStart(new File(super.getAutoStartFilePath() + "/" + file.getName()));
    }
}
