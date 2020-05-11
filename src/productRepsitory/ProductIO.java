package productRepsitory;

import product.Product;

import java.io.*;
import java.util.ArrayList;

public class ProductIO {
    private static final String SOURCE_FILE = "D:\\codegym\\modul2\\week3\\day4\\test.txt";

//    private static ProductIO intance=null;             //TODO test singgleton
//
//    private ProductIO(){
//    }
//    public static   synchronized ProductIO getIntance(){
//        if (intance ==null){
//            intance=new ProductIO();
//        }
//        return intance;
//    }


    private ArrayList<Product> store = new ArrayList<>();//TODO sử dụng interface List nhé

    public ArrayList<Product> readFromFile() {

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Object obj = null;
        try {
            fis = new FileInputStream(SOURCE_FILE);
            ois = new ObjectInputStream(fis);

            while (fis.available() > 0) {
                obj = ois.readObject();
                store.add((Product) obj);
            }
            return store;
        } catch (Exception e) {
            System.out.println("loi o doc file " + e);
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println("loi o class product io doc file try catch 2 " + e);
            }
            try {
                ois.close();
            } catch (IOException e) {
                System.out.println("loi o class product io try catch 2 " + e);
            }
        }
        return null;
    }

    public void writeIntoFile(ArrayList<Product> list) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        Object obj = null;
        try {
            fos = new FileOutputStream(SOURCE_FILE);
            oos = new ObjectOutputStream(fos);
            for (int i = 0; i < list.size(); i++) {
                obj = list.get(i);
                oos.writeObject(obj);
            }
        } catch (Exception e) {
            System.out.println("loi o ghi file " + e);
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println("loi o class product io ghi file try catch 2 " + e);
            }
            try {
                oos.close();
            } catch (IOException e) {
                System.out.println("loi o class product io ghi file try catch 2 " + e);
            }
        }
    }
}
