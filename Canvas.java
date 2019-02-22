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
import java.util.Arrays;
import java.util.Iterator;
/**
 * This class representing an ASCII-art image.
 * @author ante
 *
 */
public class Canvas {
  private final int width; // width of the canvas
  private final int height; // height of the canvas

  private char[][] drawingArray; // 2D character array to store the drawing

  private final DrawingStack undoStack; // store previous changes for undo
  private final DrawingStack redoStack; // store undone changes for redo
  /**
   * Constructor which generates a Canvas progression
   * @param width
   * @param height
   * @throws IllegalArgumentException
   */
  public Canvas(int width, int height) throws IllegalArgumentException{
    this.width = width;//initialize width
    if (this.width <= 0)// when width less than zero, throw exception
      throw new IllegalArgumentException("Warning: width <= zero");
    this.height = height;//initialize height
    if (this.height <= 0)// when height less than zero, throw exception
      throw new IllegalArgumentException("Warning: height <= zero");
    drawingArray = new char[height][width]; //initialize drawingArray
    for(int i = 0; i < drawingArray.length; i++) {
      for(int j = 0; j < drawingArray[0].length; j++) {
        this.drawingArray[i][j] = ' ';// A Canvas is initially blank
        //(use the space ' ' character)
      }
    }
    undoStack = new DrawingStack();// initialize undoStack
    redoStack = new DrawingStack(); //initialize redoStack
  }  
  /**
   * This method draw a character at the given position
   * @param row
   * @param col
   * @param c
   */
  public void draw(int row, int col, char c) throws IllegalArgumentException{
    if (row >= this.height || col >= this.width || row < 0 || col < 0)
      throw new IllegalArgumentException("Warning: drawing position outside the canvas");
    // This method should throw an IllegalArgumentException if the drawing position is outside the canvas
    char prev = this.drawingArray[row][col]; // If that position is already
    //marked with a different character, overwrite it.
    this.drawingArray[row][col] = c;// Draw a character at the given position
    undoStack.push(new DrawingChange(row, col, prev, c)); // After making a new change,
    //add a matching DrawingChange to the undoStack so that we can undo if needed.
    while(!redoStack.isEmpty())
      redoStack.pop();// After making a new change, the redoStack should be empty
  }      
  /**
   * This method undo the most recent drawing 
   * @return true if undo the most recent drawing change successful
   */
  public boolean undo() {
    if(undoStack.peek()!= null) { // call peek method and check if it is empty
      DrawingChange undo = undoStack.pop(); //call pop method to construct the undo  
      this.redoStack.push(new DrawingChange(undo.x,undo.y,drawingArray[undo.x][undo.y],undo.prevChar));
      // An undone DrawingChange should be added to the redoStack so that we can redo if needed.
      this.drawingArray[undo.x][undo.y] = undo.prevChar; // Undo the most recent drawing change
      return true;                                       //  Return true if it is successful. False otherwise. 
    }
    return false;
  } 

  /**
   * THis method redo the most recent undone drawing change
   * @return true if redo the most recent undone drawing change
   */
  public boolean redo() {
    if(redoStack.peek()!= null) {// call peek method and check if it is empty
      DrawingChange redo = redoStack.pop();// call pop method to construct the redo  
      this.undoStack.push(new DrawingChange(redo.x,redo.y,drawingArray[redo.x][redo.y],redo.prevChar));
      // A redone DrawingChange should be added (back) to the undoStack so that we can undo again if needed.
      this.drawingArray[redo.x][redo.y] = redo.prevChar;// Redo the most recent undone drawing change
      return true;                                      // Return true if it is successful. False otherwise.
    }
    return false;
  } 

  /**
   * This method print version of the canvas
   * @return a printable string version of the Canvas.
   */
  public String toString() {
    String lineSeparator = System.lineSeparator();//input the lineSeparator
    StringBuilder sb = new StringBuilder();// build StringBuilder sb
    for (char[] row : drawingArray) {// for loop to run each row
      sb.append(Arrays.toString(row).replace(", ", "").replace("[", "").replace("]", ""))
      .append(lineSeparator);// use append method to add elements needed to each row
    }
    String result = sb.toString();// string it
    return result;
  } 
  /**
   * This method prints the Canvas’s string representation to System.out.
   */
  public void printDrawing() {
    System.out.println(this.toString());// print toString method out
  }
  /**
   * This method prints a record of the changes that are stored on the undoStack
   */
  public void printHistory() {
    Iterator<DrawingChange> iterator =this.undoStack.iterator();// iterator the undoStack
    while(iterator.hasNext()) {// check if it is null
      DrawingChange print = iterator.next(); // get the next node in the stack
      int count = this.undoStack.size(); // get the number of which store in undoStack
      System.out.println(count + ". draw\'" + print.newChar + "\' on (" + print.x + "," + print.y + ")");
    }
  }
}
