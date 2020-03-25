/**
 * A class that represents a list.
 */
public class IntList {
  //Two instance variables, indicates the first integer element and the rest parts of the list
  public int first;
  public IntList rest;

  /**
   * Constructor of the list.
   * @param f an integer, indicates the first integer element
   * @param r an IntList object, indicates the rest parts of the list
   */
  public IntList(int f, IntList r) {
    first = f;
    rest = r;
  }

  /**
   * If 2 numbers in a row are the same, we add them together and make one large node.
   */
  public void addAdjacent(){
    //Initialize a IntList object to store the current
    IntList p = this;
    //Check if p is null
    if (p == null) {
      return;
    }
    //Loop if p.rest is not null
    while(p.rest != null) {
      //If 2 numbers in a row are same
      if(p.first == p.rest.first) {
        //Add them together and make one large node
        p.first *= 2;
        p.rest = p.rest.rest;
      }
      //Continue check rest parts
      else {
        p = p.rest;
      }
    }
  }

  /** Square Insertion */
  public void addLastAndSquare(int x) {
    //Initialize a IntList object to store the current
    IntList p = this;
    //Loop if p.rest is not null
    while (p.rest != null) {
      //Create a squareNode
      IntList squareNode = new IntList(p.first * p.first, p.rest);
      //Add together
      p.rest = squareNode;
      //Check next original node
      p = p.rest.rest;
    } /* p stops at the last node */
    /* add node of x */
    IntList newNode = new IntList(x, null);
    /* square the last node  */
    IntList squareNode = new IntList(p.first * p.first, newNode); /* p.rest is null */
    p.rest = squareNode;
    /* if use while (p != null), need an extra pointer to the previous node (to remember) */
    //size += 1;
  }

  /**
   * Add a new integer element to the IntList.
   * @param x an integer, indicates the new element
   */
  public void add(int x) {
    rest = new IntList(first, rest);
    first = x;
  }

  /**
   * Return the size of the list using recursion!
   * @return an integer, indicates the size of the list
   */
  public int size() {
    //Base case
    if(this.rest == null) {
      return 1;
    }
    //Recursion cases
    else {
      return 1 + rest.size();
    }
  }

  /**
   * Return the size of the list using no recursion!
   * @return an integer, indicates the size of the list
   */
  public int iterativeSize() {
    //Initialize an integer to store the size of the list
    int size = 0;
    //Initialize an IntList object to represents the current list
    IntList p = this;
    //While loop to count size
    while(p != null) {
      size++;
      p = p.rest;
    }
    return size;
  }

  /**
   * Returns the ith value in this list.
   * @param i an integer, indicates the index of the element
   * @return an integer, indicates the ith element
   */
  public int get(int i) {
    //Base case
    if(i == 0) {
      return this.first;
    }
    //Recursion cases
    else {
      return this.rest.get(i -1);
    }
  }

  /**
   * Returns an IntList identical to L, but with all values incremented by x.Values in L does
   * not change.
   * @param L an IntList object, indicates the IntList we want to copy
   * @param x an integer, indicates how many we want to increment
   * @return an IntList object, indicates the new list
   */
  public static IntList incrList(IntList L, int x) {
    /* Your code here. */
    //Base cases
    if(L == null) {
      return null;
    }
    IntList newList = new IntList(L.first + x , null);
    //Recursion cases
    newList.rest = incrList(L.rest, x);
    return newList;
  }

  /**
   * Returns an IntList identical to L, but with each element incremented by x.
   * Not allowed to use the 'new' keyword.
   * @param L an IntList object, indicates the IntList we want to copy
   * @param x an integer, indicates how many we want to increment
   * @return an IntList object, indicates the new list
   */
  public static IntList dincrList(IntList L, int x) {
    /* Your code here. */
    //Base case
    if(L == null) {
      return null;
    }
    L.first += x;
    //Recursion cases
    L.rest = dincrList(L.rest, x);
    return L;
  }

  /**
   * Return the String form of the list.
   */
  public String toString() {
    //Base case
    if(this.rest == null) {
      return Integer.toString(this.first);
    }
    //Recursion cases
    else {
      return Integer.toString(this.first) + " " + this.rest.toString();
    }
  }

  /**
   * Main function.
   * @param args
   */
  public static void main(String[] args) {
    IntList L = new IntList(4, null);
    L.add(2);
    L.add(1);
    L.add(1);
    System.out.println(L);
    L.addLastAndSquare(10);
    System.out.println(L.size());
    System.out.println(L);
  }
}
