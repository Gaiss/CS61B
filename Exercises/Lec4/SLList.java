/** An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within. */
public class SLList {
  /* The first item (if it exists) is at sentinel.next. */
  //sentinel is just a guilder
  private IntNode sentinel;
  private int size;

  /**
   * A nested class, indicates a node object of a SLList.
   */
  private static class IntNode {
    //Two instance variables, indicate the current data in the node and the pointer to next IntNode
    public int item;
    public IntNode next;

    /**
     * IntNode constructor.
     * @param i an integer, indicates the data in this IntNode
     * @param n an IntNode object, indicates the reference of next IntNode
     */
    public IntNode(int i, IntNode n) {
      item = i;
      next = n;
    }
  }

  /** Empty constructor, creates an empty SLList. */
  public SLList() {
    sentinel = new IntNode(63, null);
    size = 0;
  }

  /**
   * One node constructor, creates a SLList with only one IntNode.
   * @param x an integer, indicates the first IntNode's data
   */
  public SLList(int x) {
    //sentinel node's value does not matter, just a guilder
    sentinel = new IntNode(63, null);
    sentinel.next = new IntNode(x, null);
    size = 1;
  }

  /**
   * Third constructor, with an array argument.
   * @param array an array obejct
   */
  public SLList(int[] array) {
    //Initialize sentinel and size instance variables
    sentinel = new IntNode(63, null);
    size = 0;
    //Use for each loop to add each element to the list
    for(int element:array) {
      //Use addLast method, then the order will be correct
      this.addLast(element);
    }
  }

  /**
   * Adds x to the front of the list.
   * @param x an integer, indicates the value of the first IntNode
   */
  public void addFirst(int x) {
    sentinel.next = new IntNode(x, sentinel.next);
    size = size + 1;
  }

  /** Returns the first item in the list. */
  public int getFirst() {
    return sentinel.next.item;
  }

  /**
   * Adds x to the end of the list.
   * @param x an integer, indicates the value of the last IntNode
   */
  public void addLast(int x) {
    size = size + 1;

    IntNode p = sentinel;

    /* Advance p to the end of the list. */
    while (p.next != null) {
      p = p.next;
    }

    p.next = new IntNode(x, null);
  }

  /** Returns the size of the list. */
  public int size() {
    return size;
  }

  /**
   * Delete the first IntNode in the SLList.
   */
  public void deleteFirst() {
    //Check if there is at least one IntNode in the SLList
    if (sentinel.next != null) {
      //Abandon the first IntNode
      sentinel.next = sentinel.next.next;
      //Size minus one
      size -= 1;
    }
  }

  public static void main(String[] args) {
    /* Creates a list of one integer, namely 10 */
    int[] array = new int[]{1,2,3,4,5};
    SLList L = new SLList(array);
    System.out.println(L.size());
    System.out.println(L.getFirst());
    /**
    SLList L = new SLList();
    L.addFirst(15);
    L.addFirst(10);
    L.addFirst(5);
    L.deleteFirst();
    L.deleteFirst();
    System.out.println(L.size());
    System.out.println(L.getFirst());
     */
  }
}
