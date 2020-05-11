package view;

import productManager.ProductManager;

import java.io.IOException;
import java.util.Scanner;

public class Service {
    private ProductManager productManager;
    private static Service service;

    static {
        try {
            service = new Service();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Service() throws IOException {
        productManager = new ProductManager();
    }

    public void run() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("who are you ?");

        System.out.println("1.admin");
        System.out.println("2.user");
        System.out.println("0.thoat");

        int number = scanner.nextInt();
        switch (number) {
            case 1:
                System.out.println("Account:");
                String account = scanner.next();
                System.out.println("Password: ");
                String password = scanner.next();
                if(service.isAdmin(account, password)){
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("what do you want to do?");
                    System.out.println("1.add a product");
                    System.out.println("2.delete a product");
                    System.out.println("3.edit a product");
                    System.out.println("4.display all the products");

                    int number1 = scanner1.nextInt();
                    switch (number1) {
                        case 1:
                            productManager.addProduct();
                            service.run();
                            break;
                        case 2:
                            System.out.println("enter your product`s id ");

                            String id1 = scanner1.next();
                            productManager.delete(id1);
                            service.run();
                            break;
                        case 3:
                            System.out.println("enter your product`s id ");

                            String id2 = scanner1.next();
                            productManager.edit(id2);
                            service.run();
                            break;
                        case 4:
                            productManager.display();
                            service.run();
                            break;
                        default:
                            System.exit(0);
                    }

                }else {
                    System.out.println("tai khoan hoac mat khau cua ban khong dung.xin nhap lai");
                    service.run();
                }
                break;
            case 2:
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("what do you want to do?");
                System.out.println("1.add a product");
                System.out.println("2.display all the products");
                int number2 = scanner2.nextInt();
                switch (number2) {
                    case 1:
                        productManager.addProduct();
                        service.run();
                        break;
                    case 2:
                        productManager.display();
                        service.run();
                        break;
                    default:
                        System.exit(0);
                }
                break;

            default:
                System.exit(0);
        }
    }

    private boolean isAdmin(String account, String password){
        return (account.equals("vanhuan") && password.equals("vanhuan"));
    }
}
