/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
/**
 *
 * @author jiach
 */
public class BallPane extends Pane{
    public final double radius=20;
    private double x=radius,y=radius;
    private double dx=1,dy=1;
    private Circle circle = new Circle(x,y,radius);
    private Timeline animation;
    private Rectangle rectangle=new Rectangle(20,10);
    private int score,miss;
    private Label label=new Label("Score: 0");
    public BallPane(){
        circle.setFill(Color.GREEN);
        animation=new Timeline( new KeyFrame(Duration.millis(100), e-> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        animation.setRate(animation.getRate() +20);
        rectangle.setX(250);
        rectangle.setY(490);
        rectangle.setFill(Color.BLACK);
        getChildren().addAll(circle,rectangle,label);
        score=0;
        miss=0;
    }

    public void play(){
        animation.play();
    }
    
    public void pause(){
        animation.pause();
    }
    
    public void increaseSpeed(){
        animation.setRate(animation.getRate() +1);
    }
    
    public void decreaseSpeed(){
        animation.setRate(animation.getRate() > 0 ? animation.getRate() -0.1 :0);
    }
    
    public DoubleProperty ratePropertty(){
        return animation.rateProperty();
    }
    
    protected void moveBall() {
        rectangle.setOnMouseDragged(e-> rectangle.setX(e.getX()));
        
        if(x < radius || x > getWidth() - radius){
                dx*=-1;
        }
        if( y < radius || y == getHeight() - radius-10){
            if(x>=rectangle.getX()-rectangle.getWidth()/2 && x<=rectangle.getX()+rectangle.getWidth())
            {
                dy*=-1;
                score++;
                label.setText("Score: "+score);
                if(score==10)
                {
                    animation.setRate(animation.getRate() +20);
                    circle.setFill(Color.BLUE);
                }
            }
        }
        if( y < radius || y >= getHeight() - radius-9)
        {
            if(y>=getHeight()-radius)
            {
                miss++;
                if(miss%2==0)
                    rectangle.setWidth(rectangle.getWidth()+6);
                if(miss==20)
                {
                    label.setLayoutX(getWidth()/2-16);
                    label.setLayoutY(250);
                    label.setText("Totle Score : "+score);
                    pause();
                }
            }
        }
        if( y < radius || y >= getHeight() - radius)
            dy*=-1;
        
        
        x+=dx;
        y+=dy;
        circle.setCenterX(x);
        circle.setCenterY(y);
    }
}
