package com.example.strategy;

public class MultipleClapStrategy implements GameStrategy {

    @Override
    public String getAnswer(int number) {
        String answer = String.valueOf(number);
        long count = count369(answer);

        if(has369(count)) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < count; i++) {
                sb.append("clap");
            }

            return sb.toString();
        }

        return answer;
    }

    private long count369(String answer) {
        return answer.chars()
                .filter(c -> c == '3' || c == '6' || c == '9')
                .count();
    }

    private boolean has369(long count) {
        return count > 0;
    }
}
