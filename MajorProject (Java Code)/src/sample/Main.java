package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.lang.*;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Thread t;

    @Override
    public void start(Stage stage) {
        var controller = new DataController(); // create the controller
        var serialPort = SerialPortService.getSerialPort("COM3");
        serialPort.addDataListener(controller);

        for(int i = 0; i <= 40; i++) // Looped for 30 processes
        {
            try{
                int intValue = (int) controller.potValue; // Converting double to int data type by casting
                SetSystemVolume.setVolume(controller.potValue); // Calling the setVolume function from SetSystemVolume class
                System.out.println("Number of loops elapsed: " + i); //Showing a realtime number of processes executing
                System.out.println("Volume set to " + intValue);
                t.sleep(2000); //Thread to sleep for 2000 milliseconds - delay 2 seconds
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        System.exit(0); // Terminates the whole program




    }
}
