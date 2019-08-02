package com.itdr.utils;

import java.io.File;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class MessyCodeFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}
