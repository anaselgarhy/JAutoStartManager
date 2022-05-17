package com.anas.jautostartmanager.units;

import java.io.File;
import java.io.IOException;

public interface AutoStartUnit {
    void addToAutoStart(File file) throws IOException;
    boolean removeFromAutoStart(File file);

    String getAutoStartFilePath();

    default boolean isInAutoStartPrograms(File file) {
        return new File(this.getAutoStartFilePath() + File.separator + file.getName()).exists();
    }
}
