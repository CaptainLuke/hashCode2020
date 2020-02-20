import java.util.ArrayList;

public class Library {
  String[] stringBooks;
  int[] booksIDS;
  int numBooks;
  private int timeToSet;
  private int numBooksCanScan;
  ArrayList<Integer> booksToScan = new ArrayList<Integer>();
  int order;
  
  public Library(int numBooks, int timeToSet, int numBooksCanScan, int[] allBooks) {
    this.numBooks = numBooks;
    this.timeToSet = timeToSet;
    this.numBooksCanScan = numBooksCanScan;
  }
  
  public void addStringBooksIdS(String[] stringBooks) {
    this.stringBooks = stringBooks;
    booksIDS = new int[stringBooks.length];
    for(int i = 0; i < booksIDS.length; i++) {
      booksIDS[i] = Integer.parseInt(stringBooks[i]);
    }
  }
  
  public int getBookScore(int code){
    return booksIDS[code];
  }
  
  public int getTimeToSet(){
    return timeToSet;
  }
  
  public int getNumberOfBooksCanScan(){
    return numBooksCanScan;
  }
  
  public void addBookToScan(int book) {
    booksToScan.add(book);
  }
  
  public void setOrder(int order) {
    this.order = order;
  }
 
}