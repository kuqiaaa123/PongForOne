/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.HashSet;
import java.util.Set;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import javafx.scene.paint.Color;
/**
 *
 * @author jiach
 */
public class PongForOneClient extends Application {
    public void start(Stage primaryStage){
        BallPane ballPane=new BallPane();    
       
        Scene scene=new Scene(ballPane,500,500);
        primaryStage.setTitle("BounceBallControl");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        ballPane.requestFocus(); 
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
