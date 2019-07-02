package com.ateasystems.common;

import cyclops.control.Eval;
import cyclops.function.Memoize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.function.Supplier;

@AllArgsConstructor
@Setter
@Getter
public class DataFileMetadata {

    private final long customerId;
    private final String type;
    private final File file;
    private final Supplier<String> contents = Eval.later(this::loadContents);

    public String getContents(){
        return contents.get();
    }

    private String loadContents(){
        try {
            return loadFromFile();
        }catch(IOException e){
            throw new DataFileUnavailableException(e);
        }
    }
    private String loadFromFile() throws IOException {
        return new String(Files.readAllBytes(file.toPath()));
    }
}
