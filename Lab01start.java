
/**
 * A simple integer counter.
 */
public class Counter {
  
  private int count; // current count
  
  // Constructors:
  
  /**
   * Create a new Counter, with the count initialized
   * to 0.
   */
  public Counter () {
    count = 0;
  }
  
  // Queries (Accessors):
  
  /**
   * The number of items counted.
   */
  public int currentCount () {
    return count;
  }
  
  // Commands (Mutators):
  
  /**
   * Increment the count by 1.
   */
  public void incrementCount () {
    count = count + 1;
  }
  
  /**
   * Reset the count to 0.
   */
  public void reset () {
    count = 0;
  }
}
