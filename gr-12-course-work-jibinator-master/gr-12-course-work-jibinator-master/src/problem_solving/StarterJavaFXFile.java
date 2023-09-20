package problem_solving;


	import java.awt.Font;

	import javax.swing.GroupLayout.Group;

	import org.w3c.dom.Text;

	import javafx.application.Application;
	import javafx.scene.Scene;
	import javafx.stage.Stage;

	public class StarterJavaFXFile extends Application 
	{
		@Override
		public void start(Stage primaryStage) throws Exception 
		{
			Text text = new Text(10,50,"Hello World");
			text.setFont(Font.font(50));
			
			Group root = new Group (text);
			Scene scene = new Scene (root);
			
			primaryStage.setTitle("Welcome to JavaFX");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		}// end start method

		public static void main(String[] args) 
		{
			launch(args);
		}//end main method

	}//end class StarterJavaFXFile
}
