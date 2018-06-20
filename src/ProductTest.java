import java.io.*;

public class ProductTest {
    public static void main(String[] args) throws IOException {
        int i =0;
        String fileName = "produkty.csv";
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Product[] products = new Product[ProductMethods.sizeOfFile(fileName)];
        String input;

        while((input = bufferedReader.readLine()) != null) {
            String[] wyrazy = input.split(";");
            products[i] = new Product(wyrazy[0], wyrazy[1], Double.parseDouble(wyrazy[2]));
            System.out.println(products[i].toString());
            i++;
        }
        bufferedReader.close();

        System.out.println();
        System.out.println("Suma cen produktów wynosi: " + ProductMethods.sumOfPrice(products));
        System.out.println("Najdroższy produkt to: " + ProductMethods.theMostExpensive(products));
        System.out.println("Najczęstszy producent to: " + ProductMethods.theMostOftenProducer(products));

    }
}
