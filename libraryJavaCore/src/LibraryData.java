import java.io.Serializable;
import java.util.List;

public class LibraryData implements Serializable {
    private List<Book> books;
    private List<Author> authors;
    private List<Reader> readers;
    private List<BorrowingRecord> borrowingRecords;



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
