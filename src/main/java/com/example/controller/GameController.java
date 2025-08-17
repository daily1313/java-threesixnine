package com.example.controller;

import com.example.model.vo.Name;
import com.example.model.Player;
import com.example.strategy.GameStrategy;
import com.example.strategy.MultipleClapStrategy;
import com.example.strategy.SingleClapStrategy;
import com.example.util.GameOptionValidator;
import com.example.util.NameParser;
import com.example.util.NameValidator;
import com.example.view.InputView;
import com.example.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        int number = 1;
        int option = getGameOption();
        List<String> playerNames = getPlayerNames();
        List<Player> players = getPlayers(playerNames);
        GameStrategy gameStrategy = getGameStrategy(option);

        while (true) {
            for (Player player : players) {
                String answer = gameStrategy.getAnswer(number);
                String input = inputView.inputNumberByPlayer(player.getName());

                if (!answer.equals(input)) {
                    outputView.printResult(players);
                    outputView.printLoser(player.getName());
                    return;
                }

                player.incrementPlayCount();
                number++;
            }
        }
    }

    private int getGameOption() {
        int option = inputView.inputGameOption();
        GameOptionValidator.validateGameOption(option);
        return option;
    }

    private List<String> getPlayerNames() {
        String inputPlayerNames = inputView.inputPlayerNamesSeperatedByComma();
        NameValidator.validateInput(inputPlayerNames);

        List<String> playerNames = NameParser.parseInputToPlayerNames(inputPlayerNames);
        NameValidator.validateNameSize(playerNames);
        NameValidator.validateDuplicatedPlayerNames(playerNames);

        return playerNames;
    }

    private List<Player> getPlayers(List<String> playerNames) {
        return playerNames.stream()
                .map(name -> Player.from(Name.from(name)))
                .toList();
    }

    private GameStrategy getGameStrategy(int option) {
        if(option == 1) {
            return new SingleClapStrategy();
        }

        return new MultipleClapStrategy();
    }
}
