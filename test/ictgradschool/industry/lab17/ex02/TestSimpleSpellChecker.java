package ictgradschool.industry.lab17.ex02;

import ictgradschool.industry.lab17.ex01.IllegalMoveException;
import ictgradschool.industry.lab17.ex01.Robot;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * TODO Implement this class.
 */
public class TestSimpleSpellChecker
{
    private Dictionary dictionary;

    @Before
    public void setUp() throws InvalidDataFormatException {
//        try {
//            simpleSpellChecker = new SimpleSpellChecker(dictionary, userWords);
//        } catch (InvalidDataFormatException e) {
//            e.printStackTrace();
//        }
//
        this.dictionary = new Dictionary();
    }


    @Test
    public void testFoundationsOfMathematics() {
        assertEquals(2, 1 + 1);
    }


//    @Test
//    public void TestProcessWordsToCheck() {
//        boolean isProcessWord;
//
//        try {
//            for (int i = 0; i < word.length(); i++) {
//
//                simpleSpellChecker.getMisspelledWords();
//
//                isProcessWord = simpleSpellChecker.getMisspelledWords().equals("Helo");
//                assertTrue(isProcessWord);}
//            }catch(InvalidDataFormatException e){
//                fail();
//            }
//
//            try {
//                simpleSpellChecker.getMisspelledWords();
//            } catch (InvalidDataFormatException e) {
//                assertEquals("Helo", simpleSpellChecker.getMisspelledWords());
//                fail();
//            }
//
//
//        }
//
//
//
//
//
//    @Test
//    public void TestStringNotNull() {
//        boolean isNull;
//        try {
//            for (int i = 0; i < word.length(); i++) {
//
//            }
//        }
//
//    }


    @Test
    public void TestGetMisspelledWord() throws InvalidDataFormatException {
        SimpleSpellChecker checker = new SimpleSpellChecker(dictionary, "cok cook burn");
        assertEquals("[cok]",checker.getMisspelledWords().toString());




    }

    @Test
    public void TestGetUniqueWord() throws InvalidDataFormatException {
        ArrayList<String> expect = new ArrayList<>();
        expect.add("burn");
        expect.add("cook");

        SimpleSpellChecker checker= new SimpleSpellChecker(dictionary,"cook cook burn");
        assertEquals(expect, checker.getUniqueWords());


    }

    @Test
    public void TestWordFrequencies() throws InvalidDataFormatException
    {
        SimpleSpellChecker checker = new SimpleSpellChecker(dictionary, "hello world hello");
        assertEquals(2, checker.getFrequencyOfWord("hello"));
        assertEquals(1, checker.getFrequencyOfWord("world"));
    }


}
