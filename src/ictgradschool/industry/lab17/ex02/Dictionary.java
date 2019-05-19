package ictgradschool.industry.lab17.ex02;

import java.util.Set;
import java.util.TreeSet;

/**
 * Represents a dictionary of words which will be considered "correct spelling".
 */
public class Dictionary implements IDictionary {
    private Set<String> dictionary;

    /**
     * Creates a new {@link Dictionary} by splitting the {@link IDictionary#WORDS} constant into individual words,
     * and adding each one to the {@link #dictionary} {@link Set}.
     */
    public Dictionary() {
        this.dictionary = new TreeSet<>();
        String[] splitWords = WORDS.toLowerCase().split(",");
        for (int i = 0; i < splitWords.length; i++) {
            dictionary.add(splitWords[i]);
        }
    }

    /**
     * Checks whether the spelling of the given word is correct. The spelling of a word is considered to be correct
     * if that word is contained within the {@link #dictionary} set (case insensitive).
     *
     * @param word the word to check
     * @return true if the spelling is correct, false otherwise.
     */
    @Override
    public boolean isSpellingCorrect(String word) {
        return dictionary.contains(word);
    }

}
