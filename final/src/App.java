import java.io.FileInputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.application.Application;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
// import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {
    
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static ArrayList<Task> completedTasks = new ArrayList<>();

    public static ArrayList<Task> getTasks() {
        return tasks;
    }
    
    private static ArrayList<Food> foods = new ArrayList<>();
    private static int balance = 100;
    private static int happy = 0;
    // private static VBox table = new VBox(5);
    private static GridPane gridpane = new GridPane(10,5);
    private static Food gc = new Food("Glitter Cupcake", 21, 10);
    private static Food rc = new Food("Rainbow Cake", 41, 15);
    private static Food fp = new Food("Funfetti Pancakes", 67, 30);
    private static Food jp = new Food("Jell-O Pudding", 420,50);
    private static Food sd = new Food("Sparkly Donuts", 12, 5);

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label task1 = new Label("Task");
        Label date1 = new Label("Date");
        gridpane.add(task1, 1, 0);
        gridpane.add(date1, 2,0);
        // Part 1
        Label websiteLogo = new Label("UniTask");
        Label happiness = new Label("Happiness: "+happy+"%");
        Button addTaskBtn = new Button();

        Label task3 = new Label("Task");
        Label date3 = new Label("Date");
        addTaskBtn.setText("Add Task");
        GridPane completedGridPane = new GridPane(10,5);
        // int colsC = 3;
        // int rowsC = completedTasks.size()+1;
        completedGridPane.add(task3,1,0);
        completedGridPane.add(date3,2,0);

        Label balanceLabel = new Label("Balance: "+balance);

        addTaskBtn.setOnAction(e -> {
            Task newTask = AddTask.display("Add a task!", "hello!");
            tasks.add(newTask);
            sortTasks();
            gridpane.getChildren().clear();
            // int cols = 3;
            // int rows = tasks.size()+1;
            gridpane.add(task1, 1, 0);
            gridpane.add(date1, 2,0);
            for (int i=0; i<tasks.size(); i++){
                Task task = tasks.get(i);
                CheckBox cb = new CheckBox();
                cb.setSelected(false);
                
                gridpane.add(cb, 0, i+1);
                Label name = new Label(task.getTaskName());
                Label date = new Label(task.dueString());
                gridpane.add(name,1,i+1);
                gridpane.add(date,2,i+1);

                // HBox yourTasksRow = new HBox(195-(4*taskLength), new Label(task.getTaskName()), new Label(task.dueString()));
                // yourTasksRow.setAlignment(Pos.CENTER);
                // HBox yourTasksCheckbox = new HBox(10, cb, yourTasksRow);
                // table.getChildren().add(yourTasksCheckbox);

                cb.setOnAction(event -> {
                    if (cb.isSelected()) {
                        tasks.remove(task);
                        gridpane.getChildren().remove(name);
                        gridpane.getChildren().remove(date);
                        gridpane.getChildren().remove(cb);
                        completedTasks.add(task);

                        completedGridPane.getChildren().clear();
                        completedGridPane.add(task3,1,0);
                        completedGridPane.add(date3,2,0);
                        for (int j=0; j<completedTasks.size(); j++){
                            Task cTask = completedTasks.get(j);
                            Label cName = new Label(cTask.getTaskName());
                            Label cDate = new Label(cTask.dueString());
                            CheckBox cb1  = new CheckBox();
                            cb1.setSelected(true);
                            completedGridPane.add(cb1,0,j+1);
                            completedGridPane.add(cName,1,j+1);
                            completedGridPane.add(cDate,2,j+1);
                        }

                        balance += 100;
                        balanceLabel.setText("Balance: "+balance);
                    }
                });
                if (task.getTaskDue().isBefore(LocalDate.now())){
                    App.setHappy(App.getHappy()-20);
                }
                happiness.setText("Happiness: "+happy+"%");
            }
        });
        // Import rainbow photo later
        
        VBox vbox1L = new VBox(websiteLogo, addTaskBtn);
        HBox hbox1 = new HBox(100, vbox1L, balanceLabel);

        // Part 2
        Label yourTasks = new Label("Your Tasks");
        // Label task1 = new Label("Task");
        // Label date1 = new Label("Date");
        
        // HBox hbox2 = new HBox(200, task1, date1);
        // hbox2.setAlignment(Pos.CENTER);

        VBox vbox2 = new VBox(10, yourTasks, gridpane);

        // Part 3
        Label completedTitle = new Label("Completed");
        // Label task3 = new Label("Task");
        // Label date3 = new Label("Date");

        // HBox hbox3 = new HBox(200, task3, date3);
        // hbox3.setAlignment(Pos.CENTER);

        VBox vbox3 = new VBox(10, completedTitle, completedGridPane);
        VBox vBoxLeft = new VBox(20,hbox1, vbox2, vbox3);

        // Unicorn
        String path = "final/src/Uni No Animation-2.png.png";
        FileInputStream inputFile = new FileInputStream(path);
        Image unicorn = new Image(inputFile);
        ImageView uniView = new ImageView(unicorn);

        Button storeButton = new Button("Store");
        storeButton.setOnAction(e -> {
            Store.display("Buy food for your unicorn!", "hello!");
            balanceLabel.setText("Balance: "+ balance);
        });

        HBox uniTop = new HBox(150, storeButton, happiness);

        Button feed = new Button("Feed");
        feed.setOnAction(e -> {
            Feed.display("Feed your unicorn!", "hello!");
            happiness.setText("Happiness: "+happy+"%");
        });

        HBox uni = new HBox(uniView);
        uni.setAlignment(Pos.CENTER);

        VBox vBoxRight = new VBox(100,uniTop,uni, feed);

        HBox fullScene = new HBox(20,vBoxLeft,vBoxRight);
        
        // Scene/Stage
        Scene mainPage = new Scene(fullScene, 580, 520);
        mainPage.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
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

    public static Food gc(){
        return gc;
    }

    public static Food rc(){
        return rc;
    }

    public static Food fp(){
        return fp;
    }

    public static Food jp(){
        return jp;
    }

    public static Food sd(){
        return sd;
    }

}