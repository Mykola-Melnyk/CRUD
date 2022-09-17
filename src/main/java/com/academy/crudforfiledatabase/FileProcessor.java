package com.academy.crudforfiledatabase;

import java.io.File;

public class FileProcessor {
    public static String[] directoryContent(File directory) {
        return directory.list();
    }
}
