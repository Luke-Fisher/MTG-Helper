/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfck9magichelper;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 *
 * @author 5luke
 */
public class UtilitiesController extends SwitchableScene implements Initializable {
    
    @FXML
    private Text lifeNum;
    @FXML
    private Text stormNum;
    @FXML
    private Text whiteNum;
    @FXML
    private Text blueNum;
    @FXML
    private Text blackNum;
    @FXML
    private Text redNum;
    @FXML
    private Text greenNum;
    @FXML
    private Text colorlessNum;
    @FXML
    private Text diceResult;
    
    UtilitiesModel uModel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        uModel = new UtilitiesModel();
        lifeNum.setText(uModel.getLife());
        stormNum.setText(uModel.getStorm());
    }
    
    @FXML
    private void handleSwitchToCollection(){
        SwitchableScene.switchTo("CollectionView");
    }
    
//    @FXML
//    public void handleAbout() {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("About");
//        alert.setHeaderText("Magic: The Gathering Helper");
//        alert.setContentText("This application was developed by Luke Fisher at the University of Missouri, Columbia.");
//        
//        TextArea textArea = new TextArea("The Utilities page contains helpful tools for Magic: The Gathering, a card game.\n"
//                                        + "The Collection Page is for documenting and loading a person's collection of Magic cards.\n"
//                                        + "For more information about Magic: The Gathering, visit https://magic.wizards.com/");
//        textArea.setEditable(false);
//        textArea.setWrapText(true);
//        textArea.setMaxWidth(Double.MAX_VALUE);
//        textArea.setMaxHeight(Double.MAX_VALUE);
//
//        GridPane expContent = new GridPane();
//        expContent.setMaxWidth(Double.MAX_VALUE);
//        expContent.add(textArea, 0, 0);
//        alert.getDialogPane().setExpandableContent(expContent);
//        
//        alert.showAndWait();
//    }
    //************************LIFE************************
    @FXML 
    private void handleLifeTwenty(){
        lifeNum.setText(uModel.setLifeToTwenty());
    }
    
    @FXML
    private void handleLifeFourty(){
        lifeNum.setText(uModel.setLifeToFourty());
    }
    
    @FXML
    private void handleLifePlus() {
        lifeNum.setText(uModel.incrementLife());
    }
    
    @FXML
    private void handleLifePlusFive() {
        lifeNum.setText(uModel.incrementLifeByFive());
    }
    
    @FXML
    private void handleLifeMinus() {
        lifeNum.setText(uModel.decrementLife());
    }
    
    @FXML
    private void handleLifeMinusFive() {
        lifeNum.setText(uModel.decrementLifeByFive());
    }
    
    //************************STORM************************
    @FXML
    private void handleClearStorm(){
        stormNum.setText(uModel.clearStorm());
    }
    @FXML
    private void handleStormPlus() {
        stormNum.setText(uModel.incrementStorm());
    }
    
    @FXML
    private void handleStormMinus() {
        stormNum.setText(uModel.decrementStorm());
    }
    
    //************************MANA************************
    
    @FXML
    private void handleAddWhite(){
        whiteNum.setText(Integer.toString(uModel.addMana("White")));
    }
    
    @FXML
    private void handleDecreaseWhite(){
        whiteNum.setText(Integer.toString(uModel.decreaseMana("White")));
    }
    
    @FXML
    private void handleAddBlue(){
        blueNum.setText(Integer.toString(uModel.addMana("Blue")));
    }
    
    @FXML
    private void handleDecreaseBlue(){
        blueNum.setText(Integer.toString(uModel.decreaseMana("Blue")));
    }
    
    @FXML
    private void handleAddBlack(){
        blackNum.setText(Integer.toString(uModel.addMana("Black")));
    }
    
    @FXML
    private void handleDecreaseBlack(){
        blackNum.setText(Integer.toString(uModel.decreaseMana("Black")));
    }
    
    @FXML
    private void handleAddRed(){
        redNum.setText(Integer.toString(uModel.addMana("Red")));
    }
    
    @FXML
    private void handleDecreaseRed(){
        redNum.setText(Integer.toString(uModel.decreaseMana("Red")));
    }
    
    @FXML
    private void handleAddGreen(){
        greenNum.setText(Integer.toString(uModel.addMana("Green")));
    }
    
    @FXML
    private void handleDecreaseGreen(){
        greenNum.setText(Integer.toString(uModel.decreaseMana("Green")));
    }
    
    @FXML
    private void handleAddColorless(){
        colorlessNum.setText(Integer.toString(uModel.addMana("Colorless")));
    }
    
    @FXML
    private void handleDecreaseColorless(){
        colorlessNum.setText(Integer.toString(uModel.decreaseMana("Colorless")));
    }
    
    //************************DICE************************
    
    @FXML
    private void handleCoinToss(){
        int result = uModel.rollDice(2);
        
        if(result == 1){
            diceResult.setText("heads");
        } 
        
        if(result == 2){
            diceResult.setText("tails");
        }
    }
    
    @FXML
    private void handleRollD6(){
        diceResult.setText(Integer.toString(uModel.rollDice(6)));
    }
    
    @FXML
    private void handleRollD20(){
        diceResult.setText(Integer.toString(uModel.rollDice(20)));
    }
}
