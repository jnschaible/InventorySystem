/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.OutsourcedPart;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jnsch
 */
public class ModifyOutsourcedPartController implements Initializable {

    @FXML
    private AnchorPane modifyOutsourcedPartScreenAnchor;
    @FXML
    private AnchorPane modifyOutsourcedPartAnchor;
    @FXML
    private Label modifyOutsourcedPartLabel;
    @FXML
    private Label IDLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label invLabel;
    @FXML
    private Label priceLabel;
    @FXML
    private Label maxLabel;
    @FXML
    private Label companyNameLabel;
    @FXML
    private Label minLabel;
    @FXML
    private TextField IDField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField invField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField companyNameField;
    @FXML
    private TextField maxField;
    @FXML
    private TextField minField;
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;
    @FXML
    private RadioButton inHouseRadio;
    @FXML
    private RadioButton outsourcedRadio;
    private OutsourcedPart part;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Sets togglegroup for radio buttons
        ToggleGroup toggleGroup = new ToggleGroup();

        inHouseRadio.setToggleGroup(toggleGroup);
        outsourcedRadio.setToggleGroup(toggleGroup);
    }    

    @FXML
    private void cancelButtonHandler(ActionEvent event) throws IOException {
        //Switches to main screen and discards changes when cancelButton pressed
        Stage stage; 
        Parent root;       
        stage=(Stage) cancelButton.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
               "MainScreen.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void saveButtonHandler(ActionEvent event) throws IOException {
        //Saves changes to selected Part and returns to main screen
        boolean validInput = true;
        //Set part name from input
        part.setName(nameField.getText());
        //Set part inventory level from input
        try { part.setInStock(Integer.parseInt(invField.getText())); }
        catch(Exception e) { validInput = IOExceptionHandler(); }
        //Set part price from input
        try { part.setPrice(Double.parseDouble(priceField.getText())); }
        catch(Exception e) { validInput = IOExceptionHandler(); }
        //Set part max inventory level from input
        try { part.setMax(Integer.parseInt(maxField.getText())); }
        catch(Exception e) { validInput = IOExceptionHandler(); }
        //Set part min inventory level from input
        try { part.setMin(Integer.parseInt(minField.getText())); }
        catch(Exception e) { validInput = IOExceptionHandler(); }
        //Set part comapny name from input
        part.setCompanyName(companyNameField.getText());
        
        if (validInput) {
            Stage stage; 
            Parent root;       
            stage=(Stage) cancelButton.getScene().getWindow();
            //load up OTHER FXML document
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                   "MainScreen.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void inHouseRadioHandler(ActionEvent event) throws IOException {
        //Switches to modifyInhousePart screen
        Stage stage; 
        Parent root;       
        stage=(Stage) inHouseRadio.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader(getClass().getResource(
               "ModifyInhousePart.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void outsourcedRadioHandler(ActionEvent event) {
        
    }
    
    public void setPart(OutsourcedPart part) {
        this.part = part;
        
        IDField.setText(Integer.toString(part.getPartID()));
        nameField.setText(part.getName());
        invField.setText(Integer.toString(part.getInStock()));
        priceField.setText(Double.toString(part.getPrice()));
        maxField.setText(Integer.toString(part.getMax()));
        minField.setText(Integer.toString(part.getMin()));
        companyNameField.setText(part.getCompanyName());
    }
    
    public boolean IOExceptionHandler() {
        System.out.println("Invalid input type"); 
        return false;
    }
    
}
