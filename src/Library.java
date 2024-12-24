import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Borrow> borrows = new ArrayList<>();

    public void addBookToShelf(Book book) {
        books.add(book);
    }

    public List<Book> listAllBooks() {
        return books;
    }

    public List<Book> listAllAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for(Book book : books) {
            if(book.isBookAvailable()) {
                availableBooks.add(book);
            }
        }

        return availableBooks;
    }

    public Book searchBookById(int id) {
        for(Book book : books) {
            if(book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    public void updateBookTitle(int id, String newTitle) {
        for(Book book : books) {
            if(book.getId() == id) {
                book.setTitle(newTitle);
                break;
            }
        }
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getId() == id);
    }

    public void addNewAuthor(Author author) {
        authors.add(author);
    }

    public List<Author> listAllAuthors() {
        return authors;
    }

    public void updateAuthorName(int id, String newName) {
        for(Author author : authors) {
            if(author.getId() == id) {
                author.setName(newName);
                break;
            }
        }
    }

    public void deleteAuthor(int id) {
        authors.removeIf(author -> author.getId() == id);
    }

    public void borrowBook(Book book, String userName) {
        if(book.isBookAvailable()) {
            Borrow borrow = new Borrow(book, userName);
            borrows.add(borrow);
            book.setIsAvailable(false);
        } else {
            System.out.println("This book is not available for borrowing.");
        }
    }

    public void returnBook(int idEmprestimo) {
        for(Borrow borrow : borrows) {
            if(borrow.getId() == idEmprestimo && borrow.isActive()) {
                borrow.returnBook();
                break;
            }
        }
    }

    public List<Borrow> listAllBorrows() {
        return borrows;
    }
}
