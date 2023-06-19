package com.example.internalassesmentchemquzier;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class GameController {

    public Label questionLbl;
    public Label AnsOneLbl;
    public Label AnsTwoLbl;
    public Label AnsThreeLbl;
    public Label hintOneLbl;
    public Label hintTwoLbl;
    public Label timerLbl;

    public ObservableList<Element> elements = FXCollections.observableArrayList();
    public Button aBtnID;
    public Button bBtnID;
    public Button cBtnID;
    public Label correctOrNotLabel;
    int currentQuestion = 0;
    int timerSeconds = 0;
    int timerMinutes =5;
    Timer timer = new Timer();
    public void initialize() throws IOException {
        int highScore = 0;
        //Create 6 random questions using data from the periodic table.

        createQuizQuestions(5);

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    updateTime();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            };
        };
        timer.scheduleAtFixedRate(timerTask, new Date(), 1000);


    //questions.add(new Question(,,,));
      //  saveBtn();

        //Load question
        loadQuestion(currentQuestion);
        currentQuestion++;
        //start the timer
        /** TO DO **/
    }
    int questionsAnswered = 0;

    boolean CI = false;
    public void updateTime() throws IOException {
        if (timerSeconds == 0 && timerMinutes == 0) {
            timer.cancel();
            return;
        }

        if(correctOrNotLabel.getText().equals("Correct Answer!")){
            if(CI){
                if (questionsAnswered == 5){
                    //Get number of correct answers and add it to the high score list..


                    HelloApplication.setRoot("highScore-view");
                }
                questionsAnswered++;

                for (int i = 0; i<timerMinutes;){
                    HelloApplication.highScore += 60;
                }
                HelloApplication.highScore += timerSeconds;
                //add this number to the arraylist
                //Save this to a json file (in this class)

                //Create an arraylist of high scores in the helloApplication class.

                //Read the high scores when you open the high score screen (Put this in the high score screen)


                Platform.runLater(() -> correctOrNotLabel.setText(""));
                Platform.runLater(() -> correctOrNotLabel.setTextFill(Color.WHITE));
                Platform.runLater(() -> loadQuestion(currentQuestion) );
                Platform.runLater(() -> currentQuestion++ );

            }else{
                CI = true;
            }
        }
        if (timerSeconds == 0) {
            timerMinutes--;
            timerSeconds = 59;
        } else {
            timerSeconds--;
        }

        // Update UI on the JavaFX Application Thread
        Platform.runLater(() -> timerLbl.setText(timerMinutes + ":" + String.format("%02d", timerSeconds)));
    }

    public void saveBtn() throws IOException {

        Gson gson = new GsonBuilder() .setPrettyPrinting() . create();
        try(FileWriter writer = new FileWriter("test.json")){
            gson. toJson(elements , writer);
            System.out.println("Saved!");
        } catch (IOException e) {
            e. printStackTrace() ;
        }
    }
    //mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/

    private void createQuizQuestions(int numQuestions) throws FileNotFoundException {
        loadElements();
        System.out.println(elements);
    }

    private void loadQuestion(int i) {

        // the element the question(should be random)
        Random rand = new Random();
        int qNum = rand.nextInt(elements.get(i).getQuestions().size());
        questionLbl.setText(elements.get(i).getQuestions().get(qNum).getQuestion());

        ArrayList<Object> option1 = new ArrayList<>();
        option1.add(aBtnID);
        option1.add(AnsOneLbl);
        ArrayList<Object> option2 = new ArrayList<>();
        option2.add(bBtnID);
        option2.add(AnsTwoLbl);
        ArrayList<Object> option3 = new ArrayList<>();
        option3.add(cBtnID);
        option3.add(AnsThreeLbl);
        //this is an arraylist to hold the labels.
        ArrayList<ArrayList> answerShuffle = new ArrayList<>();
        answerShuffle.add(option1);
        answerShuffle.add(option2);
        answerShuffle.add(option3);
        Collections.shuffle(answerShuffle); //this shuffles the labels into a random order.
        //https://www.geeksforgeeks.org/shuffle-elements-of-arraylist-in-java/

        //this sets the correct answer to the label of whichever is index 0 in the arraylist above.
        Label selectedLabelOne = (Label) answerShuffle.get(0).get(1);
        selectedLabelOne.setText(elements.get(i).getQuestions().get(qNum).correct_answers[0]);

        int picker = rand.nextInt(7);
        int pickerTwo = rand.nextInt(7);
        while(picker==pickerTwo){
            pickerTwo = rand.nextInt(7);
        }

        Label selectedLabelTwo = (Label) answerShuffle.get(1).get(1);
        selectedLabelTwo.setText(elements.get(i).getQuestions().get(qNum).incorrect_answers[picker]);

        Label selectedLabelThree = (Label) answerShuffle.get(2).get(1);
        selectedLabelThree.setText(elements.get(i).getQuestions().get(qNum).incorrect_answers[pickerTwo]);

        hintOneLbl.setText(elements.get(i).getQuestions().get(qNum).hints[0]);
        hintTwoLbl.setText(elements.get(i).getQuestions().get(qNum).hints[1]);

        //https://www.tutorialkart.com/javafx/create-new-button-and-set-action-listener-in-javafx/
        //How to add action to buttons

        Button correctButton = (Button) answerShuffle.get(0).get(0);
        correctButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Set the label text to "Correct Answer!"
                correctOrNotLabel.setText("Correct Answer!");
                // Set the label color to green
                correctOrNotLabel.setTextFill(Color.GREEN);
            }
        });
        //Correct Answer is always (Button) answerShuffle.get(0).get(0);
        //Correct answer is always (Label) answerShuffle.get(0).get(1);

        //Incorrect Answer is always (Button) answerShuffle.get(1).get(0);
        //incorrect answer is always (Label) answerShuffle.get(1).get(1);
        Button incorrectButtonOne = (Button) answerShuffle.get(1).get(0);
        incorrectButtonOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Set the label text to "Correct Answer!"
                correctOrNotLabel.setText("Incorrect Answer!");
                // Set the label color to green
                correctOrNotLabel.setTextFill(Color.RED);
            }
        });


        //incorrect Answer is always (Button) answerShuffle.get(2).get(0);
        //incorrect answer is always (Label) answerShuffle.get(2).get(1);
        Button incorrectButtonTwo = (Button) answerShuffle.get(2).get(0);
        incorrectButtonTwo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // Set the label text to "Correct Answer!"
                correctOrNotLabel.setText("Incorrect Answer!");
                // Set the label color to green
                correctOrNotLabel.setTextFill(Color.RED);
            }
        });



    }


    //mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
    private void loadElements() throws FileNotFoundException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("elements.json")) {
            Type listType = new TypeToken<ArrayList<Element>>(){}.getType();
            ArrayList<Element> imports = gson.fromJson(reader, listType);
            elements = FXCollections.observableArrayList(imports);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void aBtn(ActionEvent actionEvent) {
    }

    public void bBtn(ActionEvent actionEvent) {
    }

    public void cBtn(ActionEvent actionEvent) {
    }

    public void menuButtonAction(ActionEvent actionEvent) throws IOException {
        HelloApplication.setRoot("menu-view");
    }
}