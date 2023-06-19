package com.example.internalassesmentchemquzier;

import java.util.Arrays;

public class Question {
    String question;
    String correct_answers[] = new String[6];
    String incorrect_answers[] = new String[6];
    String hints[] = new String[2];

    public Question(String question, String[] correct_answers, String[] incorrect_answers, String[] hints) {
        this.question = question;
        this.correct_answers = correct_answers;
        this.incorrect_answers = incorrect_answers;
        this.hints = hints;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getCorrect_answers() {
        return correct_answers;
    }

    public void setCorrect_answers(String[] correct_answers) {
        this.correct_answers = correct_answers;
    }

    public String[] getIncorrect_answers() {
        return incorrect_answers;
    }

    public void setIncorrect_answers(String[] incorrect_answers) {
        this.incorrect_answers = incorrect_answers;
    }

    public String[] getHints() {
        return hints;
    }

    public void setHints(String[] hints) {
        this.hints = hints;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", correct_answers=" + Arrays.toString(correct_answers) +
                ", incorrect_answers=" + Arrays.toString(incorrect_answers) +
                ", hints=" + Arrays.toString(hints) +
                '}';
    }
}


