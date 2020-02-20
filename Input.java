import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {

  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("FilePath");
    Scanner scan = new Scanner(file);
    String[] firstLine = scan.nextLine().split(" ");
    //[0] is number of books
    //[1] is number of libraries
    //[2] is time in number of days
    int time = Integer.parseInt(firstLine[3]); //Number of days as an int
    int numBooks = Integer.parseInt(firstLine[0]); //Number of books
    int numLibraries = Integer.parseInt(firstLine[2]); //Number of libraries
    String[] stringBookScores = scan.nextLine().split(" ");
    int[] bookScore = new int[stringBookScores.length];
    for(int i = 0; i < bookScore.length; i++) {
      bookScore[i] = Integer.parseInt(stringBookScores[i]);
    }
    //Scores of books from 0 to number of books - 1
    
    //Number of library "Sections" 
    //Line one in a section - number of books in the library [space] number of days it takes to set it up [space] 
    //number of books that can be shipped per day after set up
    //Line two  - Describes books in the library by id number
    
    for(int i = 0; i < Integer.parseInt(firstLine[1]); i++) {
      ArrayList<Library> libraries = new ArrayList<Library>();
      String[] libraryFirstLine = scan.nextLine().split(" ");
      Library tempLibrary = new Library(Integer.parseInt(libraryFirstLine[0]), Integer.parseInt(libraryFirstLine[1]), Integer.parseInt(libraryFirstLine[2]), bookScore);
      String[] librarySecondLine = scan.nextLine().split(" ");
      tempLibrary.addStringBooksIdS(librarySecondLine);
      libraries.add(tempLibrary);
    }
    
    //bookScore is an array with the scores of all the books in it, get a score by bookScore[id of book]
    //libraries is an arraylist of all the libraries
    //with that you can do libraries.get(id of library).getBookScore(id of book)
    //getTimeToSetSet returns an int of the time to set up
    //getNumberOfBooksCanScan returns an int of the number of books it can scan in a day
    
    
    
    
    
  }

}
