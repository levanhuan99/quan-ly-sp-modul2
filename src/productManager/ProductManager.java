package productManager;
import productRepsitory.ProductIO;
import product.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    private ArrayList<Product> list=new ArrayList<>();//TODO sử dụng interface List nhé
    private ProductIO productIO;

    public ProductManager() throws IOException {
        productIO = new ProductIO();
    }

    public void addProduct() throws IOException {
        list = productIO.readFromFile();
        Scanner scanner = new Scanner(System.in);

        System.out.println("nhap ten cua san pham");
        String name = scanner.next();

        System.out.println("nhap gia cua san pham");
        int price = scanner.nextInt();

        System.out.println("nhap code cua san pham");
        String productCode = scanner.next();

        System.out.println("nhap trang thai cua san pham");
        String status = scanner.next();

        System.out.println("mo ta cua san pham");
        String description = scanner.next();

        Product newProduct = new Product(name, price, productCode, status, description);

        list.add(newProduct);

        productIO.writeIntoFile(list);
    }

    public void display() throws IOException {
        list = productIO.readFromFile();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public void edit(String id) throws IOException {
        list = productIO.readFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductCode().equals(id)) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("nhap lai ten cua san pham");
                String name = scanner.next();
                list.get(i).setName(name);

                System.out.println("nhap lai gia cua san pham");
                int price = scanner.nextInt();
                list.get(i).setPrice(price);

                System.out.println("nhap lai code cua san pham");
                String productCode = scanner.next();
                list.get(i).setProductCode(productCode);

                System.out.println("nhap lai  trang thai cua san pham");
                String status = scanner.next();
                list.get(i).setStatus(status);

                System.out.println("mo ta cua san pham");
                String description = scanner.next();
                list.get(i).setDescription(description);
            }
        }
        productIO.writeIntoFile(list);

    }

    public void delete(String id) throws IOException {
        list = productIO.readFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductCode().equals(id)) {
                list.remove(i);
            }
        }
        productIO.writeIntoFile(list);

    }

    public void findProduct(int id) throws IOException {
        list = productIO.readFromFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductCode().equals(id)) {
                System.out.println(list.get(i).toString());
            }
        }


    }

//    public void sortBaseOnPriceUp() {
//        list = productIO.readFromFile();
//        for (int i = 0; i < list.size(); i++) {
//            for (int j=1;j<list.size()-i-1;j++){
//                if (list.get(i).getPrice()>list.get(j).getPrice()){
//
//
//                }
//            }
//        }
//
//    }


}
