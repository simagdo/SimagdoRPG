package de.simagdo.simagdoRPG.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileUtils {

    public static String FILE_SEPERATOR = "\\";
    public static String SEPERATOR = ";";
    public static MyFile RES_FOLDER = new MyFile("res");
    public static final int TRUE = 1;
    public static final int FALSE = 0;

    public static boolean readBoolean(String value) {
        int booleanValue = Integer.parseInt(value);
        return booleanValue == TRUE;
    }

    public static int booleanToInt(boolean value) {
        return value ? TRUE : FALSE;
    }

    public static void closeBufferedReader(BufferedReader reader) {
        try {
            reader.close();
        } catch (IOException e) {
            Logger.error("" + e);
        }
    }

    public static void renameFile(File original, File newFile) {
        try {
            Files.move(original.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            Logger.error("" + e);
        }
    }

    public static void deleteFile(File file) {
        if (!file.exists()) return;
        if (file.isDirectory()) for (File meta : file.listFiles()) deleteFile(meta);
        file.delete();
    }

}
