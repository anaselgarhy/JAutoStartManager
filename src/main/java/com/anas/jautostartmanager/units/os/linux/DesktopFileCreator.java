package com.anas.jautostartmanager.units.os.linux;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DesktopFileCreator {
    public static File creteDesktopFile(File scFile, String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(path + "/" + scFile.getName() + ".desktop");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
            writeDataToDesktopFile(file, scFile);
        }
        return file;
    }

    private static void writeDataToDesktopFile(File file, File scFile) {
        StringBuilder builder = new StringBuilder();
        builder.append("[Desktop Entry]\n");
        builder.append("Name=").append(scFile.getName()).append("\n");
        builder.append("Exec=java -jar ").append(scFile.getAbsolutePath()).append("\n");
        builder.append("Type=Application\n");
        builder.append("Terminal=false\n");
        builder.append("X-GNOME-Autostart-enabled=true\n");
        builder.append("Icon=").append(scFile.getParentFile().getAbsolutePath()).append("/icon.png").append("\n");
        builder.append("Comment=").append(scFile.getName()).append("\n");
        builder.append("Categories=Application;\n");
        // Write data to file
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(builder.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
