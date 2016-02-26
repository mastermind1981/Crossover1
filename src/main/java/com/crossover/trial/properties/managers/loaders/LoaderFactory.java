package com.crossover.trial.properties.managers.loaders;

import java.net.URI;
import java.net.URISyntaxException;

public class LoaderFactory {

    public static final String FILE_SCHEME = "file";
    public static final String HTTP_SCHEME = "http";
    public static final String RESOURCES_SCHEME = "classpath";

    public static BaseLoader getLoader(String path) {
        try {
            URI uri = new URI(path);
            String scheme = uri.getScheme();
            switch (scheme) {
                case FILE_SCHEME:
                    return new LocalFileLoader(path);
                case HTTP_SCHEME:
                    return new HttpLoader(path);
                case RESOURCES_SCHEME:
                    return new ClasspathLoader(path);
                default:
                    throw new RuntimeException("unsupported scheme");
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
