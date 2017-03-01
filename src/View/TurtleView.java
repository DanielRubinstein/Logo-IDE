package View;

import java.awt.Color;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

public class TurtleView {

	public static final String TURTLE_IMAGE = "turtle.png";
	public static final int TURTLE_SIZE = 50;
	public static final int BUFFER = TURTLE_SIZE/2;
	
	private ImageView turtleImage;
	private Point currentCoords;
	private Point nextCoords;
	private int myRotation;
	private boolean penDown;
	private boolean isVisible;
	private Group myRoot;
	private BorderPane turtlePane;
	
	
	public TurtleView(Point initialPoint, Group root){
		currentCoords = initialPoint;
		myRotation = 0;
		penDown = true;
		myRoot = root;
		initializeTurtle(myRoot);
		initializeTurtlePane(myRoot);
	}
	
	public void updateTurtle(int x, int y){
		Point newPoint = new Point(x,y);
		
		//updatePen(myCommand.getPenStatus());
		//updateVisibility(myCommand.getVisibility());
		setTurtleLocation(newPoint);
		//setTurtleRotation(myCommand.getRotate());
		wrap(checkIfOutOfBounds());
	}
	
	private void setTurtleLocation(Point newPoint){
		nextCoords = newPoint;
		turtleImage.setX(newPoint.getX());
		turtleImage.setY(newPoint.getY());
		if(penDown){
			drawLine(myRoot);
		}
		currentCoords = nextCoords;
		nextCoords = null;
	}
	
	private void setTurtleRotation(int newRotation){
		myRotation = newRotation;
	}
	
	private void updatePen(boolean penStatus){
		penDown = penStatus;
	}
	
	private void updateVisibility(boolean visibilityStatus){
		isVisible = visibilityStatus;
		if(!isVisible){
			turtleImage.setVisible(false);
		}
		else{
			turtleImage.setVisible(true);
		}
	}
	
	private void drawLine(Group root){
		int oldX = currentCoords.getX();
		int oldY = currentCoords.getY();
		int currentX = nextCoords.getX();
		int currentY = nextCoords.getY();
		Line lineToDraw = new Line(oldX, oldY, currentX + BUFFER, currentY + BUFFER);
		root.getChildren().add(lineToDraw);
	}
	
	
	
	private void initializeTurtle(Group root){
		int startingX = currentCoords.getX();
		int startingY = currentCoords.getY();
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("turtle.png"));
        turtleImage = new ImageView(image);
        turtleImage.setFitHeight(TURTLE_SIZE);
        turtleImage.setFitWidth(TURTLE_SIZE);
        turtleImage.setX(startingX);
        turtleImage.setY(startingY);
        turtleImage.setRotate(myRotation);
        root.getChildren().add(turtleImage);
	}
	
	private void wrap(boolean isOutOfBounds){
		if(isOutOfBounds){
			updateTurtle(100,100);
		}
	}
	
	private boolean checkIfOutOfBounds(){
		boolean isOut = false;
		int currentX = currentCoords.getX();
		int currentY = currentCoords.getY();
		if(currentX < 0 || currentX > 100){
			isOut = true;
		}
		if(currentY < 0 || currentY > 100){
			isOut = true;
		}
		return isOut;
	}
	
	private void initializeTurtlePane(Group root){
		Pane turtlePane = new BorderPane();
		
		
	}
	
}
