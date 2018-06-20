import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProductMethods {
    public static double sumOfPrice(Product[] tab) {
        double sumOfPrice = 0;
        try {
            for (int i = 0; i < tab.length; i++) {
                sumOfPrice = sumOfPrice + tab[i].getPrice();
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return sumOfPrice;
    }

    public static Product theMostExpensive(Product[] tab) {
        Product product = new Product();
        double maxPrice = 0;

        try {
            for (int i = 0; i < tab.length; i++) {
                if (tab[i].getPrice() > maxPrice) {
                    maxPrice = tab[i].getPrice();
                    product = tab[i];
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        return product;
    }

    public static String theMostOftenProducer(Product tab[]) {
        int counter = 0;
        int[] tabInt = new int[tab.length];
        int maxI = 0;
        int maxNrI = 0;
        String finalProducer = null;

        try {
            for (int i = 0; i < tab.length; i++) {
                for (int j =0; j < tab.length; j++) {
                    if (tab[i].getProducer().equals(tab[j].getProducer())){
                        counter++;
                    }
                }
                tabInt[i] = counter;
                counter=0;
            }

            for (int i = 0; i < tabInt.length; i++) {
                if (tabInt[i]>maxI){
                    maxI=tabInt[i];
                    maxNrI=i;
                }
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        if(maxI>1){
            finalProducer = tab[maxNrI].getProducer();
        } else finalProducer = null;

        return finalProducer;
    }

    public static int sizeOfFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String input;
        int i = 0;

        while((input = bufferedReader.readLine()) != null) {
            i++;
        }
        bufferedReader.close();
        return i;
    }
}
