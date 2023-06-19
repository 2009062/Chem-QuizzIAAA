package com.example.internalassesmentchemquzier;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class MenuController {


    public Button dySt;

    public void startButtonAction(ActionEvent actionEvent) throws IOException {
        HelloApplication.setRoot("game-view");
    }
    public void highScoreButtonAction(ActionEvent actionEvent) throws IOException {
        HelloApplication.setRoot("highScore-view");
    }

    public void difficultyButtonAction(ActionEvent actionEvent) throws IOException {
        HelloApplication.setRoot("difficulty-View");
    }



}