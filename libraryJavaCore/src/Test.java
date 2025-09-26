import java.io.IOException;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LocalDate birthDate = LocalDate.of(2004, 5, 20);
        LibraryService libraryService = new LibraryService();
//        libraryService.addNewBook("Война и Мир", "Лев", "Толстой", birthDate , 2005, Genre.HORROR, 10000, 800);
        libraryService.showAllBooks();

        System.out.println();
        libraryService.findBookByTitle("война и мир");
    }
}
