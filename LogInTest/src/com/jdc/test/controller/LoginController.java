package com.jdc.test.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import com.jdc.test.entity.User;
import com.jdc.test.service.UserService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
@Controller
public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;
    
    @FXML
    private Label message;
    
    @Autowired
    private UserService service;
    
    private static User user;
    public static User getUser() {
    	return user;
    	
    }
    	
    
    

    @FXML
    void cancle(ActionEvent event) {

    }
    @FXML
    private Stage stage;
   
    @FXML
    void login(ActionEvent event) {
    	stage=new Stage();
    	
		//loader.setControllerFactory(Main::getController);
		try {
			user=service.findbylogin(username.getText(),password.getText());
	    	FXMLLoader loader=new FXMLLoader(MainController.class.getResource("view/main.fxml"));
			stage.setScene(new Scene(loader.load()));
			stage.show();
		} catch (Exception e) {
			
			message.setText(e.getMessage());
		}
		
    	username.getScene().getWindow().hide();

    }

}
