import java.util.Date;

public class Borrow {
    private int id;
    private static int idCounter = 1;

    private Book book;
    private String userName;
    private Date borrowDate;
    private Date returnDate;
    private boolean isActive;

    public Borrow(Book book, String userName) {
        this.id = idCounter++;
        this.book = book;
        this.userName = userName;
        this.borrowDate = new Date();
        this.isActive = true;
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public String getUserName() {
        return userName;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void returnBook() {
        this.returnDate = new Date();
        this.isActive = false;
        this.book.setIsAvailable(true);
    }

    @Override
    public String toString() {
        return String.format(
                "Emprestimo{id=%d, book=%s, userName='%s', borrowDate=%s, returnDate=%s, isActive=%s}",
                id, book, userName, borrowDate, returnDate, isActive
        );
    }
}
