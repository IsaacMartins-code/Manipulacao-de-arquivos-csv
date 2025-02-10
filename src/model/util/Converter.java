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

                String name = field[0];
                double price = Double.parseDouble(field[1]);
                int quantity = Integer.parseInt(field[2]);

                products.add(new Product(name, price, quantity));

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
