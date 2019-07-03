package com.ateasystems.common;

import cyclops.control.Option;
import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Getter
public class URLDataFileMetadata extends DataFileMetadata {

    private final URL url;

    public URLDataFileMetadata(long customerId, String type, URL url) {
        super(customerId, type);
        this.url = url;
    }

    @Override
    public Option<String> loadContents() {
        try {
            URLConnection conn = url.openConnection();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                return Option.some(in.lines().collect(Collectors.joining("\n")));
            }
        } catch (IOException e) {
            return Option.none();
        }
    }
}
