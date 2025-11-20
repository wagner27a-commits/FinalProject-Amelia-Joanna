import java.time.LocalDate;
import java.util.ArrayList;

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
    
    private static ArrayList<Task> tasks = new ArrayList<>();

    public static ArrayList<Task> getTasks() {
        return tasks;
    }
    
    private static ArrayList<Food> foods = new ArrayList<>();
    private static int balance = 100;
    private static int happy = 0;
    private static VBox table = new VBox(5);

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        // Part 1
        Label websiteLogo = new Label("UniTask");
        Button addTaskBtn = new Button();

        addTaskBtn.setText("Add Task");
        VBox completedTable = new VBox(5);

        Label balanceLabel = new Label("Balance: "+balance);

        addTaskBtn.setOnAction(e -> {
            Task newTask = AddTask.display("Add a task!", "hello!");
            tasks.add(newTask);
            sortTasks();
            table.getChildren().clear();
            for (Task task : tasks){
                CheckBox cb = new CheckBox();
                cb.setSelected(false);
                
                HBox yourTasksRow = new HBox(150, new Label(task.getTaskName()), new Label(task.dueString()));
                yourTasksRow.setAlignment(Pos.CENTER);
                HBox yourTasksCheckbox = new HBox(10, cb, yourTasksRow);
                table.getChildren().add(yourTasksCheckbox);

                cb.setOnAction(event -> {
                    if (cb.isSelected()) {
                        table.getChildren().remove(yourTasksCheckbox);
                        completedTable.getChildren().add(yourTasksCheckbox);
                        balance += 100;
                        balanceLabel.setText("Balance: "+balance);
                    }
                });
            }
        });
        // Import rainbow photo later
        
        VBox vbox1L = new VBox(websiteLogo, addTaskBtn);
        HBox hbox1 = new HBox(100, vbox1L, balanceLabel);

        // Part 2
        Label yourTasks = new Label("Your Tasks");
        Label task1 = new Label("Task");
        Label date1 = new Label("Date");
        
        HBox hbox2 = new HBox(200, task1, date1);
        hbox2.setAlignment(Pos.CENTER);

        VBox vbox2 = new VBox(10, yourTasks, hbox2, table);

        // Part 3
        Label completedTitle = new Label("Completed");
        Label task3 = new Label("Task");
        Label date3 = new Label("Date");

        HBox hbox3 = new HBox(200, task3, date3);
        hbox3.setAlignment(Pos.CENTER);

        VBox vbox3 = new VBox(10, completedTitle, hbox3, completedTable);
        VBox vBoxLeft = new VBox(20,hbox1, vbox2, vbox3);

        // Unicorn
        Button storeButton = new Button("Store");
        storeButton.setOnAction(e -> {
            Store.display("Buy food for your unicorn!", "hello!");
            balanceLabel.setText("Balance: "+ balance);
        });
        Label happiness = new Label("Happiness: "+happy+"%");
        HBox uniTop = new HBox(150, storeButton, happiness);

        Button feed = new Button("Feed");
        feed.setOnAction(e -> {
            Feed.display("Feed your unicorn!", "hello!");
            happiness.setText("Happiness: "+happy+"%");
        });

        VBox vBoxRight = new VBox(400,uniTop,feed);

        HBox fullScene = new HBox(20,vBoxLeft,vBoxRight);
        
        // Scene/Stage
        Scene mainPage = new Scene(fullScene, 570, 460);
        primaryStage.setTitle("UniTask");
        primaryStage.setScene(mainPage);
        primaryStage.show();
    }

    public static int getBalance() {
        return balance;
    }

    public static void setBalance(int balance) {
        App.balance = balance;
    }

    public static int getHappy(){
        return happy;
    }

    public static void setHappy(int happy){
        App.happy = happy;
    }

    public static ArrayList<Food> getFoods(){
        return foods;
    }

    public static void sortTasks(){
        // Task hold;
        for (int j=0; j<tasks.size()-1; j++){
            for (int i=0; i<tasks.size()-1-j; i++){
                if (tasks.get(i).getTaskDue().isAfter(tasks.get(i+1).getTaskDue())){
                    Task hold = tasks.get(i);
                    tasks.set(i, tasks.get(i+1));
                    tasks.set(i+1, hold);
                }
            }
        }
    }

}