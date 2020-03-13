//******************************************************************
// COSC 1174.48L
// Bralon Holmes
// March 12, 2020
// Displays five cards randomly selected from a 52 card deck
//******************************************************************
package WindowTest;

import java.io.File;
import java.util.ArrayList;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Poker1 extends Application {
	boolean hold1 = false;
	boolean hold2 = false;
	boolean hold3 = false;
	boolean hold4 = false;
	boolean hold5 = false;
	ArrayList<Integer> cards = new ArrayList<Integer>();
	ArrayList<ImageView> images = new ArrayList<ImageView>();
	//Creates an array of 52 cards
	@Override // override the start of the application
	public void start(Stage primaryStage) {
		
		for (int i = 0; i < 52; i++) {
			cards.add(i);
		}
		for(int i = 0; i < 5; i++)
			images.add(new ImageView());
		
		// Create a VBox
		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(10, 10, 10, 10));

		// Creates pane to hold the cards
		HBox hBox = new HBox(10);
		hBox.setPadding(new Insets(10, 10, 10, 40));
		hBox.getChildren().addAll(images);
		draw(hBox);

		HBox holdBox = new HBox(10);
		holdBox.setPadding(new Insets(10, 10, 10, 10));

		Button btDEAL = new Button("DEAL");
		btDEAL.setOnAction(e -> draw(hBox));

		Button btdraw = new Button("DRAW");
		btdraw.setOnAction(e -> draw(hBox));
		
		//Creates hold button to hold cards
		Button bthold1 = new Button("HOLD");
		bthold1.setOnAction(new Hold1Handler());
		Button bthold2 = new Button("HOLD");
		bthold2.setOnAction(new Hold2Handler());
		Button bthold3 = new Button("HOLD");
		bthold3.setOnAction(new Hold3Handler());
		Button bthold4 = new Button("HOLD");
		bthold4.setOnAction(new Hold4Handler());
		Button bthold5 = new Button("HOLD");
		bthold5.setOnAction(new Hold5Handler());

		holdBox.getChildren().addAll(bthold1, bthold2, bthold3, bthold4, bthold5);

		vBox.getChildren().addAll(hBox, holdBox, btdraw, btDEAL);

		// Creates the window with the pane inside
		Scene scene = new Scene(vBox, 500, 500);
		primaryStage.setTitle("Poker Five Cards");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}

	

	public void draw(HBox pane) {
		// shuffle deck
		java.util.Collections.shuffle(cards);

		// The card will be swaped if not under the hold button
		if (hold1 == false) {
			exit(images.get(0), 1);
			new java.util.Timer().schedule(
					new java.util.TimerTask() {
						@Override
						public void run() {
							Image image1 = new Image(new File("card\\" + cards.get(0) + ".png").toURI().toString());
							images.get(0).setImage(image1);
							enter(images.get(0), 1);
						}
					},
					1000
			);
		}
		else {
			new PathTransition(Duration.ZERO, new Path(new MoveTo(0,50)), images.get(0)).play();
		}
		
		if (hold2 == false) {
			exit(images.get(1), 2);
			new java.util.Timer().schedule(
					new java.util.TimerTask() {
						@Override
						public void run() {
							Image image2 = new Image(new File("card\\" + cards.get(1) + ".png").toURI().toString());
							images.get(1).setImage(image2);
							enter(images.get(1), 2);
						}
					},
					1000
			);
		}
		else {
			new PathTransition(Duration.ZERO, new Path(new MoveTo(0,50)), images.get(1)).play();
		}
		
		if (hold3 == false) {
			exit(images.get(2), 3);
			new java.util.Timer().schedule(
					new java.util.TimerTask() {
						@Override
						public void run() {
							Image image3 = new Image(new File("card\\" + cards.get(2) + ".png").toURI().toString());
							images.get(2).setImage(image3);
							enter(images.get(2), 3);
						}
					},
					1000
			);
		}
		else {
			new PathTransition(Duration.ZERO, new Path(new MoveTo(0,50)), images.get(2)).play();
		}
		
		if (hold4 == false) {
			exit(images.get(3), 4);
			new java.util.Timer().schedule(
					new java.util.TimerTask() {
						@Override
						public void run() {
							Image image4 = new Image(new File("card\\" + cards.get(3) + ".png").toURI().toString());
							images.get(3).setImage(image4);
							enter(images.get(3), 4);
						}
					},
					1000
			);
		}
		else {
			new PathTransition(Duration.ZERO, new Path(new MoveTo(0,50)), images.get(4)).play();
		}
		
		if (hold5 == false) {
			exit(images.get(4), 5);
			new java.util.Timer().schedule(
					new java.util.TimerTask() {
						@Override
						public void run() {
							Image image5 = new Image(new File("card\\" + cards.get(4) + ".png").toURI().toString());
							images.get(4).setImage(image5);
							enter(images.get(4), 5);
						}
					},
					1000
			);
		}
		else {
			new PathTransition(Duration.ZERO, new Path(new MoveTo(0,50)), images.get(4)).play();
		}
		
		
	}
	private void enter(Node card, int pos) 
	{
		
		PathTransition path = new PathTransition();
		path.setDuration(Duration.millis(1000));
		path.setNode(card);
		path.setPath(new Path(new MoveTo(0, -300), new LineTo(0, 50)));
		path.play();
	}
	
	
		
		
		
		private void exit(Node card, int pos) 
		{
			((ImageView)card).setImage(new Image(new File("card\\b2fv.png").toURI().toString()));
		PathTransition path = new PathTransition();
		path.setDuration(Duration.millis(1000));
		path.setNode(card);
		path.setPath(new Path(new MoveTo(0,50), new LineTo(0,600)));
		path.play();
	}
	//if the card is under the hold button it is true, if not it is false
	class Hold1Handler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			if (hold1 == true) {
				hold1 = false;
			} else if (hold1 == false) {
				hold1 = true;
			}
		}
	}

	class Hold2Handler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			if (hold2 == true) {
				hold2 = false;
			} else if (hold2 == false) {
				hold2 = true;
			}
		}
	}

	class Hold3Handler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			if (hold3 == true) {
				hold3 = false;
			} else if (hold3 == false) {
				hold3 = true;
			}
		}
	}

	class Hold4Handler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			if (hold4 == true) {
				hold4 = false;
			} else if (hold4 == false) {
				hold4 = true;
			}
		}
	}

	class Hold5Handler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			if (hold5 == true) {
				hold5 = false;
			} else if (hold5 == false) {
				hold5 = true;
			}
		}
	}

}
