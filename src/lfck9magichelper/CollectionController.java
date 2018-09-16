/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lfck9magichelper;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author 5luke
 */
public class CollectionController extends SwitchableScene implements Initializable {
    
    @FXML
    private TextField numCardsText;
    @FXML 
    private TextField cardNameText;
    @FXML
    private Label error;
    @FXML
    private ToggleButton forTrade;
    @FXML
    private TableColumn numCardsCol;
    @FXML
    private TableColumn cardNameCol;
    @FXML
    private TableColumn forTradeCol;
    @FXML
    private TableView<Card> cardList;
    
    private CollectionModel cModel;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cModel = new CollectionModel();
        
        error.setVisible(false);
        
        numCardsCol.setCellValueFactory(
                    new PropertyValueFactory<>("numOwned"));
        cardNameCol.setCellValueFactory(
                    new PropertyValueFactory<>("name"));
        forTradeCol.setCellValueFactory(
                    new PropertyValueFactory<>("forTrade"));  
    }    
    
    @FXML
    private void handleSwitchToUtilities(){
        SwitchableScene.switchTo("UtilitiesView");
    }
    
    @FXML
    private void handleLoad(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(stage);
        cModel.load(file);
        updateListView();
    }
    
    @FXML
    private void handleSave(){
        if(cModel.isCollectionEmpty()){
            return;
        }
        
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(stage);
        cModel.save(file);
    }
    
    @FXML
    private void handleAddCard(){
        error.setVisible(false);
        try{
            cModel.addCard(Integer.parseInt(numCardsText.getText()), cardNameText.getText(), forTrade.isSelected());
            updateListView();
        } catch(NumberFormatException e){
            error.setVisible(true);
            error.setText("Please enter a valid numerical quantity");
        }
    }
    
    @FXML
    private void handleDeleteCard(){
        error.setVisible(false);
        cModel.deleteCard(cardList.getSelectionModel().getSelectedItem());
        cardList.getSelectionModel().clearSelection();
    }
    
    @FXML
    private void handleEditCard(){
        error.setVisible(false);
        try{
            cModel.editCard(cardList.getSelectionModel().getSelectedItem(), Integer.parseInt(numCardsText.getText()), cardNameText.getText(), forTrade.isSelected());
            updateListView();
        } catch(NumberFormatException e){
            error.setVisible(true);
            error.setText("Please enter a valid numerical quantity");
        } catch(Exception e){
            error.setVisible(true);
            error.setText("Please select a card from the table");
        }
    }
    
    @FXML
    private void sendToTextBox(){
        error.setVisible(false);
        Card selectedItem = cardList.getSelectionModel().getSelectedItem();
        cardNameText.setText(selectedItem.getName());
        numCardsText.setText(Integer.toString(selectedItem.getNumOwned()));
        forTrade.setSelected(selectedItem.getForTrade());
        handleToggleForTrade();
    }
    
    private void updateListView(){
        ObservableList<Card> cards = cModel.getCollection();
        cardList.setItems(cards);
    }
    
    @FXML
    private void handleToggleForTrade(){
        if(forTrade.isSelected()) forTrade.setText("True");
        if(!forTrade.isSelected()) forTrade.setText("False");
    }
    
    @FXML
    public void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Magic: The Gathering Helper");
        alert.setContentText("This application was developed by Luke Fisher at the University of Missouri, Columbia.");
        
        TextArea textArea = new TextArea("The Utilities page contains helpful tools for Magic: The Gathering, a card game.\n"
                                        + "The Collection Page is for documenting and loading a person's collection of Magic cards.\n"
                                        + "For more information about Magic: The Gathering, visit https://magic.wizards.com/");
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(textArea, 0, 0);
        alert.getDialogPane().setExpandableContent(expContent);
        
        alert.showAndWait();
    }
}
