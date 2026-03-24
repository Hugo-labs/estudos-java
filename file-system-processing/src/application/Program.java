package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class Program {
    public static void main(String[] args) {
        
        String sourcePath = "/Users/victorhugo/estudos-java/file-system-processing/source.csv";
        File fileSourcePath = new File(sourcePath);

        String strFolderPath = fileSourcePath.getParent();
        File folderPath = new File(strFolderPath + "/out");

        if (!folderPath.exists()) {
            folderPath.mkdir();
        }

        List<Product> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(sourcePath))) {
            String line = null;

            while ((line = br.readLine()) != null) {
                String[] helper = line.split(",");

                String name = helper[0].trim();
                Double price = Double.parseDouble(helper[1].trim());
                Integer quantity = Integer.parseInt(helper[2].trim());

                Product product = new Product(name, price, quantity);
                list.add(product);
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(folderPath + "/summary.csv"))) {
            for (Product p : list) {
                bw.write(p.getName() + String.format(Locale.US, ",%.2f", p.total()));
                bw.newLine();
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Finished!");
    }
}
