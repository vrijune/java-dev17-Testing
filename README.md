Industry Lab 17:Testing
==========
## Before you start
There are several examples of existing unit tests (in the `test` folder) within the exercises which you can examine for syntax / inspiration.

## Exercise One: Completing the Robot Tests
This exercise involves writing simple unit tests for the Robot program discussed in the lecture. You need to complete the **RobotTest** class to test the following methods of the Robot class:

`public void turn()`

- Write unit tests to check that the robot is facing the right direction after each turn. You also need to make sure that the robot hasn’t moved, but it has changed its direction by 90 degrees to the right.

`public void move() throws IllegalMoveException`

- Write unit tests to test for a valid move in each direction the robot is facing.
- Write unit tests to test for an invalid move (i.e. moving outside of the grid) in each direction the robot is facing.

`Other public methods in the Robot class`

- Write unit tests for any other public methods in the Robot class.

### Hints
There will be **four** test cases for the method turn and **eight** test cases for the method move.

For each method you’re testing, do some brainstorming / write down in plain English what you want to test. This will help you plan your unit tests.

## Exercise Two: Evaluation of Expressions
For this exercise, you’ll write unit tests for the **Dictionary** and **SimpleSpellChecker** classes, which you may remember from your Java test. This time you’ll develop all the tests yourself. Add your unit tests to the **TestDictionary** and **TestSimpleSpellChecker** classes.

### Hints
Remember to test each public method. And, for each method, you may need more than one test. For example, what happens when **isSpellingCorrect** is called when a word is in the dictionary? What happens when it’s not? You need to test each case.

For a reminder of the required functionality of each method, check the method comments.
A good metric to use to decide if you’ve written enough tests is to ask yourself, “has every line of code in the tested method / class been called at least once with the tests I have?”. This is known as *test coverage*.

### Questions

1. How would you make sure you’ve tested the program thoroughly?
2. Did you find any errors in the tested code? If so, what were they?

## Exercise Three: Testing Bounce
In this exercise we’ll be writing unit tests for some of the various shapes that we’ve created over the course of the PGCert. Specifically, we’ll be writing unit tests for **OvalShape**, **GemShape**, and **DynamicRectangleShape**.

If you look at the `ex03` package in the `test` folder, you’ll notice that tests for **RectangleShape** and **NestingShape** have already provided. Read through these first to gain an understanding of how different subclasses of Shape might be tested – in particular, take note of how the **MockPainter** is being used.

### Hints
Recall that **RectangleShape** – including its move method – has already been tested. When writing tests for other shapes, consider whether a particular test will “add” anything useful to your test suite. For example, you may not need to use many different combinations of positions and velocities to test whether **OvalShape’s move** method works correctly, since it is exactly the same method as **RectangleShape’s** (both inherit Shape’s move method without making any changes).

When developing tests for **GemShape**, recall that there are two different “sizes” of gems – a “small” version which draws a four-sided polygon, and a “regular” version which draws a six-sided polygon. You must consider both of these cases function as intended.

When developing tests for **DynamicRectangleShape**, there are many different possibilities as it moves that determine whether or not it should be drawn “empty” or “filled”. To get you started, ask yourself what happens when a **DynamicRectangleShape**:

- Bounces off the left wall when not currently filled?
- Bounces off the left wall when it *is* currently filled?
- Bounces off the top wall when not currently filled?
- Bounces off the top wall when it *is* currently filled?
- Bouncess off the top-left corner?
- Etc…

### For extra reading (not examinable) …
The **MockPainter** class is an example of *mocking*, which is a testing technique designed to more easily isolate the code under test, and focus on ensuring it works correctly without worrying about extra details (in this case, examples would include reliance on the Swing framework, the need to deal with **Graphics** objects, etc).

Mocking is such a widely-used testing technique that several frameworks have been designed which extend JUnit to allow testers to write mock classes much more easily (i.e. without manually creating an entire implementation of the **Painter** interface). Examples of such frameworks include [JMockit](http://jmockit.org/) and [EasyMock](http://easymock.org/).

Examine the websites for those frameworks, and feel free to try and use one of them in your future testing endeavours. As good practice, you could try removing the **MockPainter** class from your Bounce tests, and try to use one of these frameworks instead.

## Exercise Four: Test-Driven Development
This exercise involves developing a simple shape area calculator using the TDD approach. You need to develop a program that asks users to enter the dimensions of a rectangle. The program calculates the area for the rectangle, and rounds the area to whole number. The program also generates the radius of a circle, displays the radius, and calculates its area. Then, it displays the smaller area of the two shapes.

Here is an example output of the program:

```text
Welcome to Shape Area Calculator!
 
Enter the width of the rectangle: 20.5
Enter the length of the rectangle: 18.5
 
The radius of the circle is: 20
 
The smaller area is: 379
```

The program is to be written so that each task is in a separate method. Your program should be able to do at least of the following tasks:

1. Converting a **String** to a **double**, and then returning the converted value.

2. Calculating the area of the rectangle with given dimensions, and then returning the area (the data type of area is double). The formula for the area of a rectangle is:

```
    A = wl
```
  Where *w* is the width and *l* is the length of the rectangle.

3. Calculating the area of a circle with given radius, and then returning the area. The formula for the area of a circle is:

```
    A =πr2
```
  Where *r* is the radius of the circle.

4. Rounding the area of each shape to the nearest whole number, and then returning the area as an **int**, with the area as the method parameter.

5. Determining the smaller area of the two shapes, with the two areas as the method parameters.

### Notes
When developing your program, you **always** write the unit tests for each public method that is to be implemented. An example of the TDD process that you may follow is:

1. Understand the requirements of the method that you are going to implement
2. Create a test for the method as if the code already existed. Create the minimal code so that your program compiles. Run the test and it should fail.
3. Write the code to make the test pass.
4. Run all tests to make sure that you haven’t broken other parts of your program.

Your unit tests should also cover any `exceptional` cases – for example, when a **String** cannot be converted a **double**.

