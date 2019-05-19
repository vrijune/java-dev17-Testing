package ictgradschool.industry.lab17.ex02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Allows users to check their spelling against a {@link IDictionary}.
 */
public class SimpleSpellChecker {

    /** Maps individual words in the user's submitted text to the number of times each of those words appears. */
    private Map<String, Integer> userWords;

    /** A dictionary of correct spelling. */
    private IDictionary dictionary;

    /**
     * Creates a new {@link SimpleSpellChecker}.
     *
     * @param dictionary a {@link IDictionary} of correct words.
     * @param wordsToCheck a list of words to check. Each word is separated by whitespace.
     * @throws InvalidDataFormatException if the text is null.
     */
    public SimpleSpellChecker(IDictionary dictionary, String wordsToCheck) throws InvalidDataFormatException {
        this.userWords = new HashMap<>();
        this.dictionary = dictionary;

        processWordsToCheck(wordsToCheck);
    }

    /**
     * Splits the given text into individual words (separated by whitespace), and places them into the
     * {@link #userWords} map, with the words themselves as the key, and the number of times each word appears in the
     * given text as the value. This method is case sensitive - BOB is different to Bob.
     *
     * @param wordsToCheck the user's text.
     * @throws InvalidDataFormatException if the text is null.
     */
    private void processWordsToCheck(String wordsToCheck) throws InvalidDataFormatException {
        checkStringNotNull(wordsToCheck);
        String[] words = wordsToCheck.split("[\\s\\W]+");
        for (int i = 0; i < words.length; i++) {
            Integer freq = userWords.get(words[i]);
            userWords.put(words[i].toLowerCase(), (freq == null) ? 1 : freq + 1);
        }
    }

    /**
     * Checks if the given string is null. Throws an exception if it is.
     *
     * @param wordsToCheck the String to check.
     * @throws InvalidDataFormatException if the String is null.
     */
    private void checkStringNotNull(String wordsToCheck) throws InvalidDataFormatException {
        if (wordsToCheck == null) {
            throw new InvalidDataFormatException("Words to check should not be null");
        }
    }

    /**
     * Gets a {@link List} of all words in the user's entered text that are considered misspelled, in alphabetical order.
     *
     * <p>A word is considered misspelled if it is not contained within the {@link #dictionary}. However, a word
     * is never considered misspelled if it begins with a numeric character (i.e. 0 - 9).</p>
     *
     * @return a {@link List} containing all keys in {@link #userWords} which are considered misspelled.
     */
    public List<String> getMisspelledWords() {
        List<String> misspelled = new ArrayList<>();
        for (Map.Entry<String, Integer> word : userWords.entrySet()) {
            String key = word.getKey();
            // if the word is begins with a number, we don't include it in the misspelled list.
            if (!dictionary.isSpellingCorrect(key)) {
                misspelled.add(key);
            }
        }

        return misspelled;
    }

    /**
     * Gets a {@link List} of all unique words in the user's text, in alphabetical order.
     *
     * <p>For example, if the user's text is "hello goodbye hello good morning", the resultant {@link List} will
     * contain, in this order:</p>
     * <ol>
     *     <li>good</li>
     *     <li>goodbye</li>
     *     <li>hello</li>
     *     <li>morning</li>
     * </ol>
     *
     * @return a {@link List} of all unique words in the user's text, in alphabetical order.
     */
    public List<String> getUniqueWords() {
        List<String> uniqueWords = new ArrayList<>();
        uniqueWords.addAll(userWords.keySet());
        return uniqueWords;
    }

    /**
     * Gets the number of times the given word appears in the user's original text (case insensitive).
     *
     * @param word the word to check.
     * @return the value of the {@link #userWords} map, when provided the given word in lowercase as a key.
     * @throws InvalidDataFormatException if the given word is null.
     */
    public int getFrequencyOfWord(String word) throws InvalidDataFormatException {
        Integer frequency = userWords.get(word.toLowerCase());
        return (frequency == null) ? 0 : frequency;
    }
}
