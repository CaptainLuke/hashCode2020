import java.util.ArrayList;
public class Library {
  String[] stringBooks;
  int[] intBooksIDS;
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
  
  public void addStringBooksIdS(String[] stringBooks) {
    this.stringBooks = stringBooks;
    intBooksIDS = new int[stringBooks.length];
    for(int i = 0; i < intBooksIDS.length; i++) {
      intBooksIDS[i] = Integer.parseInt(stringBooks[i]);
    }
  }
  

}
