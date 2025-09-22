import java.time.LocalDate;

public class BorrowingRecord {
    private Long id;
    private Book book;
    private Reader reader;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public BorrowingRecord(Long id, Book book, Reader reader, LocalDate dueDate, LocalDate returnDate) {
    	this.id = id;
    	this.book = book;
    	this.reader = reader;
    	this.dueDate = dueDate;
    	this.returnDate = returnDate;
    }

    public BorrowingRecord(){

    }


    public Long getId() {
    	return id;
    }

    public void setId(Long newId) {
    	this.id = newId;
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
}

