package ictgradschool.industry.lab17.ex02;

import ictgradschool.industry.lab17.ex01.Robot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * TODO Implement this class.
 */
public class TestDictionary {

    private Dictionary dictionary;


    @Before
    public void setUp() {
        dictionary = new Dictionary();
    }


    @Test
    public void testTrueIsTrue() {
        assertEquals(true, true);
    }

    @Test
    public void testSpellingCorrectCapital() {


        assertFalse(dictionary.isSpellingCorrect("WORLD"));
        assertFalse(dictionary.isSpellingCorrect("THEY"));


    }

    @Test
    public void testSpellingCorrectLowerCase(){
        assertTrue(dictionary.isSpellingCorrect("world"));
        assertTrue(dictionary.isSpellingCorrect("they"));
    }

    @Test
    public void testSpellingCorrectMixed(){
        assertFalse(dictionary.isSpellingCorrect("HeLLo"));
        assertFalse(dictionary.isSpellingCorrect("wORLd"));
    }



}


