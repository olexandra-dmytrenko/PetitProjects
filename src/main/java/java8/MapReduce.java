package java8;

import lombok.AllArgsConstructor;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class MapReduce {
    @AllArgsConstructor
    private static class Receipt {
        public int year;
        public List<Good> bought;
        public Customer customer;
    }

    @AllArgsConstructor
    private static class Customer {
        public String name;
//        public List<Good> bought;
    }

    @AllArgsConstructor
    private static class Good {

        public final String name;
        public final double price;

    }

    public static void main(String[] args) {
        Good meet = new Good("meet", 10.0);
        Good eggs = new Good("eggs", 5.0);
        Good milk = new Good("milk", 3.0);
        Good bread = new Good("bread", 2.0);

        Customer sasha = new Customer("Sasha");
        ;
        Customer andrii = new Customer("Andrii");
        Customer sveta = new Customer("Sveta");
        Customer dasha = new Customer("Dasha");

        Receipt one = new Receipt(2015, singletonList(meet), sasha);
        Receipt two = new Receipt(2017, asList(eggs, meet, milk, bread), sasha);
        Receipt three = new Receipt(2017, singletonList(eggs), sasha);
        Receipt four = new Receipt(2017, asList(milk, bread), sveta);
        Receipt five = new Receipt(2018, singletonList(eggs), sasha);
        Receipt six = new Receipt(2018, singletonList(meet), andrii);

        Receipt[] receipts = {one, two, three, four, five, six};

        int currentYear = 2017;
        List<Double> prices = new LinkedList<>();
        for (Receipt receipt : receipts) {
            if (currentYear == receipt.year){
                
            }
              //  prices.add(receipt.bought);
        }
    }




}
