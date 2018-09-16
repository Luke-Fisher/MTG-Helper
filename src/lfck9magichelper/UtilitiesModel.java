/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfck9magichelper;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 5luke
 */
public class UtilitiesModel {
    private int lifeTotal = 20;
    private int stormCount = 0;
    private HashMap<String, Integer> mana = new HashMap<>();
    
    UtilitiesModel(){
        initializeHashMap();
    }
    
    //************************LIFE************************
    public String getLife(){
        return Integer.toString(lifeTotal);
    }
    
    public String setLifeToTwenty(){
        lifeTotal = 20;
        return(Integer.toString(lifeTotal));
    }
    
    public String setLifeToFourty(){
        lifeTotal = 40;
        return(Integer.toString(lifeTotal));
    }
    
    public String incrementLife(){
        return Integer.toString(++lifeTotal);
    }
    
    public String incrementLifeByFive(){
        lifeTotal += 5;
        return Integer.toString(lifeTotal);
    }
    
    public String decrementLife(){
        return Integer.toString(--lifeTotal);
    }
    
    public String decrementLifeByFive(){
        lifeTotal -= 5; 
        return Integer.toString(lifeTotal);
    }
    
    
    //************************STORM************************
    public String getStorm(){
        return Integer.toString(stormCount);
    }
    
    public String clearStorm(){
        stormCount = 0;
        return(Integer.toString(stormCount));
    }
    
    public String incrementStorm(){
        return Integer.toString(++stormCount);
    }
    
    public String decrementStorm(){
        return Integer.toString(--stormCount);
    }
    
    //************************MANA************************
    
    private void initializeHashMap(){
        mana.put("White", 0);
        mana.put("Blue", 0);
        mana.put("Black", 0);
        mana.put("Red", 0);
        mana.put("Green", 0);
        mana.put("Colorless", 0);
    }
    
    public int addMana(String Color){
        int value = mana.get(Color);
        value += 1;
        mana.put(Color, value);
        return value;
    }
    
    public int decreaseMana(String Color){
        int value = mana.get(Color);
        value -= 1;
        mana.put(Color, value);
        return value;
    }
    
//************************DICE************************
    public int rollDice(int sides){
        return ThreadLocalRandom.current().nextInt(1, sides + 1);
    }
}
