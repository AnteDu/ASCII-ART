//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           ASCII ART
// Files:           DrawingStack, DrawingStackIterator, DrawingChange, Canvas, AsciiArt, AsciiTest
// Course:          300, fall, 2018
//
// Author:          Ante Du
// Email:           adu3@wisc.edu
// Lecturer's Name: Gary
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         None
// Online Sources:  None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.Iterator;
import java.util.Stack;
/**
 * This class used to test canvas
 * @author ante
 *
 */
public class AsciiTest {
  /**
   * This method tests if a DrawingStack can be pushed to a DrawingStack, and peek from a
   * DrawingStack
   * 
   * @param true if all methods works properly
   */
  public static boolean testStackPushPeek() {
    DrawingStack stack = new DrawingStack();// create a new drawing stack
    DrawingChange first = new DrawingChange(0, 0, 'a', 'a');// create a new DrawingChange

    stack.push(first);// push the first DrawingChange node
    if (stack.peek() != first) {
      System.out.println("Failed: testStackPushPeek() did not pass!!!");
      return false;
    }
    return true;
  }
  /**
   * This method tests if a DrawingStack can be pushed to a DrawingStack, and pop from a
   * DrawingStack
   * 
   * @param true if all methods works properly
   */
  public static boolean testStackPushPop() {
    DrawingStack stack = new DrawingStack();// create a new drawing stack
    DrawingChange first = new DrawingChange(0, 0, 'a', 'a');// create a new DrawingChange
    DrawingChange second = new DrawingChange(1, 1, 'a', 'b');// create a new DrawingChange
    stack.push(first);// push the first DrawingChange node
    stack.push(second);// push the second DrawingChange node
    if (stack.pop() != second) {
      System.out.println("Failed: stack.pop() != second did not pass!!!");
      return false;
    }
    if (stack.pop() != first) {
      System.out.println("Failed: stack.pop() != first did not pass!!!");
      return false;
    }
    if (!stack.isEmpty()) {
      System.out.println("Failed: !stack.isEmpty() did not pass!!!");
      return false;
    }
    if (stack.size() != 0) {
      System.out.println("Failed: stack.size() != 0 did not pass!!!");
      return false;
    }
    return true;
  }

  public static boolean testIterator() {
    DrawingChange[] iterOutput = new DrawingChange[2];// create a new drawing stack
    DrawingStack stack = new DrawingStack();// create a new draw stack
    DrawingChange first = new DrawingChange(0, 0, 'a', 'a');// create a new DrawingChange
    DrawingChange second = new DrawingChange(1, 1, 'a', 'b');// create a new DrawingChange
    stack.push(first);// push the first DrawingChange node
    stack.push(second);// push the second DrawingChange node
    int count = 0;
    Iterator<DrawingChange>iterator = stack.iterator();
    while (iterator.hasNext()) {
      iterOutput[count] = iterator.next();
      count++;
    }
    boolean success = ((count == 2) && (iterOutput[0] == second) && (iterOutput[1] == first));

    if (!success) {
      System.out.println("Failed: testIterator() did not pass!!!");
      return false;
    }
    return true;
  }

  /**
   * This test tests if testStackPushPeek and testStackPushPop works properly
   * 
   * @param true if all methods works properly
   */
  public static boolean runStackTestSuite() {
    int pass = 3;// number of passes
    if (!testStackPushPeek()) {// test the first test
      pass--;
    }
    if (!testStackPushPop()) {// test the second test
      pass--;
    }
    if (!testIterator()) {// test the third test
      pass--;
    }
    if (pass != 3) {// check if all tests passed
      System.out.println("Failed: SOME tests did not pass!!!");
      return false;
    } else {
      System.out.println("ALL Tests passed!!!");
      return true;
    }
  }

  /**
   * This is the main method of the test
   * 
   * @param args
   */
  public static void main(String[] args) {
    int pass = 3;// number of passes
    if (!testStackPushPeek()) {// test the first test
      System.out.println("Failed: testStackPushPeek()!!!");
      pass--;
    }
    if (!testStackPushPop()) {// test the second test
      System.out.println("Failed: testStackPushPop()!!!");
      pass--;
    }
    if (!runStackTestSuite()) {// test the third test
      System.out.println("Failed: runStackTestSuite()!!!");
      pass--;
    }
    if (pass != 3) {// check if all tests passed
      System.out.println("Failed: SOME tests did not pass!!!");
    } else {
      System.out.println("ALL Tests passed!!!");
    }
  }
}

