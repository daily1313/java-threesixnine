package com.example;

import com.example.controller.GameController;
import com.example.view.InputView;
import com.example.view.OutputView;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new InputView(), new OutputView());
        gameController.start();
    }
}