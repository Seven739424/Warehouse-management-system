package warehouse.system;

import java.util.ArrayList;
import java.util.Scanner;

public class warehouseManagementSystem {
    public static void main(String[] args) {
        ArrayList<goods> goodsList = new ArrayList<>();
        loop:while (true) {
            System.out.println("------------Welcome to the Warehouse Management System------------");
            System.out.println("1.add goods");
            System.out.println("2.delete goods");
            System.out.println("3.change goods");
            System.out.println("4.search goods");
            System.out.println("5.exit");
            System.out.println("Please enter your choice");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case"1"->addGoods(goodsList);
                case"2"->deleteGoods(goodsList);
                case"3"->changeGoods(goodsList);
                case"4"->searchGoods(goodsList);
                case"5"->{
                    System.out.println("exit");
                    break loop;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    //add goods
    public static void addGoods(ArrayList<goods> goodsList) {
        System.out.println("add goods");

    }
    //deleteGoods
    public static void deleteGoods(ArrayList<goods> goodsList) {
        System.out.println("delete goods");
    }
    //changeGoods
    public static void changeGoods(ArrayList<goods> goodsList) {
        System.out.println("change goods");
    }
    //searchGoods
    public static void searchGoods(ArrayList<goods> goodsList) {
        System.out.println("search goods");
    }

}