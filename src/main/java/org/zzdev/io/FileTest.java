package org.zzdev.io;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        File file = new File(".");
        System.out.println(file.getAbsoluteFile());
    }
}
