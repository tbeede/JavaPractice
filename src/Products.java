public class Products {
    String name;
    String category;

    public Products(String line) {
        String[] splitLine = line.split("\t");
        this.name = splitLine[0];
        this.category = splitLine[1];
    }
}
