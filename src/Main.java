import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //recreate as for loop and for each loop
        List<Products> products = fileReader("resources/products.tab")
                .stream()
                .map(Products::new)
                .collect(Collectors.toList());
        List<Sales> sales = fileReader("resources/sales.tab")
                .stream()
                .map(Sales::new)
                .collect(Collectors.toList());
        problem1(products, sales);
    }

    private static List<String> fileReader(String fileName) {
        List<String> lines = new ArrayList<>();

        BufferedReader productReader = null;

        try {
            String products;
            productReader = new BufferedReader(new FileReader("/Users/timbeede/projects/JavaPractice/" + fileName));

            //Read files line by line
            while ((products = productReader.readLine()) != null) {
                lines.add(products);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (productReader != null) productReader.close();
            } catch (IOException fileReaderException) {
                fileReaderException.printStackTrace();
            }
        }
        return lines;
    }

    private static List<String> problem1(List<Products> products, List<Sales> sales) {
        //get the amount of sales by category
        Map<String, Double> salesByItem = new HashMap<>();
        sales.forEach(sale -> salesByItem.put(sale.name, sale.price));
        Map<String, Double> salesByCategory = new HashMap<>();
        for (Products product:products) {
            if (!salesByCategory.containsKey(product.category)) {
                System.out.println(product.name+" | "+salesByItem.get(product.name)+ " | "+product.category);
                salesByCategory.put(product.category, salesByItem.get(product.name));
            } else if (salesByItem.containsKey(product.name)) {
                System.out.println(product.name+" | "+salesByItem.get(product.name)+ " | "+product.category);
                Double sum = salesByCategory.get(product.category) + salesByItem.get(product.name);
                salesByCategory.put(product.category, sum);
            }
        }
        //Re-purpose Sales.java

        //find the top five
        return Collections.emptyList();

    }
}