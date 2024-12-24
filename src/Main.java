import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        Author firstAuthor = new Author(1, "Bernard Cornwell", new Date());
        Author secondAuthor = new Author(2, "Uncle Bob", new Date());

        library.addNewAuthor(firstAuthor);
        library.addNewAuthor(secondAuthor);

        Book firstBook = new Book(1, "Vagabond", firstAuthor);
        Book secondBook = new Book(2, "Heretic", firstAuthor);
        Book thirdBook = new Book(3, "Clean Architecture", secondAuthor);
        Book fourthBook = new Book(4, "Clean Code", secondAuthor);

        library.addBookToShelf(firstBook);
        library.addBookToShelf(secondBook);
        library.addBookToShelf(thirdBook);
        library.addBookToShelf(fourthBook);

        while(true) {
            System.out.println("Do you want to check the available books? (yes/no)");
            String answer = scanner.nextLine().toLowerCase();

            if(answer.equals("yes")) {
                List<Book> availableBooks = library.listAllAvailableBooks();

                if(availableBooks.isEmpty()) {
                    System.out.println("There are any available books.");
                } else {
                    System.out.println("Available books:");
                    for (Book book : availableBooks) {
                        String text = String.format("%d: %s", book.getId(), book.getTitle());
                        System.out.println(text);
                    }

                    System.out.println("Type the book's ID you want to borrow:");
                    int bookId = scanner.nextInt();
                    scanner.nextLine();

                    Book selectedBook = library.searchBookById(bookId);

                    if(selectedBook != null && selectedBook.isBookAvailable()) {
                        System.out.println("Type your name:");
                        String userName = scanner.nextLine();

                        library.borrowBook(selectedBook, userName);
                        String text = String.format("The book %s was borrowed to %s", selectedBook.getTitle(), userName);
                        System.out.println(text);
                    } else {
                        System.out.println("The book was not founded, or, it's already taken by another person.");
                    }
                }
            } else if (answer.equals("no")) {
                System.out.println("Thanks!");
                break;
            } else {
                System.out.println("Invalid answer. Please only type 'yes' or 'no'");
            }
        }

        scanner.close();
    }
}
