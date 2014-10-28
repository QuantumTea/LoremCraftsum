package io.fictional;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> words = LoadWords();
        if (words != null) {
            LoremIpsum ipsum = new LoremIpsum(words);
            ipsum.writeLoremParagraph(ipsum.getSentences(20));
            ipsum.writeLoremParagraph(ipsum.getSentences(20));
            ipsum.writeLoremParagraph(ipsum.getSentences(20));
            ipsum.writeLoremParagraph(ipsum.getSentences(20));
            ipsum.writeLoremParagraph(ipsum.getSentences(20));
            ipsum.writeLoremParagraph(ipsum.getSentences(20));
        }
    }

    private static List<String> LoadWords() {
        try {
            List<String> wordList = FileUtils.readLines(new File("craft.txt"));
            List<String> fillerWords = FileUtils.readLines(new File("filler.txt"));
            wordList.addAll(fillerWords);
            return wordList;
        } catch (IOException ioe) {
            System.out.println("IOException, log file not written");
            ioe.printStackTrace();
            return null;
        }
    }
}
