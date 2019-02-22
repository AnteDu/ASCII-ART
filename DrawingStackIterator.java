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
/**
 * This class directly iterator over stack.
 * This class implements the Iterator<DrawingChange> interface
 * @author ante
 *
 */
public class DrawingStackIterator implements Iterator <DrawingChange> {
  Node<DrawingChange>nextNode;//build a DrawingChange type Node
  /**
   * This constructor take a Node<DrawingChange> as a parameter and generate a iterator progression 
   * @param nextNode
   */
  public DrawingStackIterator(Node<DrawingChange>nextNode){
    this.nextNode = nextNode; // initialize nextNode
  }
  /**
   * This method return nextNode when it is not empty
   * @return nextNode
   */
  @Override
  public boolean hasNext() {
    return nextNode != null;// when nextNode is not empty, return it
  }
  /**
   * This method return the data of current Node, then to the next node
   * @return data
   */
  @Override
  public DrawingChange next() {
    DrawingChange data = nextNode.getData(); // get data from the Node
    nextNode = nextNode.getNext(); // get to the next Node
    return data;
  }
}
