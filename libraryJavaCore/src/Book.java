
public class Book {
    private String isbn;
    private String title;
    private Author author;
    private int publicationYear ;
    private Genre genre;
    private int totalCopies;
    private int availableCopies;


    public Book(String isbn, String title, Author author, int publicationYear, Genre genre, int totalCopies, int availableCopies) {
    	this.isbn = isbn;
    	this.title = title;
    	this.author = author;
    	this.publicationYear = publicationYear;
    	this.genre = genre;
    	this.totalCopies = totalCopies;
    	this.availableCopies = availableCopies;
    }

    public Book() {

    }



    public String getIsbn() {
    	return isbn;
    }

    public void setIsbn(String newIsbn) {
    	this.isbn = newIsbn;
    }

    public String getTitle() {
    	return title;
    	}

    public void setTitle(String newTitle) {
    	this.title = newTitle;
    }


    public Author getAuthor() {
    	return author;
    }

    public void setAuthor(Author newAuthor) {
    	this.author = newAuthor;
    }

    public int getPublicationYear() {
    	return publicationYear;
    }

    public void setPublicationYear(int newPublicationYear) {
    	this.publicationYear = newPublicationYear;
    }

    public Genre getGenre() {
    	return genre;
    }

    public void setGenre(Genre newGenre) {
    	this.genre = newGenre;
    }


    public int getTotalCopies() {
    	return totalCopies;
    }

    public void setTotalCopies(int newTotalCopies) {
    	this.totalCopies = newTotalCopies;
    }


    public int getAvailableCopies() {
    	return availableCopies;
    }

    public void setAvailableCopies(int newAvailableCopies) {
    	this.availableCopies = newAvailableCopies;
    }




}
