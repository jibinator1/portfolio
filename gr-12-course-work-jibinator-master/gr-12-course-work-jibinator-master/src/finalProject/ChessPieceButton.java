package finalProject;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.paint.Color; 
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ChessPieceButton {
    private String typePiece;
    private char colour;

    public ChessPieceButton() {}

    public ChessPieceButton(String typePiece, char colour) {
        this.setPiece(typePiece);
        this.setColour(colour);
    }

    public void setPiece(String typePiece) {
        this.typePiece = typePiece;   
    }

    public void setColour(char colour) {
        this.colour = colour;   
    }

    public String getPiece() {
        return this.typePiece;   
    }

    public char getColour() {
        return this.colour;   
    }

    public static Button createPiece(ChessPiece chessPiece) {
        Button button = new Button();
        button.setPrefSize(70, 70);
        switch (chessPiece.getPiece()) {
            case "pawn":
                if (chessPiece.getColour() == 'W') {
                	button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); //so it shows the button when i need to(change final value 0.0 - 1.0)
                    button.setText("\u2659");
                    button.setPadding(new Insets(0,0,0,0));
                    Font font = Font.font("Arial", 70);
                    button.setFont(font);
                    button.setTextFill(Color.WHITE);
                } else { 
                	button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); //so it shows the button when i need to(change final value 0.0 - 1.0)
                    button.setText("\u265F");
                    button.setPadding(new Insets(0,0,0,0));
                    Font font = Font.font("Arial", 70);
                    button.setFont(font);
                    button.setTextFill(Color.BLACK);
                }
                break;
            case "rook":
                if (chessPiece.getColour() == 'W') {
                	button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); //so it shows the button when i need to(change final value 0.0 - 1.0)
                    button.setText("\u2656");
                    button.setPadding(new Insets(0,0,0,0));
                    Font font = Font.font("Arial", 70);
                    button.setFont(font);
                    button.setTextFill(Color.WHITE);
                } else {
                	button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); //so it shows the button when i need to(change final value 0.0 - 1.0)
                    button.setText("\u265C");
                    button.setPadding(new Insets(0,0,0,0));
                    Font font = Font.font("Arial", 70);
                    button.setFont(font);
                    button.setTextFill(Color.BLACK);
                }
                break;
            case "bishop":
                if (chessPiece.getColour() == 'W') {
                	button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); //so it shows the button when i need to(change final value 0.0 - 1.0)
                    button.setText("\u2657");
                    button.setPadding(new Insets(0,0,0,0));
                    Font font = Font.font("Arial", 70);
                    button.setFont(font);
                    button.setTextFill(Color.WHITE);
                } else {
                	button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); //so it shows the button when i need to(change final value 0.0 - 1.0)
                    button.setText("\u265D");
                    button.setPadding(new Insets(0,0,0,0));
                    Font font = Font.font("Arial", 70);
                    button.setFont(font);
                    button.setTextFill(Color.BLACK);
                }
                break;
            case "knight":
                if (chessPiece.getColour() == 'W') {
                	button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); //so it shows the button when i need to(change final value 0.0 - 1.0)
                    button.setText("\u2658");
                    button.setPadding(new Insets(0,0,0,0));
                    Font font = Font.font("Arial", 70);
                    button.setFont(font);
                    button.setTextFill(Color.WHITE);
                } else {
                	button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); //so it shows the button when i need to(change final value 0.0 - 1.0)
                    button.setText("\u265E");
                    button.setPadding(new Insets(0,0,0,0));
                    Font font = Font.font("Arial", 70);
                    button.setFont(font);
                    button.setTextFill(Color.BLACK);
                }
                break;
            case "king":
                if (chessPiece.getColour() == 'W') {
    				button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); //so it shows the button when i need to(change final value 0.0 - 1.0)
                    button.setText("\u2654");
                    Font font = Font.font("Arial", 70);
                    button.setFont(font);
                    button.setTextFill(Color.WHITE);
                } else {
    				button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); //so it shows the button when i need to(change final value 0.0 - 1.0)

                    button.setText("\u265A");
                    Font font = Font.font("Arial", 70);
                    button.setFont(font);
                    button.setTextFill(Color.BLACK);
                }
                break;
            case "queen":
                if (chessPiece.getColour() == 'W') {
    				button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); //so it shows the button when i need to(change final value 0.0 - 1.0)
                    button.setText("\u2655");
                    button.setPadding(new Insets(0,0,0,0));
                    Font font = Font.font("Arial", 70);
                    button.setFont(font);
                    button.setTextFill(Color.WHITE);
                } else {
    				button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); //so it shows the button when i need to(change final value 0.0 - 1.0)
                    button.setText("\u265B");
                    button.setPadding(new Insets(0,0,0,0));
                    Font font = Font.font("Arial", 70);
                    button.setFont(font);
                    button.setTextFill(Color.BLACK);
                }
                break;
            default:
                System.out.println("This is not implemented!");
                break;
        }
        
        button.setPrefSize(100, 100);
        return button;
    }
}
