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
 * This class use Node class to implement a stack using a chain-of-linked-nodes approach
 * This class implements the StackADT<DrawingChange> interface
 * @author ante
 *
 */
public class DrawingStack implements StackADT<DrawingChange> {
  private Node<DrawingChange> topNode;//new reference to the class Node
  private int size;//this is the size of topNode
  /**
   * Constructor which generates a DrawingStack progression
   */
  public DrawingStack() {
    topNode = null;// initialize the node 
    size = 0;// initialize the size 
  }
  /**
   * This method inserts an element at the top of the stack
   * @param element
   * @throws IllegalArgumentException
   */
  @Override
  public void push(DrawingChange element) throws IllegalArgumentException {
    Node<DrawingChange> newNode = new Node<DrawingChange>(element,topNode);//construct the new 
    //DrawingChange Type Node
    topNode = newNode; // give value to topNode
    size ++;// calculate size
  }
  /**
   * This method removes and returns the element from the top of the stack
   * @return the element removed from the stack top
   */
  @Override
  public DrawingChange pop() {
    DrawingChange top = peek();// call peek method
    if(topNode != null)// when it not null
      topNode = topNode.getNext();// get the next Node 
    size --;//calculate size
    return top;
  }
  /**
   * This method returns without removing the element at the top of the stack
   * @return the element on the stack top
   */
  @Override
  public DrawingChange peek() {
    DrawingChange top = null;// initialize top
    if(topNode != null)// when it not null
      top = topNode.getData();//let top get data from the Node
    return top;
  }
  /**
   * Returns true if this stack contains no elements.
   * @return true if this stack contains no elements, otherwise false
   */
  @Override
  public boolean isEmpty() {
    if(topNode == null)// check if topNode empty
      return true;
    return false;
  }
  /**
   * This method get the number of elements in the stack
   * @return the size of the stack
   */
  @Override
  public int size() {
    return size;
  }
  /**
   * @return iterator of the stack
   */
  @Override
  public Iterator<DrawingChange> iterator() {
    Iterator<DrawingChange> iterator = new DrawingStackIterator(topNode);//construct the iterator 
    return iterator;
  }
}
