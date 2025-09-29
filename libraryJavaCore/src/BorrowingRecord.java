import java.io.Serializable;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class BorrowingRecord implements Serializable {
    private static final AtomicInteger counter = new AtomicInteger();

    private static final long serialVersionUID = 1L;
    private final Long id;
    private Book book;
    private Reader reader;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public BorrowingRecord(Book book, Reader reader, LocalDate dueDate) {
    	this.id = (long) counter.incrementAndGet();
    	this.book = book;
    	this.reader = reader;
    	this.dueDate = dueDate;
    	this.returnDate = null;
    }

    public BorrowingRecord(){
        this.id = (long) counter.incrementAndGet();
    }


    public Long getId() {
    	return id;
    }

    public Book getBook() {
    	return book;
    }

    public void setBook(Book newBook) {
    	this.book = newBook;
    }

    public Reader getReader() {
    	return reader;
    }

    public void setReader(Reader newReader) {
    	this.reader = newReader;
    }

    public LocalDate getDueDate() {
    	return dueDate;
    }

    public void setDueDate(LocalDate newDueDate) {
    	this.dueDate = newDueDate;
    }

    public LocalDate getReturnDate() {
    	return returnDate;
    }

    public void setReturnDate(LocalDate newReturnDate) {
    	this.returnDate = newReturnDate;
    }

    @Override
    public String toString(){
        return getId() + "  " + getBook().getTitle() + "  " + getReader().getEmail() + "  " + getDueDate() + "  " + getReturnDate();
    }
}

