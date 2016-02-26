package com.crossover.trial.properties.managers.loaders;

import com.crossover.trial.properties.managers.Converters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ClasspathLoader implements BaseLoader {

    private String path;

    public ClasspathLoader(String path) {
        this.path = validatePath(path);
    }

    @Override
    public Properties loadProperties() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(path);
        if (url != null) {
            File file = new File(url.getFile());
            String text = null;
            try {
                text = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Converters.convertToProperties(text);
        } else {
            throw new RuntimeException("Can't find resources");
        }
    }


    /* private methods*/

    private String validatePath(String path) {
        String suffix = "resources/";
        int index = path.indexOf(suffix);
        return path.substring(index + suffix.length());
    }

    private String readFileAsString(String filePath) throws IOException {
        StringBuilder fileData = new StringBuilder();
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }
}
