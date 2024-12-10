package abror.allaberganov.service;

import java.io.InputStream;

public class FileUtil {
    public static InputStream getFileFromClasspath(String fileName) {
        return FileUtil.class.getClassLoader().getResourceAsStream(fileName);
    }

    public static void main(String[] args) {
        InputStream inputStream = getFileFromClasspath("fonts/timesNewRoman.ttf");

        if (inputStream == null) {
            System.out.println("File not found!");
        } else {
            System.out.println("File loaded successfully!");
        }
    }
}