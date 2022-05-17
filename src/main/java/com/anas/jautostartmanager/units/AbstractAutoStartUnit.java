package com.anas.jautostartmanager.units;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public abstract class AbstractAutoStartUnit implements AutoStartUnit {
    private String autoStartPath;

    public AbstractAutoStartUnit(String autoStartPath) {
        setAutoStartPath(autoStartPath);
    }

    public void setAutoStartPath(String autoStartPath) {
        this.autoStartPath = autoStartPath;
    }

    @Override
    public String getAutoStartFilePath() {
        return autoStartPath;
    }

    @Override
    public void addToAutoStart(File file) throws IOException {
        FileUtils.copyFile(file,
                new File(this.getAutoStartFilePath() + File.separator + file.getName()));
    }

    @Override
    public boolean removeFromAutoStart(File file) {
        return new File(this.getAutoStartFilePath() + File.separator + file.getName()).delete();
    }
}
