package com.example.strategy;

public class SingleClapStrategy implements GameStrategy {

    @Override
    public String getAnswer(int number) {
        String answer = String.valueOf(number);

        if(containsClapNumber(answer)) return "clap";
        return answer;
    }

    private boolean containsClapNumber(String answer) {
        return answer.chars()
                .anyMatch(c -> c == '3' || c == '6' || c == '9');
    }
}


