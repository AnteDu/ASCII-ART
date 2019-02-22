public class ExceptionalCode {  
 
  // 1. practice tracing more complex (nested) try-catch-finally blocks
  // this examples started without the outer try-catch, and without either finally block
  // NOTE: in addition to testing your mechanical understanding of this mechanism, 
  //       this code demonstrates a down-side of this construct: code can become harder to read
  public static void traceProblem() {
    try { 
      String[]  array = new String[2];
      try {        
        System.out.print("9");
        if( array[1].length() < 3 ) // <= null pointer exception thrown here
          System.out.print("8");    // because array contents are not initialized
      } catch(NullPointerException e) { // null pointer exception is caught and handled here
        if(array[2] == null) // <= array index out of bounds exception is thrown here
          System.out.print("7"); // because the array only contains two String references
      } catch(ArrayIndexOutOfBoundsException e) {
        System.out.print("6");
      } finally { // but before we can leave this try-catch-finally sequence,
        System.out.print("3"); // we must attempt to run this finally block
      }
      System.out.print("5");
    } catch(ArrayIndexOutOfBoundsException e) { // then we can catch the exception thrown from line 20
      System.out.print("4");
    } finally { // we must then execute the finally
      System.out.print("2"); // this time there are no outstanding exceptions being thrown
    }
    System.out.println("1"); // and so this method is now able to terminate gracefully
  }
 
  public static void main(String[] args) {
    traceProblem();
  }
  }