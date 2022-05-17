package com.anas.jautostartmanager.units.os.linux;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DesktopFileCreator {
    public static File creteDesktopFile(String name, String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(path + "/" + name + ".desktop");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
            writeDataToDesktopFile(file, name);
        }
        return file;
    }

    private static void writeDataToDesktopFile(File file, String name) {
        StringBuilder builder = new StringBuilder();
        builder.append("[Desktop Entry]\n");
        builder.append("Name=").append(name).append("\n");
        builder.append("Exec=java -jar ").append(name).append("\n");
        builder.append("Type=Application\n");
        builder.append("Terminal=false\n");
        builder.append("X-GNOME-Autostart-enabled=true\n");
        builder.append("Icon=").append(name).append("\n");
        builder.append("Comment=").append(name).append("\n");
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
