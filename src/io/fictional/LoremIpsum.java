package io.fictional;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class LoremIpsum implements OutputStrategy {
    private static final String pathToDesktop = System.getProperty("user.home")
            + System.getProperty("file.separator") + "Desktop"
            + System.getProperty("file.separator") + "Lorems.txt";

    private final List<String> wordList;

    public LoremIpsum(List<String> words) {
        this.wordList = words;
    }

    public String getSentences(int numberOfSentences) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numberOfSentences - 1; i++) {
            int sentenceLength = ((int) ((GetRandomNumber() * 10) + 3));
            sb.append(createOneSentence(sentenceLength));
        }

        return sb.toString();
    }

    private String createOneSentence(int sentenceLength) {
        StringBuilder sb = new StringBuilder();
        int numberOfWords = wordList.size() - 1;
        for (int i = 0; i < sentenceLength; i++) {
            int nextWordFromList = (int) (numberOfWords * GetRandomNumber());
            sb.append(wordList.get(nextWordFromList));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(". ");
        return sb.substring(0, 1).toUpperCase() + sb.substring(1);
    }

    private double GetRandomNumber() {
        // Returns a number between 0.0 and 0.1
        return Math.random();
    }

    public void writeLoremParagraph(String message) {
        try {
            // true to append, false to write a new file
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(pathToDesktop, true)));
            printWriter.println(message);
            printWriter.println("-------------------------------------------");
            printWriter.close();
        } catch (IOException ioe) {
            System.out.println("IOException, log file not written");
            ioe.printStackTrace();
        }
    }
}
