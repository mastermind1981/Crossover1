package com.crossover.trial.properties.managers.loaders;

import com.crossover.trial.properties.managers.Converters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class LocalFileLoader implements BaseLoader {

    private String path;

    public LocalFileLoader(String path) {
        this.path = path;
    }

    @Override
    public Properties loadProperties() {
        try {
            String text = new String(Files.readAllBytes(Paths.get(path)));
            return Converters.convertToProperties(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
