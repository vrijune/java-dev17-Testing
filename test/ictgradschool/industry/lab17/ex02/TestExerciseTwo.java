package ictgradschool.industry.lab17.ex02;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * This shows off the {@link RunWith} and {@link Suite.SuiteClasses} annotations which can be used to
 * run multiple test files in one.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        Dictionary.class,
        SimpleSpellChecker.class
})
public class TestExerciseTwo {
}
