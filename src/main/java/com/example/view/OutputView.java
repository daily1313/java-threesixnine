package com.example.view;

import com.example.model.Player;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String END_MESSAGE = "게임이 종료되었습니다.";
    private static final String LOSER = "패자: ";
    private static final String WINNER = "승자: ";
    private static final String COLON = " : ";

    public void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

    public void printLoser(String playerName) {
        System.out.println(LOSER + playerName);
    }

    public void printResult(List<Player> players) {
        printEndMessage();

        List<Player> results = players.stream()
                .sorted(Comparator.comparingInt(Player::getCount).reversed())
                .toList();

        results.forEach(player -> {
            System.out.println(player.getName() + COLON + player.getCount());
        });
    }
}
