package com.example.strategy;

public class MultipleClapStrategy implements GameStrategy {

    @Override
    public String getAnswer(int number) {
        String answer = String.valueOf(number);
        long count = countClapNumber(answer);

        if(containsClapNumber(count)) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < count; i++) {
                sb.append("clap");
            }

            return sb.toString();
        }

        return answer;
    }

    private long countClapNumber(String answer) {
        return answer.chars()
                .filter(c -> c == '3' || c == '6' || c == '9')
                .count();
    }

    private boolean containsClapNumber(long count) {
        return count > 0;
    }
}
