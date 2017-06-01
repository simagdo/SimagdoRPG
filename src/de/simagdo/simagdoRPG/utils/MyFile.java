package de.simagdo.simagdoRPG.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MyFile {

    private static String path;
    private static String name;

    public MyFile(String path) {
        this.path = FileUtils.FILE_SEPERATOR + path;
        String[] dirs = path.split(FileUtils.FILE_SEPERATOR);
        this.name = dirs[dirs.length - 1];
    }

    public MyFile(MyFile file, String subFile) {
        this.path = file.path + FileUtils.FILE_SEPERATOR + subFile;
        this.name = subFile;
    }

    public static String getPath() {
        return path;
    }

    public static String getName() {
        return name;
    }

    public InputStream getInputStream() {
        return Class.class.getResourceAsStream(path);
    }

    public URL getUrl() {
        return Class.class.getResource(path);
    }

    public BufferedReader getReader() {
        try {
            InputStreamReader streamReader = new InputStreamReader(getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            return reader;
        } catch (Exception e) {
            Logger.severe("Couldn't get reader for " + path);
            Logger.error("" + e);
        }
        return null;
    }

}
