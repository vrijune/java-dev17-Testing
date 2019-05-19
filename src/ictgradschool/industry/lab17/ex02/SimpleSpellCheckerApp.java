package ictgradschool.industry.lab17.ex02;

import ictgradschool.Keyboard;

import java.util.Arrays;
import java.util.List;

public class SimpleSpellCheckerApp {

    public static void main(String[] args) throws InvalidDataFormatException {

        System.out.println("Welcome to Simple Spell Checker");
        System.out.println("================================");
        System.out.print("Please enter the text you like to check: ");

        String userInput = Keyboard.readInput();
        SimpleSpellChecker sp = new SimpleSpellChecker(new Dictionary(), userInput);

        System.out.println("--------------------------------");

        System.out.print("Please enter a word you like: ");
        userInput = Keyboard.readInput();

        System.out.println("--------------------------------");
        System.out.println("Spell Checker Summary");
        System.out.println("--------------------------------");

        System.out.println("The misspelled words from the text are: ");
        System.out.println(Arrays.toString(sp.getMisspelledWords().toArray()));
        System.out.println("--------------------------------");
        System.out.println("The unique words are: ");
        List<String> uniqueWords = sp.getUniqueWords();
        for (String word : uniqueWords) {
            System.out.println(word);
        }
        System.out.println("--------------------------------");

        try {
            System.out.println("The frequency for the word \"" + userInput + "\" to occur in the given text is: " + sp.getFrequencyOfWord(userInput));
        } catch (InvalidDataFormatException e) {
            System.out.println("Cannot find the frequency for the word \"" + userInput + "\"");
        }
    }

}
