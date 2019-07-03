package com.ateasystems.common;

import cyclops.control.Option;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Getter
public abstract class FileDataFileMetadata extends DataFileMetadata{

    private final File file;

    public FileDataFileMetadata(long customerId, String type, File file) {
        super(customerId, type);
        this.file = file;
    }


    @Override
    public Option<String> loadContents() {
        try {
            return Option.some(new String(Files.readAllBytes(file.toPath())));
        } catch (IOException e) {
            return Option.none();
        }
    }
    private String loadFromFile() throws IOException {
        return new String(Files.readAllBytes(file.toPath()));
    }
}
