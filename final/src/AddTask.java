// add task popup that pops up when you press the add task button

import java.time.LocalDate;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddTask{
    private static Task newTask;
    public static Task display(String title, String message) {
        newTask = null;

        Stage addTask = new Stage();
      
        addTask.initModality(Modality.APPLICATION_MODAL);
        addTask.setTitle(title);
        addTask.setMinWidth(250); 

        // fields for entering information about your task
        Label taskLabel = new Label("Task: ");
        TextField taskTextField = new TextField("Type the title of your task here");
        DatePicker datePicker = new DatePicker();
        Label dateLabel = new Label("Due: ");
        Button createTaskBtn = new Button();
        createTaskBtn.setText("Create Task");
        createTaskBtn.setOnAction(e -> {
            LocalDate value = datePicker.getValue();
            String text = taskTextField.getText();
            newTask = new Task(text,value);
            addTask.close();
        });
        Button close = new Button();
        close.setText("Cancel");
        close.setOnAction(e -> addTask.close());

        // HBoxes and VBoxes for alignment
        HBox datePickerBox = new HBox(10,dateLabel, datePicker);
        datePickerBox.setAlignment(Pos.CENTER);
        HBox hboxAddTask = new HBox(10,taskLabel, taskTextField);
        hboxAddTask.setAlignment(Pos.CENTER);
        HBox buttons = new HBox(10,close,createTaskBtn);
        buttons.setAlignment(Pos.CENTER);
        VBox vboxAddTask = new VBox(10,hboxAddTask, datePickerBox, buttons);
        vboxAddTask.setAlignment(Pos.CENTER);
        vboxAddTask.setId("background");
        
        // Scene/Stage
        Scene addTaskPage = new Scene(vboxAddTask, 150, 150);
        addTaskPage.getStylesheets().add("style.css");
        addTask.setScene(addTaskPage);
        addTask.showAndWait();

        return newTask;
    }
}