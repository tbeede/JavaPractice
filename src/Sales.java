import java.util.Collections;

public class Sales {
    String name;
    Double price;

    public Sales(String line) {
        String[] splitLine = line.split("\t");
        this.name = splitLine[0];
        this.price = Double.parseDouble(splitLine[1]);
    }
}
