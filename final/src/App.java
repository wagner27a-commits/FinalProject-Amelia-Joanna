import java.time.LocalDate;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        int happy = 0;
        int balance = 0;

        // Part 1
        Label websiteLogo = new Label("UniTask");
        Button addTaskBtn = new Button();
        addTaskBtn.setText("Add Task");
        addTaskBtn.setOnAction(e -> AddTask.display("Add a task!", "hello!"));
        Label balanceLabel = new Label("Balance: "+balance);
        // Import rainbow photo later
        
        VBox vbox1L = new VBox(websiteLogo, addTaskBtn);
        HBox hbox1 = new HBox(100, vbox1L, balanceLabel);

        // Part 2
        Label yourTasks = new Label("Your Tasks");
        Label task1 = new Label("Task");
        Label date1 = new Label("Date");
        
        HBox hbox2 = new HBox(200, task1, date1);
        hbox2.setAlignment(Pos.CENTER);
        VBox vbox2 = new VBox(yourTasks, hbox2);

        // Part 3
        Label completedTitle = new Label("Completed");
        Label task3 = new Label("Task");
        Label date3 = new Label("Date");
        
        HBox hbox3 = new HBox(200, task3, date3);
        hbox3.setAlignment(Pos.CENTER);
        VBox vbox3 = new VBox(completedTitle, hbox3);
        VBox vBoxLeft = new VBox(133,hbox1, vbox2, vbox3);

        //Unicorn
        Button storeButton = new Button("Store");
        storeButton.setOnAction(e -> Store.display("Buy food for your unicorn!", "hello!"));
        Label happiness = new Label("Happiness: "+happy+"%");
        HBox uniTop = new HBox(150,storeButton,happiness);

        Button feed = new Button("Feed");
        feed.setOnAction(e -> Feed.display("Feed your unicorn!", "hello!"));

        VBox vBoxRight = new VBox(400,uniTop,feed);

        HBox fullScene = new HBox(20,vBoxLeft,vBoxRight);
        
        // Scene/Stage
        Scene mainPage = new Scene(fullScene, 570, 460);
        primaryStage.setTitle("UniTask");
        primaryStage.setScene(mainPage);
        primaryStage.show();
    }
}