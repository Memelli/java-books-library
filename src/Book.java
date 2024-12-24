import java.util.Date;

public class Book {
    private int id;
    private String title;
    private Author author;
    private boolean isAvailable;
    private Date createdAt;
    private Date updatedAt;

    public Book(int id, String title, Author author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean isBookAvailable() {
        return isAvailable;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setTitle(String title) {
        this.title = title;
        this.updatedAt = new Date();
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return String.format(
                "Livro{id=%d, title='%s', author='%s', isAvailable=%s, createdAt=%s, updatedAt=%s}",
                id, title, author, isAvailable, createdAt, updatedAt
        );
    }
}
