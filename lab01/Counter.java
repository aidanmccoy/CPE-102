/**
 * A modulus counter that counts up to a maximum counter then starts back
 * at zero once it hits the max
 *
 * @author Aidan McCoy
 * @version Lab 01
 * @version CPE102-16/17
 * @version Spring 2015
 */


/**
 * A simple integer counter.
 */
public class Counter {
  
  private int count; // current count
  private int mod = 5;// max modulus 
  private int store; // stored value before reset 
  private boolean beenReset = false;
  // Constructors:
  
  /**
   * Create a new Counter, with the count initialized
   * to 0.
   */
  public Counter () {
    count = 0;
  }
  
 // public Modulus () {
   // mod = 5;
 // }

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
   if(count==mod){
     count = 0;
   }
   else
     count = count + 1;
  }
  
  /**
   * Reset the count to 0.
   */
  public void reset () {
    beenReset = true;
    store = count;
    count = 0;
  }
  
  /**
   * Un resets the count
   */
  public void unReset(){
    if(beenReset == true){
      count = store;}
  }
}

