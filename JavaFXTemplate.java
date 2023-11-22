import java.awt.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import java.io.FileInputStream;
import java.util.ArrayList;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.*;
import java.util.Random;
import javafx.stage.Popup;
import javafx.scene.image.Image;

import javax.swing.*;

public class JavaFXTemplate extends Application {
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		launch(args);
	}
	Popup popUpRules, popUpOdds;
	MenuBar menu;
	Button playGame,
			mainMenuBtn,
			spot1, spot4,spot8,spot10,
			playDraws,
			draw1,draw2,draw3,draw4,
			newLook,
			retry,
			money;

	Menu mOne ;
	MenuItem Rules,	Odds_of_Winning ,Exit;
	//bet card
	Label q1, allNumbers, t1, t2, t3;
	GridPane grid;
	BorderPane main;
	KenoInfo betCard;
	int MaxTaps = 0;
	Node askHoyMany, randNode, numOfDraw, submit;
	Random rand;
	ArrayList<myButton> theButtons;
	Boolean disabled = true;
	Image keno;

	GridPane winningNumbers, yourNumbers , matchedNumbers;

	VBox yourNums, winningNums, numberBox, box;


	@Override
	public void start(Stage primaryStage) throws Exception {
		popUpRules = new Popup();
		popUpOdds  = new Popup();
		playDraws = new Button("Submit");
		playDraws.setDisable(true);
		submit = submitBox();
		allNumbers = new Label();

		primaryStage.setTitle("Welcome to Keno Game");

		//setting environment
		mainMenuBtn = new Button("Back");
		menu = new MenuBar();
		playGame = new Button("Play Keno");
		newLook = new Button("Dark Theme");

		//create menu
		mOne = new Menu("Menu");

		//create menu items
		Rules = new MenuItem("Rules");
		Odds_of_Winning = new MenuItem("Odds of winning");
		Exit = new MenuItem("Exit Game");

		//add items to menu
		mOne.getItems().addAll(Rules,Odds_of_Winning,Exit);

		//add menus to menu bar
		menu.getMenus().addAll(mOne);

		//question 1
		spot1 =new Button("1");
		spot1.setAlignment(Pos.CENTER);
		spot4 =new Button("4");
		spot4.setAlignment(Pos.CENTER);
		spot8 = new Button("8");
		spot8.setAlignment(Pos.CENTER);
		spot10 = new Button("10");
		spot10.setAlignment(Pos.CENTER);
		q1 = new Label("How many spots\nyou want to play: ");

		//grid game play
		grid = new GridPane();
		theButtons = new ArrayList<myButton>();
		grid.setAlignment(Pos.CENTER);
		addGrid(grid);

		//setting up border pane
		main = new BorderPane();
		main.setTop(menu);
		main.setBottom(mainMenuBtn);
		mainMenuBtn.setVisible(false);
		betCard = new KenoInfo();
		askHoyMany = howManySpots();
		randNode = automaticChoice();
		rand = new Random();
		draw1 = new Button("1");
		draw2 = new Button("2");
		draw3 = new Button("3");
		draw4 = new Button("4");
		numOfDraw = howManydraws();
		popUpRules.getContent().add(rulestxt());
		popUpOdds.getContent().add(Odds_Winning());

		winningNumbers = new GridPane();
		yourNumbers =  new GridPane();
		matchedNumbers = new GridPane();
		t1 = new Label("YOUR NUMBERS:");
		t2 = new Label("NUMBER DRAWS");
		t3 = new Label("NUMBERS MATCHED:");
		yourNums = new VBox(10, t1,yourNumbers);
		winningNums = new VBox(10,t2,winningNumbers);
		numberBox = new VBox();
		retry = new Button("RETRY");
		retry.setAlignment(Pos.CENTER);
		box = new VBox(retry);
		box.setAlignment(Pos.CENTER);

		money = new Button("Your current\nmoney:$" + Integer.toString(betCard.money));
		newLook = new Button("Dark Theme");
		final Boolean[] newLookChange = new Boolean[1];
		VBox hbox = new VBox(30, newLook, money);
		main.setRight(hbox);

		//used to position play button in the middle
		Button unav = new Button("Unavaliable");
		main.setLeft(unav);
		unav.setVisible(false);

		//light background
		keno = new Image("file:src/main/resources/kenoback.jpg");
		BackgroundImage kenoBack = new BackgroundImage(keno, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		Background kenoB = new Background(kenoBack);

		//dark background
		Image kenoDark = new Image("file:src/main/resources/kenobackDark.jpg");
		BackgroundImage kenoBackDark = new BackgroundImage(kenoDark, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				BackgroundSize.DEFAULT);
		Background kenoBDark = new Background(kenoBackDark);

		main.setBackground(kenoB);

		//setting styles
		money.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		money.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-radius: 5;");

		q1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		q1.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-radius: 5;");

		t1.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		t1.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-radius: 5;");

		t2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		t2.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-radius: 5;");

		t3.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		t3.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-radius: 5;");

		playGame.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 24));
		playGame.setStyle("-fx-background-color: #FFFFED; -fx-border-color: black; -fx-border-radius: 5;");

		newLook.setFont(Font.font("Comic Sans MS", 14));
		newLook.setStyle("-fx-background-color: #FFFFED; -fx-border-color: black; -fx-border-radius: 5;");

		spot1.setFont(Font.font("Comic Sans MS", 14));
		spot1.setStyle("-fx-background-color: #FFFFED; -fx-border-color: black; -fx-border-radius: 5;");

		spot4.setFont(Font.font("Comic Sans MS", 14));
		spot4.setStyle("-fx-background-color: #FFFFED; -fx-border-color: black; -fx-border-radius: 5;");

		spot8.setFont(Font.font("Comic Sans MS", 14));
		spot8.setStyle("-fx-background-color: #FFFFED; -fx-border-color: black; -fx-border-radius: 5;");

		spot10.setFont(Font.font("Comic Sans MS", 14));
		spot10.setStyle("-fx-background-color: #FFFFED; -fx-border-color: black; -fx-border-radius: 5;");

		draw1.setFont(Font.font("Comic Sans MS", 14));
		draw1.setStyle("-fx-background-color: #FFFFED; -fx-border-color: black; -fx-border-radius: 5;");

		draw2.setFont(Font.font("Comic Sans MS", 14));
		draw2.setStyle("-fx-background-color: #FFFFED; -fx-border-color: black; -fx-border-radius: 5;");

		draw3.setFont(Font.font("Comic Sans MS", 14));
		draw3.setStyle("-fx-background-color: #FFFFED; -fx-border-color: black; -fx-border-radius: 5;");

		draw4.setFont(Font.font("Comic Sans MS", 14));
		draw4.setStyle("-fx-background-color: #FFFFED; -fx-border-color: black; -fx-border-radius: 5;");

		playDraws.setFont(Font.font("Comic Sans MS", 14));
		playDraws.setStyle("-fx-background-color: #FFFFED; -fx-border-color: black; -fx-border-radius: 5;");

		retry.setFont(Font.font("Comic Sans MS", 14));
		retry.setStyle("-fx-background-color: #FFFFED; -fx-border-color: black; -fx-border-radius: 5;");

		allNumbers.setAlignment(Pos.CENTER_LEFT);
		winningNumbers.setAlignment(Pos.CENTER);
		yourNumbers.setAlignment(Pos.CENTER);
		matchedNumbers.setAlignment(Pos.CENTER);
		t1.setAlignment(Pos.CENTER);
		yourNums.setAlignment(Pos.CENTER_LEFT);
		winningNums.setAlignment(Pos.CENTER);
		numberBox.setAlignment(Pos.CENTER_LEFT);

		//set on action buttons
		Exit.setOnAction(e -> {Platform.exit();});

		retry.setOnAction(e-> {
			//resetting everything
			betCard.amountWon = 0;
			matchedNumbers.getChildren().clear();
			winningNumbers.getChildren().clear();
			yourNumbers.getChildren().clear();
			submit = submitBox();
			playDraws.setText("Submit");
			betCard.limitDraws = 0;
			betCard.limit = 0;
			grid.getChildren().clear();
			betCard.spots.removeAll(betCard.spots);
			betCard.winningNumbers.removeAll(betCard.winningNumbers);
			betCard.numbersMatch.removeAll(betCard.numbersMatch);
			draw1.setDisable(false);
			draw2.setDisable(false);
			draw3.setDisable(false);
			draw4.setDisable(false);
			spot1.setDisable(false);
			spot4.setDisable(false);
			spot8.setDisable(false);
			spot10.setDisable(false);
			main.setLeft(null);
			main.setRight(null);
			main.setBottom(null);
			money.setText("Your current\nmoney:$" + betCard.money);
			main.setLeft(unav);
			main.setRight(hbox);
			main.setCenter(playGame);
		});

		//pop up windows showing information
		popUpRules.setAutoHide(true);
		Rules.setOnAction(e-> {
			if (!popUpRules.isShowing())
				popUpRules.show(primaryStage);
		});
		popUpOdds.setAutoHide(true);
		Odds_of_Winning.setOnAction(e->{
			if (!popUpOdds.isShowing())
				popUpOdds.show(primaryStage);
		});

		//menu showing options
		mainMenuBtn.setOnAction(e -> {
			main.setLeft(null);
			main.setCenter(playGame);
			mainMenuBtn.setVisible(false);
		});

		playGame.setOnAction(e -> {
			VBox box = new VBox(20,askHoyMany,numOfDraw);
			box.setAlignment(Pos.CENTER);
			main.setCenter(box);
		});

		final Button[] b5 = new Button[1];
		playDraws.setOnAction(e-> {
			winningNumbers.getChildren().clear();
			matchedNumbers.getChildren().clear();
			VBox matchedNums = new VBox(10, t3,matchedNumbers,playDraws);
			matchedNums.setAlignment(Pos.CENTER);
			playDraws.setText("Next Draw");
			main.setLeft(yourNums);
			main.setCenter(winningNums);
			betCard.delAndGen();
			betCard.checkSpots();
			Timeline tl = new Timeline();
			tl.setCycleCount(20);
			final Integer[] num = {0};
			final Integer[] num2 = {0};
			final Integer[] num3 = {0};

			if(betCard.numbersMatch.isEmpty()){
				t3.setText("NO NUMBERS MATCHED :'(");
			}else {
				t3.setText("NUMBERS MATCHED:");
				for (int i = 0; i < betCard.numbersMatch.size(); i++) {
					b5[0] = new Button(Integer.toString(betCard.numbersMatch.get(i)));

					b5[0].setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
					b5[0].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-radius: 5;");

					b5[0].setMinSize(30, 30);
					matchedNumbers.add(b5[0], 0, i);
				}
			}

			for(int i = 0; i< betCard.spots.size(); i++){
				b5[0] =new Button(Integer.toString(betCard.spots.get(i)));

				b5[0].setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
				b5[0].setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-radius: 5;");


				b5[0].setMinSize(30,30);
				yourNumbers.add(b5[0],0,i);
			}

			KeyFrame moveBall = new KeyFrame(Duration.seconds(.5000),
					new EventHandler<ActionEvent>() {
						public void handle(ActionEvent event) {
							b5[0] =new Button(Integer.toString(betCard.winningNumbers.get(num[0])));
							b5[0].setShape(new Circle(1.5));
							b5[0].setMaxSize(30,30);
							b5[0].setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20));
							b5[0].setStyle("-fx-background-color: white; -fx-border-color: black" );
							if(num2[0] == 5){
								num2[0] = 0;
								num3[0] += 1;
							}
							winningNumbers.add(b5[0],num2[0],num3[0]);
							num2[0] +=1;
							num[0] += 1;
							if(num[0] == 20){
								if(betCard.limitDraws != 1) {
									main.setRight(matchedNums);
									betCard.limitDraws--;
								}
								else{
									main.setRight(matchedNums);
									playDraws.setText("Amount won: $" + betCard.amountWon);
									playDraws.setDisable(true);
									main.setBottom(box);
								}
							}
						}
					});

			tl.getKeyFrames().add(moveBall);
			tl.play();
		});

		newLookChange[0] = false;
		newLook.setOnAction(e -> {
			if(!newLookChange[0]) {
				main.setBackground(kenoBDark);
				newLookChange[0] = true;
				newLook.setText("Light Theme");
			}
			else{
				main.setBackground(kenoB);
				newLookChange[0] = false;
				newLook.setText("Dark Theme");
			}
		});

		main.setCenter(btn());
		Scene root = new Scene(main,700,500);
		primaryStage.setScene(root);
		primaryStage.show();
	}

	//creating and setting playdraws
	public Node submitBox(){
		playDraws.setDisable(true);
		HBox box = new HBox(playDraws);
		box.setAlignment(Pos.CENTER);
		return box;
	}

	//setting random choice
	public Node automaticChoice(){
		Button random = new Button("RANDOM NUMBERS");
		random.setFont(Font.font("Comic Sans MS", 14));
		random.setStyle("-fx-background-color: #FFFFED; -fx-border-color: black; -fx-border-radius: 5;");
		random.setOnAction(e->{
			theButtons.removeAll(theButtons);
			grid.getChildren().clear();
			addGrid(grid);
			betCard.spots.removeAll(betCard.spots);
			MaxTaps = 0;
			//how to make it work
			while(betCard.spots.size() < betCard.limit ) {
				int temp = rand.nextInt(80);
				theButtons.get(temp).setSelected(true);
				if(!betCard.spots.contains(theButtons.get(temp).getNum())) {
					betCard.spots.add(theButtons.get(temp).getNum());
					MaxTaps++;
				}
			}
			playDraws.setDisable(false);
		});

		random.setAlignment(Pos.CENTER);

		VBox box = new VBox(random);
		box.setAlignment(Pos.CENTER);
		return box;
	}

	//setting up how many draws to do option
	public Node howManydraws(){
		HBox choices = new HBox(draw1,draw2,draw3,draw4);
		choices.setAlignment(Pos.CENTER);
		Label q2 = new Label("How many draws");

		q2.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 15));
		q2.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-radius: 5;");

		VBox box = new VBox(q2,choices);
		draw1.setAlignment(Pos.CENTER);
		draw2.setAlignment(Pos.CENTER);
		draw3.setAlignment(Pos.CENTER);
		draw4.setAlignment(Pos.CENTER);

		draw1.setOnAction(e -> {
			betCard.setLimitDraw(1);
			draw1.setDisable(true);
			draw2.setDisable(false);
			draw3.setDisable(false);
			draw4.setDisable(false);
			if(betCard.limit != 0){
				VBox newBox = new VBox(20,askHoyMany,numOfDraw);
				newBox.setAlignment(Pos.CENTER);
				main.setLeft(newBox);
				playDraws.setVisible(true);
				submit.setVisible(true);
				main.setCenter(new VBox(30, randNode, grid,submit));
			}
		});
		draw2.setOnAction(e -> {
			betCard.setLimitDraw(2);
			draw1.setDisable(false);
			draw2.setDisable(true);
			draw3.setDisable(false);
			draw4.setDisable(false);
			if(betCard.limit != 0){
				VBox newBox = new VBox(20,askHoyMany,numOfDraw);
				newBox.setAlignment(Pos.CENTER);
				main.setLeft(newBox);
				main.setCenter(new VBox(30,randNode, grid,submit));
			}
		});
		draw3.setOnAction(e -> {
			betCard.setLimitDraw(3);
			draw1.setDisable(false);
			draw2.setDisable(false);
			draw3.setDisable(true);
			draw4.setDisable(false);
			if(betCard.limit != 0){
				VBox newBox = new VBox(20,askHoyMany,numOfDraw);
				newBox.setAlignment(Pos.CENTER);
				main.setLeft(newBox);
				main.setCenter(new VBox(30,randNode, grid,submit));
			}
		});
		draw4.setOnAction(e -> {
			betCard.setLimitDraw(4);
			draw1.setDisable(false);
			draw2.setDisable(false);
			draw3.setDisable(false);
			draw4.setDisable(true);
			if(betCard.limit != 0){
				VBox newBox = new VBox(20,askHoyMany,numOfDraw);
				newBox.setAlignment(Pos.CENTER);
				main.setLeft(newBox);
				main.setCenter(new VBox(30,randNode, grid,submit));
			}
		});
		box.setAlignment(Pos.CENTER);
		return box;
	}

	//setting up how many spots to do option
	public Node howManySpots(){
		HBox choices = new HBox(spot1,spot4,spot8,spot10);
		choices.setAlignment(Pos.CENTER);
		VBox box = new VBox(q1,choices);
		spot1.setAlignment(Pos.CENTER);
		spot4.setAlignment(Pos.CENTER);
		spot8.setAlignment(Pos.CENTER);
		spot10.setAlignment(Pos.CENTER);

		spot1.setOnAction(e -> {
			betCard.spots.removeAll(betCard.spots);
			theButtons.removeAll(theButtons);
			MaxTaps = 0;
			betCard.setLimit(1);
			grid.getChildren().clear();
//			main.setCenter(null);
			spot1.setDisable(true);
			spot4.setDisable(false);
			spot8.setDisable(false);
			spot10.setDisable(false);
			addGrid(grid);
			if(betCard.limitDraws != 0){
				VBox newBox = new VBox(20,askHoyMany,numOfDraw);
				newBox.setAlignment(Pos.CENTER);
				main.setLeft(newBox);
				main.setCenter(new VBox(30,randNode, grid,submit));
			}
		});
		spot4.setOnAction(e -> {
			betCard.spots.removeAll(betCard.spots);
			theButtons.removeAll(theButtons);
			MaxTaps = 0;
			betCard.setLimit(4);
			grid.getChildren().clear();
//			main.setCenter(null);
			spot1.setDisable(false);
			spot4.setDisable(true);
			spot8.setDisable(false);
			spot10.setDisable(false);
			addGrid(grid);
			if(betCard.limitDraws != 0){
				VBox newBox = new VBox(20,askHoyMany,numOfDraw);
				newBox.setAlignment(Pos.CENTER);
				main.setLeft(newBox);
				main.setCenter(new VBox(30,randNode, grid,submit));
			}
		});
		spot8.setOnAction(e -> {
			theButtons.removeAll(theButtons);
			betCard.spots.removeAll(betCard.spots);
			MaxTaps = 0;
			betCard.setLimit(8);
			grid.getChildren().clear();
//			main.setCenter(null);
			spot1.setDisable(false);
			spot4.setDisable(false);
			spot8.setDisable(true);
			spot10.setDisable(false);
			addGrid(grid);
			if(betCard.limitDraws != 0){
				VBox newBox = new VBox(20,askHoyMany,numOfDraw);
				newBox.setAlignment(Pos.CENTER);
				main.setLeft(newBox);
				main.setCenter(new VBox(30,randNode, grid,submit));
			}
		});
		spot10.setOnAction(e -> {
			theButtons.removeAll(theButtons);
			betCard.spots.removeAll(betCard.spots);
			MaxTaps = 0;
			betCard.setLimit(10);
			grid.getChildren().clear();
			spot1.setDisable(false);
			spot4.setDisable(false);
			spot8.setDisable(false);
			spot10.setDisable(true);
			addGrid(grid);
			if(betCard.limitDraws != 0){
				VBox newBox = new VBox(20,askHoyMany,numOfDraw);
				newBox.setAlignment(Pos.CENTER);
				main.setLeft(newBox);
				main.setCenter(new VBox(30,randNode, grid,submit));
			}
		});

		box.setAlignment(Pos.CENTER);
		return box;
	}

	//adding buttons to grid
	public void addGrid(GridPane grid) {
		int num = 0;
		for(int x = 0; x<8; x++) {
			for(int i = 0; i<10; i++) {
				num += 1;
				myButton tempButton = new myButton(num);
				tempButton.setMinSize(40,40);
				tempButton.setOnAction(e-> {
					if(tempButton.isSelected()){
						if(MaxTaps < betCard.limit){
							MaxTaps +=1;

							if(betCard.limit >= betCard.spots.size()){
								betCard.spots.add(tempButton.getNum());
							}

							if (MaxTaps == betCard.limit){
								if (disabled){
									playDraws.setDisable(false);
								}
								disabled = false;
							}
						}
						else{
							tempButton.setSelected(false);
						}
					}
					else{
						if(!tempButton.isSelected() && betCard.spots.contains(tempButton.getNum())){
							betCard.spots.remove((tempButton.getNum()));
						}
//						main.setBottom(null);
						playDraws.setDisable(true);
						disabled = true;
						MaxTaps--;
					}
				});
				theButtons.add(tempButton);
				grid.add(tempButton, i, x);
			}

		}
	}

	public Node btn(){
		return playGame;
	}


	//seting up images for pop up window
	public ImageView rulestxt(){
		Image rule = new Image("KenoPlaySlip2020.jpg");
		ImageView v = new ImageView(rule);
		v.setFitHeight(700);
		v.setFitWidth(600);
		return v;
	}

	public Node Odds_Winning(){
		Image rule = new Image("KenoPrizeChart2020.jpg");
		ImageView v = new ImageView(rule);
		v.setFitHeight(700);
		v.setFitWidth(600);
		return v;
	}

}