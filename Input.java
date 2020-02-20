import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class Input {

  public static void main(String[] args) throws FileNotFoundException {
    File fileIn = new File("Input.txt");
    File fileOut = new File("Output.txt");
    Scanner scan = new Scanner(fileIn);
    String[] firstLine = scan.nextLine().split(" ");
    PrintWriter writer = new PrintWriter(fileOut);
    int numLibrariesUsed = 0;
    // [0] is number of books
    // [1] is number of libraries
    // [2] is time in number of days
    int time = Integer.parseInt(firstLine[2]); // Number of days as an int
    int numBooks = Integer.parseInt(firstLine[0]); // Number of books
    int numLibraries = Integer.parseInt(firstLine[1]); // Number of libraries
    String[] stringBookScores = scan.nextLine().split(" ");
    int[] bookScore = new int[stringBookScores.length];
    for (int i = 0; i < bookScore.length; i++) {
      bookScore[i] = Integer.parseInt(stringBookScores[i]);
    }
    // Scores of books from 0 to number of books - 1

    // Number of library "Sections"
    // Line one in a section - number of books in the library [space] number of days it takes to set
    // it up [space]
    // number of books that can be shipped per day after set up
    // Line two - Describes books in the library by id number

    ArrayList<Library> libraries = new ArrayList<Library>();
    for (int i = 0; i < Integer.parseInt(firstLine[1]); i++) {
      String[] libraryFirstLine = scan.nextLine().split(" ");
      Library tempLibrary = new Library(Integer.parseInt(libraryFirstLine[0]),
          Integer.parseInt(libraryFirstLine[1]), Integer.parseInt(libraryFirstLine[2]), bookScore);
      String[] librarySecondLine = scan.nextLine().split(" ");
      tempLibrary.addStringBooksIdS(librarySecondLine);
      libraries.add(tempLibrary);
    }

    // bookScore is an array with the scores of all the books in it, get a score by bookScore[id of
    // book]
    // libraries is an arraylist of all the libraries
    // with that you can do libraries.get(id of library).getBookScore(id of book)
    // getTimeToSetSet returns an int of the time to set up
    // getNumberOfBooksCanScan returns an int of the number of books it can scan in a day
    // addBookToScan(int book) adds a book with the given id to that paticular library to scan


    //
    // Main alg
    for (int i = 0; i < libraries.size(); i++) {
      libraries.get(i).order = i;
    }

    int timeUsed = 0;
    ArrayList<Library> librariesUsed = new ArrayList<Library>();
    while (time - timeUsed > 0) {

      int mst = 0;
      if (libraries.size() > 0) {
        mst = libraries.get(0).getTimeToSet();
      } else {
        break;
      }
      int msti = 0;
      for (int i = 0; i < libraries.size(); i++) {
        if (libraries.get(i).getTimeToSet() <= mst) {
          mst = libraries.get(i).getTimeToSet();
          msti = i;
        }
      }

      librariesUsed.add(libraries.get(msti));
      libraries.remove(msti);
      int tr = time - librariesUsed.get(librariesUsed.size() - 1).getTimeToSet();
      int bts = tr * librariesUsed.get(librariesUsed.size() - 1).getNumberOfBooksCanScan();
      for (int i = 0; i < bts; i++) {
        if (i < librariesUsed.get(librariesUsed.size() - 1).numBooks) {
          librariesUsed.get(librariesUsed.size() - 1).addBookToScan(i);
        }

      }


      timeUsed += librariesUsed.get(librariesUsed.size() - 1).getTimeToSet();
    }
    // Main alg
    //

    writer.println(librariesUsed.size());
    for (int i = 0; i < librariesUsed.size(); i++) {
      writer.println(librariesUsed.get(i).order + " " + librariesUsed.get(i).booksToScan.size());
      for (int j = 0; j < librariesUsed.get(i).booksToScan.size(); j++) {
        writer.print(librariesUsed.get(i).booksToScan.get(j) + " ");
      }
      writer.println();
    }
    writer.flush();
  }
}
