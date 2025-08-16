package com.example.strategy;

import com.example.model.Player;
import com.example.view.InputView;
import com.example.view.OutputView;

import java.util.List;

public class GameContext {

    private final GameStrategy gameStrategy;
    private final InputView inputView;
    private final OutputView outputView;

    public GameContext(GameStrategy gameStrategy, InputView inputView, OutputView outputView) {
        this.gameStrategy = gameStrategy;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void execute(List<Player> players) {
        int number = 1;

        while(true) {
            for (Player player : players) {
                String answer = gameStrategy.getAnswer(number);
                String input = inputView.inputNumberByPlayer(player.getName());

                if(!answer.equals(input)) {
                    outputView.printResult(players);
                    outputView.printLoser(player.getName());
                    return;
                }

                player.incrementPlayCount();
                number++;
            }
        }
    }
}
