import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LibraryData implements Serializable {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();
    private List<BorrowingRecord> borrowingRecords = new ArrayList<>();
    private long nextBookId;
    private long nextReaderId;
    private long nextAuthorId;

    public long getNextReaderId() {
        return nextReaderId;
    }

    public void setNextReaderId(long nextReaderId) {
        this.nextReaderId = nextReaderId;
    }

    public long getNextBookId() {
        return nextBookId;
    }

    public void setNextBookId(long nextBookId) {
        this.nextBookId = nextBookId;
    }

    public long getNextAuthorId() {
        return nextAuthorId;
    }

    public void setNextAuthorId(long nextAuthorId) {
        this.nextAuthorId = nextAuthorId;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    public List<BorrowingRecord> getBorrowingRecords() {
        return borrowingRecords;
    }

    public void setBorrowingRecords(List<BorrowingRecord> borrowingRecords) {
        this.borrowingRecords = borrowingRecords;
    }

    public LibraryData(List<Book> books, List<Author> authors, List<Reader> readers, List<BorrowingRecord> borrowingRecords) {
        this.books = books;
        this.authors = authors;
        this.readers = readers;
        this.borrowingRecords = borrowingRecords;
    }

    public LibraryData(){

    }


 }
