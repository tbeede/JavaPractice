import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileReader();
    }

    public static void FileReader() {

        BufferedReader productReader = null;
        BufferedReader salesReader = null;

        try {
            String products;
            String sales;
            productReader = new BufferedReader(new FileReader("/Users/timbeede/projects/JavaPractice/src/products.tab"));
            salesReader = new BufferedReader(new FileReader("/Users/timbeede/projects/JavaPractice/src/sales.tab"));

            //Read files line by line
            while ((products = productReader.readLine()) != null && (sales = salesReader.readLine()) != null) {
                //Print product data
                System.out.println("Product Data: " + "\n");
                System.out.println("Original products data: " + products);
                System.out.println("Converted product data: " + TabtoArrayList(products) + "\n");
                //Print sales data
                System.out.println("Sales Data: " + "\n");
                System.out.println("Original sales data: " + sales);
                System.out.println("Converted sales data: " + TabtoArrayList(products) + "\n");
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
    }

    public static ArrayList<String> TabtoArrayList(String tabFiles) {
        ArrayList<String> fileResult = new ArrayList<String>();

        if (tabFiles != null) {
            String[] splitData = tabFiles.split("\\t*,\\t*");
            for (int i = 0; i < splitData.length; i++) {
                if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                    fileResult.add(splitData[i].trim());
                }
            }
        }

        return fileResult;

    }
}
