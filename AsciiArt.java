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
import java.util.Scanner;
/**
 * This class implement the game demonstrated in the log at the top of this write-up.
 * @author ante
 *
 */
public class AsciiArt {
  boolean over;//check if it is over
  public String command;// build string array
  Scanner scnr = new Scanner(System.in);// scan in
  Canvas canvas;// build canvas constructor
  /**
   * Constructor which generates a AsciiArt progression
   */
  public AsciiArt() {
    over = false;// initialize over
  }
  /**
   * Main method used to run the application and throw exception
   * @param args
   */
  public static void main(String[] args) {
    AsciiArt asciiart = new AsciiArt();// initialize AsciiArt asciiart
    asciiart.application(); // call the application method
  }
  public static void print() {
    System.out.println("[1] Create a new canvas");//prompt that create a new canvas
    System.out.println("[2] Draw a character");//prompt that draw a character
    System.out.println("[3] Undo drawing");//prompt that undo drawing
    System.out.println("[4] Redo drawing");//prompt that redo drawing
    System.out.println("[5] Show current canvas");//prompt that show current canvas
    System.out.println("[6] Show drawing history");//prompt that show drawing history
    System.out.println("[7] Exit");//prompt that show exit
    System.out.print("> ");
  }
  /**
   * This method is to create a new canvas
   */
  public void canvas() {
    try{System.out.print("Width> ");// print the prompt
    String w = scnr.nextLine();//scan in the width
    int width = Integer.parseInt(w);
    System.out.print("Height> ");// print the prompt
    String h = scnr.nextLine();
    int height = Integer.parseInt(h);// scan in the width
    try{canvas = new Canvas(width, height);// build the canvas here
    }catch(NullPointerException e) {// catch the nullpointerException
      System.out.println("Warning: "+e.getMessage());// output warning message
    }
    }
    catch(IllegalArgumentException e){// catch the illegalArgumentException
      System.out.println("Warning: "+e.getMessage()); // output warningmessage
    }
  }
  /**
   * This method is to draw a character on the canvas
   */
  public void character() {
    try{System.out.print("Row> ");// print the prompt
    String r = scnr.nextLine();//scan in the row
    int row = Integer.parseInt(r);
    System.out.print("Col> ");// print the prompt
    String c = scnr.nextLine();//scan in the column
    int col = Integer.parseInt(c);
    System.out.print("Character> ");// print the prompt
    //String[] C = scnr.nextLine().split(";");
    char Character = scnr.nextLine().charAt(0);// scan in the character
    try{canvas.draw(row, col, Character);// draw the character in the canvas
    }catch(NullPointerException e) {// catch the nullPointerException
      System.out.println("Warning: "+e.getMessage());
    }
    }catch(IllegalArgumentException e) {//catch the illegalArgument Exception
      System.out.println("Warning: "+e.getMessage());
    }
  }
  /**
   * This method is to undo drawing
   */
  public void undo() {
    try{canvas.undo();// undo the character in the canvas
    }catch(NullPointerException e) { // catch nullPointerException
      System.out.println("Warning: " + e.getMessage());
    }
  }
  /**
   * This method is to redo drawing
   */
  public void redo() {
    try{canvas.redo(); // undo the character in the canvas
    }catch(NullPointerException e) { // catch nullPointerException
      System.out.println("Warning: " + e.getMessage());
    }
  }
  /**
   * This method is to check if input the correct number first
   */
  public void prompt() {
    if(!command.equals("1")&&!command.equals("2")&&!command.equals("3")&&!command.equals("4")&&
        !command.equals("5")&&!command.equals("6")&&!command.equals("7")) {
      throw new IllegalArgumentException();// when it is not right, throw the illegalArgument Exception
    }
  }
  /**
   * This method is the driver loop used to 
   */
  public void application(){
    while(!over) {// run when over is true
      print();// print the prompt
      if(scnr.hasNextLine()) {
        command = scnr.nextLine();// scan in the command
      }
      try {
        prompt(); // check if input the correct number first
      }catch(IllegalArgumentException e) { // catch it when it is wrong
        System.out.println("Warning: wrong input!" );
      }
      if(command.equals("1")) {
        canvas();// when the command equal 1, call canvas method
      }
      else if(command.equals("2")) {
        character();// when the command equal 2, call character method
      }
      else if(command.equals("3")) {
        undo();// when the command equal 3, call undo method
      }
      else if(command.equals("4")) {
        redo();// when the command equal 4, call redo method
      } 
      else if(command.equals("5")) {
        try{canvas.printDrawing();// when the command equal 5, call printDrawing method
        }catch(NullPointerException e) {//catch it when it is wrong
          System.out.println("Warning: " + e.getMessage());
        }
      }
      else if(command.equals("6")) {
        try{canvas.printHistory(); // when the command equal 6, call printHistory method
        }catch(NullPointerException e) {// catch it when it is wrong
          System.out.println("Warning: " + e.getMessage());
        }
      }
      else if(command.equals("7")) {
        System.out.println("Bye!");// when the command equal 7, say Bye
      }
    } 
  }
}
