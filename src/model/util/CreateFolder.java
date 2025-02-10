package model.util;

import java.io.File;

public class CreateFolder {

    public static void create(String path) {
        new File(path + "\\out").mkdir();
    }
}
