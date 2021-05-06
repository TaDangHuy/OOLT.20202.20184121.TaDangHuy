package application; 

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
	
	private int count;
	Stage window;
	Scene sceneMain,scene1 ,scene2 ,scene3 ,scene4,scene0, sceneForCD ,sceneForDVD ,sceneforBook ,sceneAddTrack ,sceneAddAuthors ;
	public static void main(String[] args) {
		launch(args);
	}
	
	//SenceForCDM()
	public void SceneForCDM(Order anOrder) {
			CompactDisc CD = new CompactDisc();
			Button returnbtn = new Button("Return");
			returnbtn.setPrefHeight(30);
			returnbtn.setPrefWidth(100);
			
			Button donebtn = new Button("Done");
			donebtn.setPrefHeight(30);
			donebtn.setPrefWidth(100);
			
			Button addTrackbtn = new Button("AddTrack");
			addTrackbtn.setPrefHeight(30);
			addTrackbtn.setPrefWidth(100);
			
			HBox return_Track_Done = new HBox();
			return_Track_Done.getChildren().addAll(returnbtn,addTrackbtn,donebtn);
			
			GridPane layout = new GridPane();
			layout.setHgap(10);
			layout.setVgap(10);
			
			layout.add(new Label("ID: "), 0 ,0);
			TextField txt1 = new TextField();
			layout.add(txt1, 1 ,0);
			layout.add(new Label("Title:   "), 0 ,1);
			TextField txt2 = new TextField();
			layout.add(txt2, 1 ,1);
			layout.add(new Label("Category:"), 0 ,2);
			TextField txt3 = new TextField();
			layout.add(txt3, 1 ,2);
			layout.add(new Label("Cost: "), 0 ,3);
			TextField txt4 = new TextField();
			layout.add(txt4, 1 ,3);
			layout.add(new Label("Director: "), 0 ,4);
			TextField txt5 = new TextField();
			layout.add(txt5, 1 ,4);
			
		
			returnbtn.setOnAction(evet->{
				window.setScene(sceneMain);
			});
			
			addTrackbtn.setOnAction(evt->{
				SceneAddTrackM(anOrder,CD);
				window.setScene(sceneAddTrack);
			});
			
			donebtn.setOnAction(evt->{
				CD.setId(Integer.parseInt(txt1.getText()));
				CD.setTitle(txt2.getText());
				CD.setCategory(txt3.getText());
				CD.setCost(Float.parseFloat(txt4.getText()));
				CD.setDirector(txt5.getText());
						
				anOrder.addMedia(CD);
				
				int result = JOptionPane.showConfirmDialog(null,"Do you want to play it?", "Swing Tester",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
			            if(result == JOptionPane.YES_OPTION){
			            	CD.play();
			            }
			    window.setScene(sceneMain);
			});
			
			
			VBox root = new VBox();
			root.getChildren().addAll(layout,return_Track_Done);
		
			sceneForCD = new Scene(root, 300, 200);
		
	}
	
	//SenceForDVDM()
		public void SceneForDVDM(Order anOrder) {
				Button returnbtn = new Button("Return");
				returnbtn.setPrefHeight(30);
				returnbtn.setPrefWidth(150);
				
				Button donebtn = new Button("Done");
				donebtn.setPrefHeight(30);
				donebtn.setPrefWidth(150);
				
				HBox return_Done = new HBox();
				return_Done.getChildren().addAll(returnbtn,donebtn);
				
				GridPane layout = new GridPane();
				layout.setHgap(10);
				layout.setVgap(10);
				
				layout.add(new Label("ID: "), 0 ,0);
				TextField txt1 = new TextField();
				layout.add(txt1, 1 ,0);
				layout.add(new Label("Title:   "), 0 ,1);
				TextField txt2 = new TextField();
				layout.add(txt2, 1 ,1);
				layout.add(new Label("Category:"), 0 ,2);
				TextField txt3 = new TextField();
				layout.add(txt3, 1 ,2);
				layout.add(new Label("Cost: "), 0 ,3);
				TextField txt4 = new TextField();
				layout.add(txt4, 1 ,3);
				layout.add(new Label("Length: "), 0 ,4);
				TextField txt5 = new TextField();
				layout.add(txt5, 1 ,4);
				layout.add(new Label("Diretor: "), 0 ,5);
				TextField txt6 = new TextField();
				layout.add(txt6, 1 ,5);
				
				returnbtn.setOnAction(evet->{
					window.setScene(sceneMain);
				});
				
				donebtn.setOnAction(evt->{
					DigitalVideoDisc DVD = new DigitalVideoDisc(
							Integer.parseInt(txt1.getText()), txt2.getText(),txt3.getText() ,
							Float.parseFloat(txt4.getText()), Float.parseFloat(txt5.getText()) , txt6.getText());
					anOrder.addMedia(DVD);
					
					int result = JOptionPane.showConfirmDialog(null,"Do you want to play it?", "Swing Tester",
				               JOptionPane.YES_NO_OPTION,
				               JOptionPane.QUESTION_MESSAGE);
				            if(result == JOptionPane.YES_OPTION){
				               DVD.play();
				            }
				            
				});
				
				VBox root4 = new VBox();
				root4.getChildren().addAll(layout,return_Done);
			
				sceneForDVD = new Scene(root4, 300, 250);
		}
		
	//SenceForBookM()
		public void SceneForBookM(Order anOrder) {
			Book book = new Book();
			
			Button returnbtn = new Button("Return");
			returnbtn.setPrefHeight(30);
			returnbtn.setPrefWidth(100);
			
			Button donebtn = new Button("Done");
			donebtn.setPrefHeight(30);
			donebtn.setPrefWidth(100);
			
			Button addAuthorbtn = new Button("AddAuthor");
			addAuthorbtn.setPrefHeight(30);
			addAuthorbtn.setPrefWidth(100);
		
			returnbtn.setLayoutY(170);
			donebtn.setLayoutY(170);
			addAuthorbtn.setLayoutY(170);
			
			returnbtn.setOnAction(evet->{
				window.setScene(sceneMain);
			});
			
			HBox return_Author_Done = new HBox();
			return_Author_Done.getChildren().addAll(returnbtn,addAuthorbtn,donebtn);
			
			GridPane layout = new GridPane();
			layout.setHgap(10);
			layout.setVgap(10);
			
			layout.add(new Label("ID: "), 0 ,0);
			TextField txt1 = new TextField();
			layout.add(txt1, 1 ,0);
			layout.add(new Label("Title:   "), 0 ,1);
			TextField txt2 = new TextField();
			layout.add(txt2, 1 ,1);
			layout.add(new Label("Category:"), 0 ,2);
			TextField txt3 = new TextField();
			layout.add(txt3, 1 ,2);
			layout.add(new Label("Cost: "), 0 ,3);
			TextField txt4 = new TextField();
			layout.add(txt4, 1 ,3);
		
			donebtn.setOnAction(evt->{
				book.setId(Integer.parseInt(txt1.getText()));
				book.setTitle(txt2.getText());
				book.setCategory(txt3.getText() );
				book.setCost(Float.parseFloat(txt4.getText()));
						
				anOrder.addMedia(book);
				
			});
			
			addAuthorbtn.setOnAction(evt->{
				SceneAddAuthorsM(book);
				window.setScene(sceneAddAuthors);
			});
			VBox root = new VBox();
			root.getChildren().addAll(layout,return_Author_Done);
		
			sceneforBook = new Scene(root, 300, 200);
		
	}	
	
	//SceneAddTrack
		public void SceneAddTrackM(Order anOrder,CompactDisc CD) {
			Label label1 = new Label("Enter some track:");
			label1.setFont(new Font(STYLESHEET_CASPIAN, 20));
			
			Label label2 = new Label("Enter title of track:");
			label2.setFont(new Font(STYLESHEET_CASPIAN, 15));
			
			TextField tfTittle = new TextField();
			tfTittle.setPromptText("Enter the tittle");
			tfTittle.setLayoutY(40);
			
			Label label3 = new Label("Enter length:");
			label3.setFont(new Font(STYLESHEET_CASPIAN, 15));
			
			TextField tfLength = new TextField();
			tfLength.setPromptText("Enter length");
			
			
			Button cancelbtn = new Button("Cancel");
			cancelbtn.setPrefHeight(30);
			cancelbtn.setPrefWidth(150);
			
			Button nextbtn = new Button("Next");
			nextbtn.setPrefHeight(30);
			nextbtn.setPrefWidth(150);
			
			cancelbtn.setOnAction(evet->{
				window.setScene(sceneForCD);
			});
			
			nextbtn.setOnAction(evt->{
				try {
				Track track = new Track(tfTittle.getText(), Integer.parseInt(tfLength.getText()));
				CD.addTrack(track);
				}catch(Exception e) {
					System.err.println(e);
				};
				window.setScene(sceneForCD);
			});
			
			HBox cancel_remove = new HBox();
			cancel_remove.getChildren().addAll(cancelbtn,nextbtn);
			
			VBox layoutS3 = new VBox();
			layoutS3.getChildren().addAll(label1,label2,tfTittle,label3,tfLength,cancel_remove);
			sceneAddTrack = new Scene(layoutS3, 300, 200);
			
		}
		
	//SceneAddAuthor
		public void SceneAddAuthorsM(Book book) {
			Label label1 = new Label("Enter some authors:");
			label1.setFont(new Font(STYLESHEET_CASPIAN, 20));
					
			Label label2 = new Label("Enter authorName:");
			label2.setFont(new Font(STYLESHEET_CASPIAN, 15));
					
			TextField tfAuName = new TextField();
			tfAuName.setPromptText("Enter authorName");
			tfAuName.setLayoutY(40);	
					
			Button cancelbtn = new Button("Cancel");
			cancelbtn.setPrefHeight(30);
			cancelbtn.setPrefWidth(150);
					
			Button nextbtn = new Button("Next");
			nextbtn.setPrefHeight(30);
			nextbtn.setPrefWidth(150);
					
			cancelbtn.setOnAction(evet->{
					window.setScene(sceneforBook);
				});
					
			nextbtn.setOnAction(evt->{
				book.addAuthor(tfAuName.getText());
					window.setScene(sceneforBook);
				});
					
			HBox cancel_remove = new HBox();
			cancel_remove.getChildren().addAll(cancelbtn,nextbtn);
					
			VBox layoutS3 = new VBox();
			layoutS3.getChildren().addAll(label1,label2,tfAuName,cancel_remove);
			sceneAddAuthors = new Scene(layoutS3, 300, 200);
					
		}	
		
	//Menu
	public void SceneMainM() {
		Label label = new Label("Welcom to AimsProject ");
		label.setFont(new Font(STYLESHEET_CASPIAN, 20));;
		
		Button button1= new Button("1. Create new order");
		button1.setPrefHeight(30);
		button1.setPrefWidth(300);
		button1.setLayoutY(50);
		
		Button button2= new Button("2. Add item to the order");
		button2.setPrefHeight(30);
		button2.setPrefWidth(300);
		button2.setLayoutY(80);
		
		Button button3= new Button("3. Delete item by id");
		button3.setPrefHeight(30);
		button3.setPrefWidth(300);
		button3.setLayoutY(110);
		
		Button button4= new Button("4. Display the items list of order");
		button4.setPrefHeight(30);
		button4.setPrefWidth(300);
		button4.setLayoutY(140);
		
		Button button0= new Button("0. Exit");
		button0.setPrefHeight(30);
		button0.setPrefWidth(300);
		button0.setLayoutY(170);
		
		
		button1.setOnAction(evt->{
			window.setScene(scene1);
		});
		
		button1.setOnAction(evt->{
			window.setScene(scene1);
		});
		button2.setOnAction(evt->{
			window.setScene(scene2);
		});
		button3.setOnAction(evt->{
			window.setScene(scene3);
		});
		button4.setOnAction(evt->{
			window.setScene(scene4);
		});
		
		Pane layoutMain = new Pane();
		layoutMain.getChildren().addAll(label,button1,button2,button3,button4,button0);
		sceneMain = new Scene(layoutMain, 300, 200);
	}
	
	public void Scene1M(Order anOrder) {
		Label labelS1 = new Label("Create new order successfull!");
		labelS1.setFont(new Font(STYLESHEET_CASPIAN, 20));;
		
		Button Returnbutton1 = new Button("Return");
		Returnbutton1.setPrefHeight(30);
		Returnbutton1.setPrefWidth(300);
		Returnbutton1.setLayoutY(170);
		
		Returnbutton1.setOnAction(evet->{
			window.setScene(sceneMain);
		});
		
		Pane layoutS1 = new Pane();
		layoutS1.getChildren().addAll(labelS1,Returnbutton1);
		scene1 = new Scene(layoutS1, 300, 200);
		
	}
	
	public void Scene2M(Order anOrder) {
		Label labelS2 = new Label("Please choose the type of item you want to add:");
		labelS2.setFont(new Font(STYLESHEET_CASPIAN, 13));;
	
		Button button1= new Button("1. CD");
		button1.setPrefHeight(30);
		button1.setPrefWidth(300);
		button1.setLayoutY(50);
		
		Button button2= new Button("2. DVD");
		button2.setPrefHeight(30);
		button2.setPrefWidth(300);
		button2.setLayoutY(80);
		
		Button button3= new Button("3. Book");
		button3.setPrefHeight(30);
		button3.setPrefWidth(300);
		button3.setLayoutY(110);
		
		button1.setOnAction(evt->{
			SceneForCDM(anOrder);
			window.setScene(sceneForCD);
		});
		button2.setOnAction(evt->{
			SceneForDVDM(anOrder);
			window.setScene(sceneForDVD);
		});
		button3.setOnAction(evt->{
			SceneForBookM(anOrder);
			window.setScene(sceneforBook);
		});
		
		Button Returnbutton2 = new Button("Return");
		Returnbutton2.setPrefHeight(30);
		Returnbutton2.setPrefWidth(300);
		Returnbutton2.setLayoutY(170);
		
		Returnbutton2.setOnAction(evet->{
			window.setScene(sceneMain);
		});
		
		Pane layoutS2 = new Pane();
		layoutS2.getChildren().addAll(labelS2,Returnbutton2,button1,button2,button3);
		scene2 = new Scene(layoutS2, 300, 200);
	}
	
	public void Scene3M(Order anOrder) {
		Label label = new Label("Enter id to remove:");
		label.setFont(new Font(STYLESHEET_CASPIAN, 20));
		
		TextField tfID = new TextField();
		tfID.setPromptText("Enter the id(Int)");
		tfID.setLayoutY(40);
		
		Button cancelButton = new Button("Cancel");
		cancelButton.setPrefHeight(30);
		cancelButton.setPrefWidth(150);
		
		Button removeButton = new Button("Remove");
		removeButton.setPrefHeight(30);
		removeButton.setPrefWidth(150);
		
		cancelButton.setOnAction(evet->{
			window.setScene(sceneMain);
		});
		
		removeButton.setOnAction(evt->{
			anOrder.removeMediaById(Integer.parseInt(tfID.getText()));
		});
		
		HBox cancel_remove = new HBox();
		cancel_remove.getChildren().addAll(cancelButton,removeButton);
		
		VBox layoutS3 = new VBox();
		layoutS3.getChildren().addAll(label,tfID,cancel_remove);
		scene3 = new Scene(layoutS3, 300, 200);
		
	}
	
	public void Scene4M(Order anOrder) {
		Button Returnbutton4 = new Button("Return");
		Returnbutton4.setPrefHeight(30);
		Returnbutton4.setPrefWidth(300);
		
		Button Startbutton4 = new Button("Start");
		Startbutton4.setPrefHeight(30);
		Startbutton4.setPrefWidth(150);
		
		Button Nextbutton4 = new Button("Next");
		Nextbutton4.setPrefHeight(30);
		Nextbutton4.setPrefWidth(150);
		
		Returnbutton4.setOnAction(evet->{
			window.setScene(sceneMain);
		});
		
		HBox start_return = new HBox();
		start_return.getChildren().addAll(Startbutton4,Nextbutton4);
		
		GridPane layoutS4 = new GridPane();
		layoutS4.setHgap(10);
		layoutS4.setVgap(10);
		
		layoutS4.add(new Label("Date: "), 0 ,0);
		TextField txt1 = new TextField();
		layoutS4.add(txt1, 1 ,0);
		layoutS4.add(new Label("id:   "), 0 ,1);
		TextField txt2 = new TextField();
		layoutS4.add(txt2, 1 ,1);
		layoutS4.add(new Label("title:"), 0 ,2);
		TextField txt3 = new TextField();
		layoutS4.add(txt3, 1 ,2);
		layoutS4.add(new Label("category: "), 0 ,3);
		TextField txt4 = new TextField();
		layoutS4.add(txt4, 1 ,3);
		layoutS4.add(new Label("cost: "), 0 ,4);
		TextField txt5 = new TextField();
		layoutS4.add(txt5, 1 ,4);
		
		count = 0;
		Startbutton4.setOnAction(evt->{
			Nextbutton4.setOnAction(evt2->{
				if(count<anOrder.getItemsOrdered().size()) {
					System.out.println(count);
					txt1.setText(anOrder.getDateOrdered().print() + "");
					txt2.setText(anOrder.getItemsOrdered().get(count).getId() + "");
					txt3.setText(anOrder.getItemsOrdered().get(count).getTitle() + "");
					txt4.setText(anOrder.getItemsOrdered().get(count).getCategory() + "");
					txt5.setText(anOrder.getItemsOrdered().get(count).getCost() + "");
					count++;
				}
			});
		});
		
		VBox root4 = new VBox();
		root4.getChildren().addAll(layoutS4,start_return,Returnbutton4);
		
		
		scene4 = new Scene(root4, 300, 230);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setResizable(false);
		
		Order anOrder = new Order();
		//SceneMain
		SceneMainM();
		//Scene1
		Scene1M(anOrder);
		//Scene2
		Scene2M(anOrder);
		//Scene3
		Scene3M(anOrder);
		//Scene4
		Scene4M(anOrder);
		
		//Start
		window.setScene(sceneMain);
		window.setTitle("Aims Application");
		window.show();
		
	}

}
