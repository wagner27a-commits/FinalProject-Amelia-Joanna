import java.time.LocalDate;

// import javafx.application.Application;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
// import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddTask{
    private static Task newTask;
    public static Task display(String title, String message) {

        Stage addTask = new Stage();
      
        addTask.initModality(Modality.APPLICATION_MODAL);
        addTask.setTitle(title);
        addTask.setMinWidth(250); 

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

        HBox datePickerBox = new HBox(10,dateLabel, datePicker);
        datePickerBox.setAlignment(Pos.CENTER);
        HBox hboxAddTask = new HBox(10,taskLabel, taskTextField);
        hboxAddTask.setAlignment(Pos.CENTER);
        VBox vboxAddTask = new VBox(10,hboxAddTask, datePickerBox, createTaskBtn);
        vboxAddTask.setAlignment(Pos.CENTER);
        
        // Scene/Stage
        Scene addTaskPage = new Scene(vboxAddTask, 150, 150);
        addTask.setScene(addTaskPage);
        addTask.showAndWait();

        return newTask;
    }
}