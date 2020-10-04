package dad.javafx.adivinapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {
	
	Label adivinaLabel;
	TextField numeroText;
	Button compruebaButton;
	
	int intentos;
	int numero;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	
		
		adivinaLabel=new Label();
		adivinaLabel.setText("Escribe un número del 1 al 100:");
		
		numeroText= new TextField();
		numeroText.setPromptText("Introduce un número");
		numeroText.setMaxWidth(145);
		
		compruebaButton= new Button();
		compruebaButton.setText("Comprobar");
		compruebaButton.setOnAction(e-> onCompruebaButtonAction(e));
		compruebaButton.setDefaultButton(true);
		
		
		VBox cajaBox= new VBox();
		cajaBox.getChildren().addAll(adivinaLabel,numeroText,compruebaButton);
		cajaBox.setAlignment(Pos.CENTER);
		cajaBox.setSpacing(10);
		
		Scene scene= new Scene(cajaBox,300,250);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("AdvinApp");
		primaryStage.show();
		
		generaNumero();
		intentos=0;
		
		
	}

	private void onCompruebaButtonAction(ActionEvent e) {
		
		intentos++;

		
		try {
			
			if(Integer.parseInt(numeroText.getText())<numero) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Has fallado");
				alert.setHeaderText(null);
				alert.setContentText("Has fallado.\nEl numero a adivinar es mayor que "+numeroText.getText()+ "\nLlevas "+intentos+" intentos");
				alert.showAndWait();
			}
			
			if(Integer.parseInt(numeroText.getText())>numero) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Has fallado");
				alert.setHeaderText(null);
				alert.setContentText("Has fallado.\nEl numero a adivinar es menor que "+numeroText.getText()+ "\nLlevas "+intentos+" intentos");
				alert.showAndWait();
			}
			
			
			
			
			if (Integer.parseInt(numeroText.getText())==numero) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Has acertado");
				alert.setHeaderText(null);
				alert.setContentText("Enhorabuena, has acertado.\nHas necesitado "+intentos+" intentos");
				alert.showAndWait();
				generaNumero();
				intentos=0;
				
				
			}
		} catch (NumberFormatException e1) {
			
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setContentText("Debes escribir un número!");

				alert.showAndWait();
		}
		
		
		
		
		
	}
	
	private void generaNumero() {
	numero=(int) Math.floor(Math.random()*(100-1+1)+1);
	System.out.println(numero);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
