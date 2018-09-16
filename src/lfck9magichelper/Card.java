/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfck9magichelper;

import java.io.Serializable;



/**
 *
 * @author 5luke
 */
public class Card implements Serializable {
    private String name;
    private int numOwned;
    private boolean forTrade;
    
    Card(){
        
    }
    
    Card(int numOwned, String name, boolean forTrade){
        this.numOwned = numOwned;
        this.name = name;
        this.forTrade = forTrade;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getNumOwned(){
        return numOwned;
    }
    
    public void setNumOwned(int numOwned){
        this.numOwned = numOwned;
    }
    public boolean getForTrade(){
        return forTrade;
    }
    
    public void setForTrade(boolean forTrade){
        this.forTrade = forTrade;
    }
}
