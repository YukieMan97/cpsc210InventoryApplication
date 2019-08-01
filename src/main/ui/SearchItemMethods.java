package ui;

import model.items.ArtBook;
import model.items.Book;

import java.util.Scanner;

import static model.items.Book.bookList;
import static model.items.Exq.exqList;



public class SearchItemMethods {

    public static void main(String[] args) throws InvalidNameException, InvalidTitleException, InvalidInputException, InvalidChangeException {
        SearchItemMethods searchItemMethods = new SearchItemMethods();

        initiateSearch();
        searchItemMethods.startSearch1();
        String choice1 = searchItemMethods.getUserResponse();


        //TODO make the changes save into the load/save file?

    }

    public String getUserResponse() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


    public static void initiateSearch() throws InvalidInputException, InvalidTitleException, InvalidNameException, InvalidChangeException {
        System.out.println("To search for a...");
        System.out.println("Figure - press 1");
        System.out.println("Book - press 2");
        System.out.println("Press 0 to exit search.");
        System.out.println("----------------------------");

    }

    public void startSearch1() throws InvalidInputException, InvalidChangeException, InvalidNameException, InvalidTitleException {
        String choice1 = getUserResponse();
        tryFirstChoice(choice1);
        String choice3 = getUserResponse();
        chosenFigureOrBook(choice1, choice3);
        startSearch1();
    }

    public void startAgainSearch1() throws InvalidChangeException, InvalidNameException, InvalidTitleException, InvalidInputException {
        initiateSearch();
        startSearch1();
    }

    public void tryFirstChoice(String choice1) throws InvalidChangeException, InvalidTitleException, InvalidInputException, InvalidNameException {
        try {
            chooseFigureOrBook(choice1);
        } catch (InvalidInputException e) {
            System.out.println("You have entered an invalid choice!");
            tryAgainYesOrNo();
            String yesOrNoAnswer = getUserResponse();
            tryAgainChooseTopic1(yesOrNoAnswer);
        }
    }

    public void chooseFigureOrBook(String choice) throws InvalidChangeException, InvalidInputException {
        switch (choice.substring(0)) {
            // choose figure
            case "1":
                System.out.println("You have selected figure! Enter the figure's name.");
                return;
            // choose book
            case "2":
                System.out.println("You have selected book! Enter the book's title.");
                return;
            // choose quit
            case "0":
                endSearch1();
                // invalid input exception
            default:
                throw new InvalidInputException();
        }
    }

    public void chosenFigureOrBook(String choice1, String choice2) throws InvalidChangeException, InvalidTitleException, InvalidInputException, InvalidNameException {
        //Scanner scanner2 = new Scanner(System.in);

        if (choice1.equals("1")) {
            try {
                getFigureData1(choice2);
                getBookFromSearch(choice2);
            } catch (InvalidNameException e) {
                System.out.println("This figure is not found!");
                tryAgainYesOrNo();
                String yesOrNoAnswer = getUserResponse();
                tryAgainChooseTopic1(yesOrNoAnswer);
            }
        } else if (choice1.equals("2")) {
            try {
                getBookData1(choice2);
                getBookFromSearch(choice2);
            } catch (InvalidTitleException e) {
                System.out.println("This book is not found!");
                tryAgainYesOrNo();
            } finally {
                System.out.println("~ Hope you enjoy this search function ~");
            }
        }
    }


    public void tryAgainYesOrNo() {
        System.out.println("Would you like to try again? (y/n)");
    }

    public void tryAgainChooseTopic1(String yesOrNoAnswer) throws InvalidInputException, InvalidTitleException, InvalidNameException, InvalidChangeException {
        if (yesOrNoAnswer.equals("y")) {
            startAgainSearch1();
        } else if (yesOrNoAnswer.equals("n")) {
            System.out.println("Okay!");
            endSearch1();
        } else {
            System.out.println("Invalid answer!");
            System.out.println("Please enter y or n");
            tryAgainChooseTopic1(yesOrNoAnswer);
        }
    }

