package model.util;

import model.entities.Product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static void convertFile(String path) {
        try(BufferedReader br = new BufferedReader(new FileReader(path + "\\SourceFiles.csv"))) {
            List<Product> products = new ArrayList<>();
            List<String> stringProducts = new ArrayList<>();

            String line = br.readLine();

            while(line != null) {
                String[] field = line.split(", ");
                products.add(new Product(field[0], Double.parseDouble(field[1]), Integer.parseInt(field[2])));

                line = br.readLine();
            }

            for(Product product : products) {
                stringProducts.add(product.toString());
            }

            CreateFile.create(path + "\\out\\summary.csv", stringProducts);
        }
        catch (IOException e) {
            System.out.print("Error: " + e.getMessage());
        }
    }
}
