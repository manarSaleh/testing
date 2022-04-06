/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack_implementation;

import org.w3c.dom.css.Counter;

/**
 *
 * @author Enas
 */
public class BruteForce_Algorithm {

    int capacity;
    int itemsNo;
    Item[] items;

    //Default constructor
    public BruteForce_Algorithm() {
    }

    //Specific value constructor 
    public BruteForce_Algorithm(int capacity, Item[] items) {
        this.capacity = capacity;
        this.items = items;
        //Derived item number from the array length
        this.itemsNo = items.length;
    }

    public int bruteForce_Algorithm() {
        int counter=0;
        double permutations = Math.pow(2, itemsNo);
        int maxValue = 0;
        //outer loop for all permuatation
        for (int i = 0; i < permutations; i++) {
            //intilize permuatation values and permuatation weights
            int permValues = 0;
            int permWeights = 0;
            //inner loop to go through each item
            for (int j = 0; j < itemsNo; j++) {
                //check if the item is in permutation or not
                //if not don't include its weight and value in the total values and weights of the permutation 
                if (!isInPermutation(i, j)) {
                    continue;
                }
                //if not then add its value to the total values of permuatation
                permValues += items[j].value;
                //and add its weight to the total weights of permuatation
                permWeights += items[j].weight;
                counter++;
            }
            //if the permuatation weights less than or equal capacity AND the permuatation values greater than max value
            //set permuatation values as the max value 
            if (permWeights <= capacity && permValues > maxValue) {
                maxValue = permValues;
            }

           
        } 
         //return the maximum value can take in the knapsack for specified items
         return maxValue;
    }

    //THE METHOD CHECK IF THE ITEM IN THE PERMUTATION BASED ON THE BIT STRING
    boolean isInPermutation(int permu, int item) {
        //to check if the item in the permutation or not will follow the following steps
        //1-shift right the permuatation by number of this item to find the bit in that position(represent item)
        //2-do AND operation betweent the result of the pervious step with 1
        //3-check if equal 1 that means the item in this permuatation 
        //****Example for 2 items number of permuatation is 4 
        //if we have this permuatation (0 1) and we want to check of the second item there 
        //step1: sift right by (1) index of item in the bit string we get (0 0)
        //step2: AND the result with 1(0 0)AND(0 1)"binary representation of 1"
        //step3: the result will be (0 0) in deciaml it's 0 that means the item not included 
        
        //return true if inclde and false if not
        return ((permu >> item) & 1) == 1;
    }
    

}