    public void getFigureData1(String figureName) throws InvalidNameException {
        for (int counter = 0; counter < exqList.size(); counter++) {
            if (exqList.get(counter).containsNameOrTitle(figureName)) {

                String information = exqList.get(counter).getInformation();

                System.out.println("items found! " + information);
                endSearch1();
                return;
            }
        }
        throw new InvalidNameException();
    }

    public void getBookData1(String bookTitle) throws InvalidTitleException, InvalidChangeException, InvalidInputException {
        for (int counter = 0; counter < bookList.size(); counter++) {
            if (bookList.get(counter).containsNameOrTitle(bookTitle)) {

                String title = bookList.get(counter).getTitle();
                String volumeOrChapter = bookList.get(counter).mangaChapterOrArtBookVolume();

                System.out.println("items found! " + title + ". " + volumeOrChapter);

                toDoWithItem(bookTitle);
                // endSearch1();
                return;
            }
        }
        throw new InvalidTitleException();
//        try {
//            getBookData1(...); // expect fail
//            fail()
//        } catch (..) {
//            // success
//        }
    }

    public Book getBookFromSearch(String bookTitle) {
        for (int counter = 0; counter < bookList.size(); counter++) {
            if (bookList.get(counter).containsNameOrTitle(bookTitle)) {

                String title = bookList.get(counter).getTitle();
                String volumeOrChapter = bookList.get(counter).mangaChapterOrArtBookVolume();

                return bookList.get(counter);
            }
        }
        return ArtBook.NIER; //Should return an empty book
    }

    public void toDoWithItem(String currentBookTitle) throws InvalidChangeException, InvalidTitleException, InvalidInputException {

        Scanner toDo = new Scanner(System.in);

        System.out.println("What would you like to do? Press...");

        System.out.println("1 - Change Name of Title");
        System.out.println("2 - Change Author");
        System.out.println("3 - Change Quantity");
        System.out.println("4 - Change Price");
        System.out.println("0 - Do nothing");
        System.out.println("-----------------------------------");

        String choiceOfChange = toDo.nextLine();

        switch (choiceOfChange.substring(0)) {
            // TODO make a function that changes name/title depending on the item
            case "1":
                System.out.println("What would you like to change the name/title to?");
                String nameOrTitleChange = toDo.nextLine();
                String updatedName = getBookFromSearch(currentBookTitle).setTitle(nameOrTitleChange);
                System.out.println("Name/Title updated to " + updatedName + "!");
                endSearch1();
                return;
            // TODO change case #2-#4
            case "2":
                System.out.println("Who would you like to change the author to?");
                return;
            case "3":
                changeQuantityReasons();
                String reasonForQuantityChange = toDo.nextLine();
                changeQuantity(reasonForQuantityChange);
                return;
            case "4":
                System.out.println("What is the new price?");
                return;
            case "0":
                endSearch1();

            default:
                throw new InvalidChangeException();
        }
    }

    public void changeQuantityReasons() {
        System.out.println("Reason for changing quantity?");
        System.out.println("1 - Customer Purchase");
        System.out.println("2 - Customer Hold");
        System.out.println("3 - Staff Purchase");
        System.out.println("4 - Staff Hold");
        System.out.println("0 - Go Back To Previous Menu");
        System.out.println("-----------------------------------");
    }

    public int changeQuantity(String reasonForQuantityChange) throws InvalidInputException {

        switch (reasonForQuantityChange.substring(0)) {
            case "1":
                //TODO +1 to sales & -1 to quantity
                System.out.println("Okay, customer purchase!");
                return 1;
            case "2":
                //TODO +1 to holds & -1 to quantity
                System.out.println("Okay, customer hold!");
                return 2;
            case "3":
                //TODO +1 to sales & -1 to quantity
                System.out.println("Okay, staff purchase!");
                return 3;
            case "4":
                //TODO +1 to holds & -1 to quantity
                System.out.println("Okay, staff hold!");
                return 4;
            case "5":
                //TODO go back to main menu
                System.out.println("Okay, returning to previous menu!");
                return 5;

            default:
                throw new InvalidInputException();
        }
    }

    public void endSearch1() {
        System.out.println("Search function exited; Have a good day!");
        System.exit(0);
    }
}
