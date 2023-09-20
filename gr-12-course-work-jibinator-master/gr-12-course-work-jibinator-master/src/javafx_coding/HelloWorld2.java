package javafx_coding;

import javafx.application.Application; 
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/** Hello World program with GUI interface
 *  using JavaFX
 * @author Catherine McCaffery
 */
public class HelloWorld2 extends Application 
{
	/** start method sets up all graphical components
	 *  in the program 
	 */
	@Override
	public void start(Stage stage) throws Exception
	{
		//create and configure the main circle for the face
		Circle card = new Circle (125, 125, 80);
		face.setFill (Color.YELLOW);
		card.setStroke(Color.RED);
		

		
		//create and configure the text
		Text caption = new Text(80, 240, "Smiley Face");
		caption.setFill(Color.STEELBLUE);
		caption.setFont(Font.font("Verdana", 15));
		
		//create a group that holds all the features and configure a scene to hold
		Group root = new Group(face, rightEye, leftEye, mouth, caption);
		Scene scene = new Scene(root, 250, 275, Color.YELLOW);
	
		//add the scene to the stage and set the title
		stage.setScene(scene);
		stage.setTitle("Smiley Face");

		//show the stage
		stage.show();
	}


	/** Main method only launches args 
	 * (method found in the application class)
	 * @param args
	 */
	public static void main(String[] args) 
	{
		launch(args);
	}
}



