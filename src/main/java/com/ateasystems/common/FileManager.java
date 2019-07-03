package com.ateasystems.common;

import cyclops.control.Option;

import java.util.HashMap;
import java.util.Map;

public class FileManager {
    private Map<Long, Option<String> > dataTable = new HashMap<>();

    public void process(DataFileMetadata metadata){

        dataTable.put(metadata.getCustomerId(),metadata.getContents());

    }
}
