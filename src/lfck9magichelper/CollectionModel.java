/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfck9magichelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author 5luke
 */
public class CollectionModel implements FileHandling{
    private ObservableList<Card> cardCollection;
    
    CollectionModel(){
        cardCollection = FXCollections.observableArrayList();
    }
    
    //*************************FILE IO*************************
    @Override
    public void load(File file){
        if (file != null) {
            
            try {
                FileInputStream fileIn = new FileInputStream(file.getPath());
                ObjectInputStream in = new ObjectInputStream(fileIn);
                
                List<Card> tempCards = (List<Card>) in.readObject();
                cardCollection = FXCollections.observableArrayList(tempCards);
                
                in.close();
                fileIn.close();
            }catch (FileNotFoundException ex) {
                System.out.println("File not found exception occured while opening " + file.getPath());
                
            } catch (IOException ex) {
                System.out.println("IO exception occured while opening " + file.getPath());
                ex.printStackTrace();
                
            } catch (ClassNotFoundException ex) {
                System.out.println("Class not found exception occured while opening " + file.getPath());
                
            }  
        }
    }
    
    @Override
    public void save(File file){
        if (file != null) {
            try {
                FileOutputStream fileOut = new FileOutputStream(file.getPath());
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                
                out.writeObject(new ArrayList<Card>(cardCollection));
                out.close();
                fileOut.close();
            } catch (FileNotFoundException ex) {
                System.out.println("File not found exception occured while opening " + file.getPath());
                ex.printStackTrace();
                
            } catch (IOException ex) {
                System.out.println("IO exception occured while opening " + file.getPath());
                ex.printStackTrace();
            }
        } 
    }
    
    public void addCard(int quantity, String name, boolean forTrade){
        Card card = createCard(quantity, name, forTrade);
        cardCollection.add(card);
    }
    
    public void deleteCard(Card card){
        cardCollection.remove(card); 
    }
    
    public void editCard(Card oldCard, int quantity, String name, boolean forTrade){
        Card newCard = createCard(quantity, name, forTrade);
        cardCollection.set(cardCollection.indexOf(oldCard), newCard);
    }
    
    public ObservableList getCollection(){
        return cardCollection;
    }
    
    public boolean isCollectionEmpty(){
        return cardCollection.isEmpty();
    }
    
    private Card createCard(int quantity, String name, boolean forTrade){
        Card card = new Card(quantity, name, forTrade);
        return card;
    }
}
