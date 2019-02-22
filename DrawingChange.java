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
/**
 * This class records the details of a single change made to your canvas.
 * @author ante
 *
 */
public class DrawingChange {
  public final int x; // x coordinate for a change
  public final int y; // y coordinate for a change
  public final char prevChar; // previous character in the (x,y)
  public final char newChar; // new character in the (x,y)
  /**
   * Constructor which generates a DrawingChange progression
   * @param x
   * @param y
   * @param prevChar
   * @param newChar
   */
  public DrawingChange(int x, int y, char prevChar, char newChar) {
    this.x = x;//initialize x
    this.y = y;//initialize y
    this.prevChar = prevChar;//initialize prevChar
    this.newChar = newChar;//initialize newChar
  }
}
