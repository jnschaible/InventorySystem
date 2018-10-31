/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View_Controller;

import Model.Product;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jnsch
 */
public class ModifyProductController implements Initializable {

    @FXML
    private AnchorPane modifyProductScreenAnchor;
    @FXML
    private AnchorPane modifyProductAnchor;
    @FXML
    private Label modifyProductLabel;
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
    private TextField maxField;
    @FXML
    private TextField minField;
    @FXML
    private TableView<?> partTable1;
    @FXML
    private TableColumn<?, ?> partIDColumn1;
    @FXML
    private TableColumn<?, ?> partNameColumn1;
    @FXML
    private TableColumn<?, ?> inventoryLevelColumn1;
    @FXML
    private TableColumn<?, ?> priceColumn1;
    @FXML
    private TableView<?> partTable2;
    @FXML
    private TableColumn<?, ?> partIDColumn2;
    @FXML
    private TableColumn<?, ?> partNameColumn2;
    @FXML
    private TableColumn<?, ?> inventoryLevelColumn2;
    @FXML
    private TableColumn<?, ?> priceColumn2;
    @FXML
    private Button searchButton;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Button saveButton;
    @FXML
    private TextField searchField;
    
    private Product product;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void searchButtonHandler(ActionEvent event) {
    }

    @FXML
    private void addButtonHandler(ActionEvent event) {
    }

    @FXML
    private void deleteButtonHandler(ActionEvent event) {
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
        //Saves changes to selected Product and returns to main screen
        boolean validInput = true;
        //Set product name from input
        product.setName(nameField.getText());
        //Set product inventory level from input
        try { product.setInStock(Integer.parseInt(invField.getText())); }
        catch(Exception e) { validInput = IOExceptionHandler(); }
        //Set product price from input
        try { product.setPrice(Double.parseDouble(priceField.getText())); }
        catch(Exception e) { validInput = IOExceptionHandler(); }
        //Set product max inventory level from input
        try { product.setMax(Integer.parseInt(maxField.getText())); }
        catch(Exception e) { validInput = IOExceptionHandler(); }
        //Set product min inventory level from input
        try { product.setMin(Integer.parseInt(minField.getText())); }
        catch(Exception e) { validInput = IOExceptionHandler(); }
        
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
    
    public void setProduct(Product product) {
        this.product = product;
        
        IDField.setText(Integer.toString(product.getProductID()));
        nameField.setText(product.getName());
        invField.setText(Integer.toString(product.getInStock()));
        priceField.setText(Double.toString(product.getPrice()));
        maxField.setText(Integer.toString(product.getMax()));
        minField.setText(Integer.toString(product.getMin()));
    }
    
    public boolean IOExceptionHandler() {
        System.out.println("Invalid input type"); 
        return false;
    }
}
