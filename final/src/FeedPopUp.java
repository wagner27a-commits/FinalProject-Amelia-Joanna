import java.time.LocalDate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FeedPopUp{
    public static void display(String title, int remainingTasks, int currentHealth, int currentBalance) {
        Stage feedPopUp = new Stage();
      
        feedPopUp.initModality(Modality.APPLICATION_MODAL);
        feedPopUp.setTitle(title);
        // feedPopUp.setMinWidth(200); 

        Label feedingUnicornText = new Label("Thank you for feeding your Unicorn!");
        Label tasksLabel = new Label("Remaining Tasks: " + remainingTasks);
        Label healthLabel = new Label("Current Health: " + currentHealth);
        Label balanceLabel = new Label("Current Balance: " + currentBalance);

        VBox feedPopUpBox = new VBox(10, feedingUnicornText, tasksLabel, healthLabel, balanceLabel);
        feedPopUpBox.setAlignment(Pos.CENTER);
        
        // Scene/Stage
        Scene feedPopUpPage = new Scene(feedPopUpBox, 300, 150);
        feedPopUp.setScene(feedPopUpPage);
        feedPopUp.showAndWait();
    }
}