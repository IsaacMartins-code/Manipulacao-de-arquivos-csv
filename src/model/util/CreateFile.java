package model.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CreateFile {

    public static void create(String path, List<String> lines) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for(String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        }
        catch(IOException e) {
            System.out.print("Error: " + e.getMessage());
        }
    }
}
