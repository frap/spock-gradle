package com.ateasystems.common;

import java.io.IOException;

public class DataFileUnavailableException extends RuntimeException {
    public DataFileUnavailableException(IOException e) {
    }
}
