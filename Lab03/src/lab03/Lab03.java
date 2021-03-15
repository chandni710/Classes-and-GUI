package lab03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;

public class Lab03 extends Application {
 
Group group;
GraphicsContext gc;

//Launch the application//
public void start(Stage stage)
{
//Title//
stage.setTitle("Chandni's canvas");
//Chandni's canvas//
Canvas canvas = new Canvas(720.0f, 720.0f);
//graphics//
gc = canvas.getGraphicsContext2D(); 
//Group//
group = new Group(canvas);
draw1();
//create a scene//
Scene scene = new Scene(group, 720, 720);
//set the scene//
stage.setScene(scene);
stage.show();
}

public void draw1()
{
//Create a sky//
gc.setFill(Color.LIGHTBLUE);
gc.fillRect(0, 0, 720, 350);

//Grass//
gc.setFill(Color.GREEN);
gc.fillRect(0, 250, 720, 720);
 
//Create a triangle//
Polyline triangle = new Polyline();
triangle.getPoints().addAll(new Double[]{
300.0, 0.0, 
550.0, 150.0,
50.0, 150.0,
300.0, 0.0, }); 
triangle.setStroke(Color.BLACK);
triangle.setFill(Color.WHITE);
group.getChildren().add(triangle);
 
//Rectangle placed below triangle//
Rectangle rect = new Rectangle(80, 140, 440, 40);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);

//rectangle brown wall//
rect = new Rectangle(80, 170, 460, 320);
rect.setFill(Color.BROWN);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);

//Window//
rect = new Rectangle(250, 220, 90, 50);
rect.setFill(Color.GRAY);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
 
//door1//
rect = new Rectangle(135, 280, 90, 175);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
doorblacks(140, 305);
pillar(75, 190);
 
//door2//
rect = new Rectangle(255, 275, 85, 192);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
doorblacks(270, 310);
pillar(220, 190);
 
//door3//
rect = new Rectangle(385, 295, 90, 165);
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
doorblacks(410, 312);
pillar(340, 190);
pillar(480, 190);
 
//rectangle below doors//
rect = new Rectangle(72, 462, 462, 6);
rect.setFill(Color.GRAY);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);

stairs(130, 455);
}

public void doorblacks(int x, int y)
{
Rectangle rect;
 
for(int i = 0, j=0; i<8; i++, j+=30)
{
rect = new Rectangle( x, y+j, 16, 26 ); 
rect.setFill(Color.BLACK);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
 
rect = new Rectangle( x+30, y+j, 16, 26 ); 
rect.setFill(Color.BLACK);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect); 
}
}

public void pillar(int x, int y)
{
Rectangle rect;
int width=40, height=260;

//Pillar//
rect = new Rectangle( x, y, width, height ); 
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
rect = new Rectangle( x-5, y+height, 43, 10 ); 
rect.setFill(Color.WHITE);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);

//circles//
Circle circle1 = new Circle();
int radius=11;
circle1.setFill(Color.WHITE);
circle1.setStroke(Color.BLACK);
circle1.setRadius(radius);
circle1.setCenterX(x);
circle1.setCenterY(y+radius);
group.getChildren().add(circle1);

Circle circle2 = new Circle();
circle2.setFill(Color.WHITE);
circle2.setStroke(Color.BLACK);
circle2.setRadius(radius);
circle2.setCenterX(x+width);
circle2.setCenterY(y+radius);
group.getChildren().add(circle2);
} 
public void stairs(int x, int y)
{
Rectangle rect;
int width=355, height=12; 
for(int i=1; i<=10; i++)
{
rect = new Rectangle(x, y, width, 11);
rect.setFill(Color.GRAY);
rect.setStroke(Color.BLACK);
group.getChildren().add(rect);
//decrease or increase for stairs//
x= x-10; 
y= y+height; 
width = width + 20;
}
}

//Main Method//
public static void main(String args[])
{
launch(args);
}
}