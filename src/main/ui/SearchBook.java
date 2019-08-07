package ui;

import model.items.ArtBook;
import model.items.Book;
import model.items.Item;
import ui.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class SearchBook {
    private SearchItemMethods sim;
    private TryAgainMethods tam;
    private ToDoWithItem tdwi;
    private ArrayList<Book> bookArrayList;
    private SearchFigure sf;
    private SearchBook sb;

    public SearchBook(SearchItemMethods sim) {
        this.sim = sim;
        this.tam = new TryAgainMethods(sim, sf, sb);
        tdwi = new ToDoWithItem(sim);
        bookArrayList = Book.BOOK_LIST;
        this.sb = sb;
        this.sf = sf;
    }

    public String getUserResponse() {
        return sim.getUserResponse();
    }


    // EFFECTS: if the bookTitle matches the title of a book in the booklist,
    //          return this book. Otherwise, return the Nier ArtBook.
    public Book getBookFromSearch(String bookTitle) {
        for (Book book : bookArrayList) {
            if (book.containsNameOrTitle(bookTitle)) {
                book.getTitle();
                book.mangaChapterOrArtBookVolume();
                return book;
            }
        }
        return ArtBook.NIER;
    }

    // REQUIRES: BOOK_LIST cannot have more than 3 books of the same title
    // MODIFIES: this
    // EFFECTS:  User enters a bookTitle that matches another book's title.
    //           If there is a single book, then the title, volume, and quantity will be printed.
    //           If there are multiple books (up to 3 books), then they are added to
    //           listOfBookData and all their titles, volumes, and quantities will be printed.
    //           Throws a new InvalidTitleException when the desired book is not found
    public void getBookData(String bookTitle) throws InvalidTitleException,
            InvalidChangeException, InvalidInputException, InvalidNameException {
        List<Book> listOfBookData = new ArrayList<>();
        for (int counter = 0; counter < bookArrayList.size(); counter++) {
            if (bookArrayList.get(counter).containsNameOrTitle(bookTitle)) {
                listOfBookData.add(bookArrayList.get(counter));
            }
        }
        if (listOfBookData.size() == 2 || listOfBookData.size() == 3) {
            getListOfBookTitles(listOfBookData);
            try {
                chooseOneBookFromList(listOfBookData);
            } catch (InvalidBookChoiceException e) {
                tryAgainBacktoGetBookData(bookTitle);
            }
        }
        if (listOfBookData.size() == 1) {
            String title = listOfBookData.get(0).getTitle();
            String volumeOrChapter = listOfBookData.get(0).mangaChapterOrArtBookVolume();
            System.out.println("Item found! " + title + " ." + volumeOrChapter);
            try {
                toDoWithItem(listOfBookData.get(0));
            } catch (InvalidChangeException e) {
                System.out.println("Hmm");
                tryAgainBackToSearchAgain();
                endSearch();
            }
        }
        throw new InvalidTitleException();
//        try {
//            getBookData(...); // expect fail
//            fail()
//        } catch (..) {
//            // success
//        }
    }

    // REQUIRES: the size of the list inputted must be either 2 or 3
    public void getListOfBookTitles(List<Book> listOfSameSeries) {
        List<String> listOfBookTitles = new ArrayList<>();
        for (Book sameBookSeries : listOfSameSeries) {
            listOfBookTitles.add((sameBookSeries.getTitle()) + " "
                    + (sameBookSeries.getVolumeOrChapter())
                    + " (" + Integer.toString(sameBookSeries.getQuantity())
                    + " left)");
        }
        System.out.println(listOfBookTitles);
    }

    public void toDoWithItem(Item item) throws InvalidChangeException,
            InvalidInputException, InvalidNameException, InvalidTitleException {
        tdwi.toDoWithItem(item);
    }

    // REQUIRES: the size of the list must be either 2 or 3
    // MODIFIES: this
    // EFFECTS: gives the choice of choosing between the same titled books that have
    //          different chapters.
    //TODO method too long
    public void chooseOneBookFromList(List<Book> listOfBooks) throws InvalidInputException,
            InvalidChangeException, InvalidNameException, InvalidTitleException, InvalidBookChoiceException {

        multipleBooksMessage();

        String bookPosition = getUserResponse();

        switch (bookPosition) {
            case "1":
                System.out.println("You have chosen the first item: "
                        + listOfBooks.get(0).getTitle() + " "
                        + listOfBooks.get(0).getVolumeOrChapter());
                toDoWithItem(listOfBooks.get(0));
                return;
            case "2":
                System.out.println("You have chosen the second item: "
                        + listOfBooks.get(1).getTitle() + " "
                        + listOfBooks.get(1).getVolumeOrChapter());
                toDoWithItem(listOfBooks.get(1));
                return;
            case "3":
                System.out.println("You have chosen the third item: "
                        + listOfBooks.get(2).getTitle() + " "
                        + listOfBooks.get(2).getVolumeOrChapter());
                toDoWithItem(listOfBooks.get(2));
                return;
            case "0":
                endSearch();
                return;
            default:
                throw new InvalidBookChoiceException();
        }
    }

    // EFFECTS: prints a message about choosing from multiple books
    public void multipleBooksMessage() {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("There seems to be multiple of these books!");
        System.out.println("Which one would you like? (press 1 for the first choice, etc.)");
        System.out.println("-----------------------------------------------------------------");
    }

    public void invalidChoiceMessage() {
        tam.invalidChoiceMessage();
    }

    public void tryAgainBacktoGetBookData(String bookTitle) throws InvalidChangeException,
            InvalidNameException, InvalidTitleException, InvalidInputException {
        tam.tryAgainBackToGetBookData(bookTitle);
    }

    public void tryAgainBackToSearchAgain() throws InvalidInputException,
            InvalidTitleException, InvalidNameException, InvalidChangeException {
        tam.tryAgainBackToSearchAgain();
    }

    public void endSearch() {
        sim.endSearch();
    }
}
