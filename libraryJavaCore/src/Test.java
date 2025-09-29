import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LocalDate birthDate = LocalDate.of(2004, 5, 20);
        LibraryService libraryService = new LibraryService();
       //libraryService.addNewBook("Война и Мир", "Лев", "Толстой", birthDate , 2005, Genre.HORROR, 20, 20);
////      libraryService.findBookByTitle("война и мир");
        //libraryService.addNewReader("Dexter", "Morgan", "dextermorgan2@mail.com", "+77072563696");
        libraryService.showAllReaders();
        //libraryService.borrowBook(2L, 2L);
        //libraryService.showAllBooks();
        libraryService.returnBook(2L);
        libraryService.showAllBooks();
//        libraryService.showBorrowingRecords();


    }
}
