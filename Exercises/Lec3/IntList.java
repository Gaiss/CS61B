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
    IntList L = new IntList(15, null);
    L.add(10);
    L.add(5);
    //L = new IntList(10, L);
    //L = new IntList(5, L);
    System.out.println(L.size());
    System.out.println(L.iterativeSize());
    System.out.println(L.get(0));
    System.out.println(L.get(1));
    System.out.println(L.get(2));
    IntList list1 = IntList.incrList(L,15);
    IntList list2 = IntList.dincrList(L,15);
    System.out.println(list1.toString());
    System.out.println(list2.toString());
    //Check if the original list changes
    System.out.println(L.toString());
  }
}
