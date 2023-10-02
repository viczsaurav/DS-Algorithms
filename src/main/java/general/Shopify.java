package general;

import java.util.*;


/**
 * Detour is a Shopify merchant who sells coffee. They would like
 * to dynamically price their coffee based on stock. If there are
 * more than 8 units in stock, they will decrease price by the
 * "Price Adjustment" value and if there are less than 4 units in
 * stock they will increase the price by the "Price Adjustment"
 * value.
 *
 * Coffee        	| Base Price | Price Adjustment | Units in stock
 * -------------   	| ----------       | ---------------- | --------------
 * Heyday        	| $4               | $1                | 5
 * Punch Buggy  | $7               | $2                | 2
 * Bottleneck    	| $6               | $2                | 9
 *
 * Write a function `calculateRevenue` which calculates the revenue
 * for the day given a list of items sold.
 *
 * Examples:
 *
 * calculateRevenue([
 *   "Heyday", // 5 units in stock => $4
 * ]) => 4
 *
 * calculateRevenue([
 *   "Punch Buggy", // 2 units in stock => $7 + $2 = $9
 * ]) => 9
 *
 * calculateRevenue([
 *   "Bottleneck", // 9 units in stock => $6 - $2 = $4
 *   "Bottleneck", // 8 units in stock => $6
 * ]) => 10
 *
 * calculateRevenue([
 *   "Bottleneck",  // 9 units in stock => $6 - $2 = $4
 *   "Heyday",      // 5 units in stock => $4
 *   "Bottleneck",  // 8 units in stock => $6
 *   "Bottleneck",  // 7 units in stock => $6
 *   "Heyday",      // 4 units in stock => $4
 *   "Punch Buggy", // 2 units in stock => $7 + $2 = $9
 *   "Heyday",      // 3 units in stock => $4 + $1 = $5
 * ]) => 38
 */

public class Shopify {


    static Map<String, Coffee> coffeeList;
    final static int high =8;
    final static int low = 4;

    public static void main(String[] args) {
        coffeeList =  new HashMap<>();

        //Populate values
        Coffee heyday = new Coffee("Heyday", 4, 1, 5);
        coffeeList.put("Heyday", heyday);
        Coffee Punch = new Coffee("Punch Buggy", 7, 2, 2);
        coffeeList.put("Punch Buggy", Punch);
        Coffee Bottleneck = new Coffee("Bottleneck", 6, 2, 9);
        coffeeList.put("Bottleneck", Bottleneck);

        /*
            "Bottleneck",  // 9 units in stock => $6 - $2 = $4
            "Heyday",      // 5 units in stock => $4
            "Bottleneck",  // 8 units in stock => $6
            "Bottleneck",  // 7 units in stock => $6
            "Heyday",      // 4 units in stock => $4
            "Punch Buggy", // 2 units in stock => $7 + $2 = $9
            "Heyday",

        * */

        List<String> cList = new ArrayList<>();
        cList.add("Bottleneck");
        cList.add("Heyday");
        cList.add("Bottleneck");
        cList.add("Bottleneck");
        cList.add("Heyday");
        cList.add("Punch Buggy");
        cList.add("Heyday");


        System.out.println(calculateRevenue(cList));

    }


    public static int calculateRevenue(List<String> cList){

        int revenue =0;
        Map<String, Integer> currUnits = new HashMap<>();

        for ( String coffee: cList){
            currUnits.put(coffeeList.get(coffee).name,coffeeList.get(coffee).units );
        }

        // Between 8,4 => Base Price
        // > 8 units => basePrice - adjustment
        // < 4 units => basePrice + adjustment

        for ( String coffee: cList){
            int currUnit = (currUnits.get(coffee));
            if (currUnit > high){
                revenue =  revenue + coffeeList.get(coffee).basePrice -  coffeeList.get(coffee).adjustment;
            }
            else if (currUnit < low){
                revenue =  revenue + coffeeList.get(coffee).basePrice +  coffeeList.get(coffee).adjustment;
            }
            else {
                revenue =  revenue + coffeeList.get(coffee).basePrice;
            }
            currUnits.put(coffee, --currUnit );
        }
        return revenue;
    }

}


class Coffee{

    String name;
    int basePrice;
    int adjustment;
    int units;

    public Coffee(String name, int basePrice, int adjustment, int units){
        this.name =name;
        this.basePrice=basePrice;
        this.adjustment=adjustment;
        this.units=units;
    }
}





