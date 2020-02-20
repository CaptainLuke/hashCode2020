import java.util.ArrayList;
public class Library {
  ArrayList books;
  int numBooks;
  public static int nextId;
  public int id;
  public int timeToSet;
  public int numBooksCanScan;
  
  public Library(int numBooks, int timeToSet, int numBooksCanScan) {
    this.numBooks = numBooks;
    id = nextId;
    nextId++;
    this.timeToSet = timeToSet;
    this.numBooksCanScan = numBooksCanScan;
  }
  

}
