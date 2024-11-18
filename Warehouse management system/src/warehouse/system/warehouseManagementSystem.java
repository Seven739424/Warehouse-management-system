package warehouse.system;

import javax.sound.midi.InvalidMidiDataException;
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter good name");
        String goodName = sc.next();

        System.out.println("Enter good amount");
        int goodAmount = sc.nextInt();

        System.out.println("Enter good price");
        double goodPrice = sc.nextDouble();

        goods s = new goods(goodName, goodAmount, goodPrice);

        //put the information in the list
        goodsList.add(s);

        //tell users they have add successfully
        System.out.println("Goods added!");
    }
    //deleteGoods
    public static void deleteGoods(ArrayList<goods> goodsList) {
        System.out.println("delete goods");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name to be deleted");
        String goodName = sc.next();
        int index=getIndex(goodsList,goodName);
        if(index>=0){
            goodsList.remove(index);
            System.out.println("Goods deleted!");
        }else{
            System.out.println("Invalid name");
        }


    }
    //changeGoods
    public static void changeGoods(ArrayList<goods> goodsList) {
        System.out.println("change goods");
        System.out.println("Enter good name");
        Scanner sc = new Scanner(System.in);
        String goodName = sc.next();
        int index=getIndex(goodsList,goodName);
        if(index==-1){
            System.out.println("Invalid name");
            return;
        }
        goods goods = goodsList.get(index);
        System.out.println("Enter the name of the goods to be modified");
        String newName = sc.next();
        goods.setName(newName);

        System.out.println("Enter the amounts of the goods to be modified");
        int newAmount = sc.nextInt();
        goods.setAmount(newAmount);

        System.out.println("Enter the price of the goods to be modified");
        double newPrice = sc.nextDouble();
        goods.setPrice(newPrice);

        System.out.println("updated!");




    }
    //searchGoods
    public static void searchGoods(ArrayList<goods> goodsList) {
        System.out.println("search goods");
        if(goodsList.size()==0){
            System.out.println("no goods");
            return;
        }

        //print the header information
        System.out.println("name\tamount\tprice");

        for(int i=0;i<goodsList.size();i++){
            goods goods = goodsList.get(i);
            System.out.println(goods.getName()+"\t"+goods.getAmount()+"\t"+goods.getPrice());
        }
    }

    //Determine whether the goods exist
    public static boolean contains(ArrayList<goods> goodsList, String goodName) {
        return getIndex(goodsList,goodName)>=0;
    }


    public static int getIndex(ArrayList<goods> goodsList,String goodName) {
        for(int i=0;i<goodsList.size();i++){
            goods goods = goodsList.get(i);
            String name = goods.getName();
            if(name.equals(goodName)){
                return i;
            }
        }
        return -1;
    }
        }



