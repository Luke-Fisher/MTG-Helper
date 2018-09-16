/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfck9magichelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 5luke
 */
public abstract class SwitchableScene {
    public static Scene scene;
    public static final HashMap<String, SwitchableScene> CONTROLLER_COLLECTION = new HashMap<>(); //Why final?
    private Parent root;
    public static Stage stage;
    
    public static SwitchableScene addController(String name){
        SwitchableScene controller = CONTROLLER_COLLECTION.get(name);
        
        if(controller == null){
            try{
                FXMLLoader loader = new FXMLLoader(SwitchableScene.class.getResource(name + ".fxml"));
                Parent root = loader.load();
                controller = loader.getController();
                controller.setRoot(root);
                CONTROLLER_COLLECTION.put(name, controller);
            } catch (IOException ex) {
                Logger.getLogger(SwitchableScene.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error loading " + name + ".fxml \n\n " + ex); 
                controller = null; 
            } catch (Exception ex){
                System.out.println("Error loading " + name + ".fxml \n\n " + ex); 
                controller = null; 
            }
        }
        return controller;
    }
    
    public static void switchTo(String name){
        SwitchableScene controller = CONTROLLER_COLLECTION.get(name);
        
        if(controller == null){
            controller = addController(name);
        }
        
        if(controller != null && scene != null){
            scene.setRoot(controller.getRoot());
        }
    }
    
    public void setRoot(Parent root){
        this.root = root;
    }
    
    public Parent getRoot(){
        return root;
    }
    
    public static SwitchableScene getController(String name){
        return CONTROLLER_COLLECTION.get(name);
    }
}