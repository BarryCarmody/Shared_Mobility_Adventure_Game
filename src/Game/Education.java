package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Education {
    private List<Question> questions;
    private Random random;

    public Education() {
        random = new Random();
        questions = new ArrayList<>();
        loadQuestions(); // populate the questions list
    }

    private void loadQuestions() {
        // 20 questions about environmental impact of transportation
        questions.add(new Question("What transport method has the least environmental impact?",
                new String[]{"Car", "Bicycle", "Bus", "Train"}, 1));
        questions.add(new Question("Which is more eco-friendly, driving a car or riding a bus?",
                new String[]{"Driving a car", "Riding a bus", "Both equal", "Depends on the situation"}, 1));
        questions.add(new Question("Which transportation mode emits the least CO2 per passenger?",
                new String[]{"Private Car", "Motorbike", "Bus", "Train"}, 3));
        questions.add(new Question("What is the main benefit of using public transportation?",
                new String[]{"Faster travel", "Reduces traffic", "Lower emissions per person", "Cheaper fares"}, 2));
        questions.add(new Question("What factor most increases a vehicle's fuel consumption?",
                new String[]{"Frequent braking", "High speeds", "Regular maintenance", "Steady speeds"}, 1));
        questions.add(new Question("Which type of car is the most environmentally friendly?",
                new String[]{"Diesel Car", "Electric Car", "Gasoline Car", "Hybrid Car"}, 1));
        questions.add(new Question("What action can reduce your carbon footprint while driving?",
                new String[]{"Using air conditioning", "Car pooling", "Driving faster", "Using premium fuel"}, 1));
        questions.add(new Question("How does telecommuting reduce environmental impact?",
                new String[]{"Decreases office space usage", "Reduces electricity at work", "Lowers transport emissions", "Increases home energy use"}, 2));
        questions.add(new Question("What is a green way to increase car fuel efficiency?",
                new String[]{"Regular tire checks", "Keeping windows open", "Increasing load carried", "Frequent acceleration"}, 0));
        questions.add(new Question("Why are electric bikes considered eco-friendly?",
                new String[]{"They are fast", "They use electricity", "Minimal emissions", "Affordable transportation"}, 2));
        questions.add(new Question("Which activity contributes least to your carbon footprint?",
                new String[]{"Long-haul flights", "Driving to work", "Using public buses", "Walking"}, 3));
        questions.add(new Question("What is true about hybrid vehicles?",
                new String[]{"Emit more CO2", "Use only gasoline", "Cannot use electric charge", "Use fuel and electric power"}, 3));
        questions.add(new Question("Why is car sharing environmentally beneficial?",
                new String[]{"Reduces total vehicles on road", "Lowers individual costs", "Increases fuel use efficiency", "All of the above"}, 3));
        questions.add(new Question("What is the environmental impact of cycling?",
                new String[]{"Increases roadway use", "Produces CO2", "Zero emissions", "Reduces physical health"}, 2));
        questions.add(new Question("Which transportation change reduces your carbon footprint the most?",
                new String[]{"Switching to a smaller car", "Using public transportation", "Walking or biking", "Upgrading to a newer car"}, 2));
        questions.add(new Question("What is the environmental impact of high-speed trains?",
                new String[]{"Higher than airplanes", "Lower than buses", "Lower than cars", "About the same as buses"}, 2));
        questions.add(new Question("Which factor does not reduce the carbon footprint of commuting?",
                new String[]{"More frequent trips", "Using carpool lanes", "Riding in full buses", "Biking to work"}, 0));
        questions.add(new Question("How does ride-sharing contribute to environmental conservation?",
                new String[]{"Increases fuel consumption", "Decreases traffic congestion", "Increases individual trips", "Has no effect on environment"}, 1));
        questions.add(new Question("What environmental benefit does walking have?",
                new String[]{"Improves air quality", "Uses more energy", "Creates more paths", "None of the above"}, 0));
        questions.add(new Question("Why are scooters considered low impact on the environment?",
                new String[]{"High speeds reduce road time", "Low energy consumption", "No emissions when electric", "They use gasoline efficiently"}, 2));
    }

    public void presentQuestion() {
        int index = random.nextInt(questions.size());
        Question q = questions.get(index);

        // create JOptionPane with buttons
        String[] options = q.getChoices();
        int response = JOptionPane.showOptionDialog(null, q.getQuestion(), "Environmental Impact Question",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        handleResponse(response, q);
    }

    private void handleResponse(int response, Question question) {
        int correctAnswer = question.getCorrectAnswer();
        if (response == correctAnswer) {
            JOptionPane.showMessageDialog(null, "Correct! +100 Points", "Answer", JOptionPane.INFORMATION_MESSAGE);
            Score.incrementScore(100);
        } else {
            String correctAnswerText = question.getChoices()[correctAnswer];
            JOptionPane.showMessageDialog(null, "Wrong Answer! Correct was: " + (correctAnswer + 1) + ": " + correctAnswerText, "Answer", JOptionPane.ERROR_MESSAGE);
        }

    }

    static class Question {
        private String question;
        private String[] choices;
        private int correctAnswer;

        public Question(String question, String[] choices, int correctAnswer) {
            this.question = question;
            this.choices = choices;
            this.correctAnswer = correctAnswer; // index 0 for first answer
        }

        public String getQuestion() {
            return question;
        }

        public String[] getChoices() {
            return choices;
        }

        public int getCorrectAnswer() {
            return correctAnswer;
        }
    }

    public static void main(String[] args) {
        Education edu = new Education();
        edu.presentQuestion();
    }
}
