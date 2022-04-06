/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package knapsack_implementation;

/**
 *
 * @author Enas
 */
//this item class to store weight and value of the item 
public class Item {

    int weight;
    int value;

    //Default constructor
    public Item() {
    }

    //Specified constructor 
    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    @Override
    public String toString() {
        return "("+weight+","+value+")";
    }
    

}
