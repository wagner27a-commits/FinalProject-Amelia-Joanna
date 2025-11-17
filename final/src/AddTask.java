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

public class AddTask{
    
    public static void display(String title, String message) {
        Stage addTask = new Stage();
      
        addTask.initModality(Modality.APPLICATION_MODAL);
        addTask.setTitle(title);
        addTask.setMinWidth(250); 

        Label taskLabel = new Label("Task");
        TextField taskTextField = new TextField("Type the title of your task here");
        Label dateLabel = new Label("Date:");
        TextField dateTextField = new TextField("MM/DD/YYYY");
        Button createTaskBtn = new Button();
        createTaskBtn.setText("Create Task");
        
        HBox hboxAddTask = new HBox(100, taskLabel, taskTextField);
        HBox hboxDate = new HBox(100, dateLabel, dateTextField);
        HBox hboxCreateTask = new HBox(createTaskBtn);
        hboxCreateTask.setAlignment(Pos.CENTER);
        VBox vboxAddTask = new VBox(hboxAddTask, hboxDate, createTaskBtn);
        
        // Scene/Stage
        Scene addTaskPage = new Scene(vboxAddTask, 400, 400);
        addTask.setScene(addTaskPage);
        addTask.showAndWait();
    }
}