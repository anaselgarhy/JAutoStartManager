package com.anas.jautostartmanager.units;

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
}
