import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        LibraryService service = new LibraryService();
        Scanner scanner = new Scanner(System.in);
        boolean statusOfApp = true;
        while(statusOfApp){
            if(!statusOfApp){
                System.out.println("Завершение программы");
                break;
            }
            System.out.println("Добро пожаловать в программу! ");
            System.out.println("Выберите один из вариантов: ");
            System.out.println("1. Войти как library stuff");
            System.out.println("2. Войти как читатель");
            System.out.println("3. Выход из приложения");
            int x = scanner.nextInt();
            scanner.nextLine();
            switch(x){
                case 1 :
                    runLibrarianMenu(scanner, service);
                    break;
                case 2 :
                    //вход как читатель
                    break;
                case 3 :
                    //выход
                    statusOfApp = false;
                    break;
                default:
                    System.out.println("Введено не правильное число");
                    break;
            }

        }

    }
    //TODO: сделать метод вывода меню для библиотекаря,
    public static void runLibrarianMenu(Scanner scanner, LibraryService service) {
        System.out.println("Вы зашли как работник библиотеки!");
        System.out.println("=======================================");
        System.out.println("Выберите действие:");
        System.out.println("1. Показать список всех книг");
        System.out.println("2. Показать список всех читателей");
        System.out.println("3. Добавить новую книгу");
        System.out.println("4. Добавить нового читателя");
        System.out.println("5. Список состояния выдач");
        System.out.println("6. Принять книгу от читателя");
        System.out.println("7. Выдать книгу читателю");
        System.out.println("8. Найти книгу по названию");
        System.out.println("9. Найти список книг по автору");
        System.out.println("10. Найти читателя по ID");
        System.out.println("0. Выход");
        System.out.println("=======================================");
        boolean statusOfApp = true;

        while(statusOfApp){
            int x = scanner.nextInt();
            scanner.nextLine();
            switch(x){
                case 0:
                    System.out.println("Выход из меню");
                    statusOfApp = false;
                    System.out.println("\n--- Нажмите Enter для продолжения ---");
                    scanner.nextLine();
                    break;
                case 1:
                    service.showAllBooks();
                    System.out.println("\n--- Нажмите Enter для продолжения ---");
                    scanner.nextLine();
                    break;
                case 2:
                    service.showAllReaders();
                    System.out.println("\n--- Нажмите Enter для продолжения ---");
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Введите название: ");
                    String title = scanner.nextLine();
                    System.out.println("Введите имя автора: ");
                    String authorFirstName = scanner.nextLine();
                    System.out.println("Введите фамилию автора: ");
                    String authorLastName = scanner.nextLine();
                    System.out.println("Введите дату рождения автора: ");
                    LocalDate askedDate = askUserForDate(scanner);
                    System.out.println("Введите дату публикации книги: ");
                    int publicationYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Выберите жанр книги: ");
                    Genre genre = askUserForGenre(scanner);
                    System.out.println("Введите количество экземпляров книги: ");
                    int totalCopies = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Введите количество доступных экземпляров");
                    int availableCopies = scanner.nextInt();
                    scanner.nextLine();
                    service.addNewBook(title, authorFirstName, authorLastName, askedDate, publicationYear, genre, totalCopies, availableCopies);

                    System.out.println("Книга создана" + service.findBookByTitle(title));
                    System.out.println("\n--- Нажмите Enter для продолжения ---");
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("Введите имя читателя: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Введите фамилию читателя: ");
                    String lastName = scanner.nextLine();
                    System.out.println("Введите email читателя: ");
                    String email = scanner.nextLine();
                    System.out.println("Введите номер читателя: ");
                    String phoneNumber = scanner.nextLine();
                    Reader reader = service.addNewReader(firstName, lastName, email, phoneNumber);
                    if(reader == null){
                        System.out.println("Ошибка создания читательского билета");
                    }else {
                        System.out.println("Читательский билет успешно создан: " + reader);
                    }
                    System.out.println("\n--- Нажмите Enter для продолжения ---");
                    scanner.nextLine();
                    break;
                case 5:
                    service.showBorrowingRecords();
                    System.out.println("\n--- Нажмите Enter для продолжения ---");
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println("Введите айди книги: ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();
                    service.returnBook(id);
                    System.out.println("\n--- Нажмите Enter для продолжения ---");
                    scanner.nextLine();
                    break;
                case 7:
                    System.out.println("Введите айди книги: ");
                    Long bookId = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("Введите айди читателя: ");
                    Long readerId = scanner.nextLong();
                    scanner.nextLine();
                    service.borrowBook(bookId,readerId);
                    System.out.println("\n--- Нажмите Enter для продолжения ---");
                    scanner.nextLine();
                    break;
                case 8:
                    System.out.println("Введите название книги: ");
                    String bookTitle = scanner.nextLine();
                    Book foundBook = service.findBookByTitle(bookTitle);
                    System.out.println(foundBook);
                    System.out.println("\n--- Нажмите Enter для продолжения ---");
                    scanner.nextLine();
                    break;
                case 9:
                    System.out.println("Введите имя автора: ");
                    String authorFirstName1 = scanner.nextLine();
                    System.out.println("Введите фамилию автора: ");
                    String lastNameOfAuthor = scanner.nextLine();
                    List<Book> foundListOfBooks = service.findBooksByAuthor(authorFirstName1,lastNameOfAuthor);
                    if(foundListOfBooks.isEmpty()){
                        System.out.println("Книг с этим автором не найдено в библиотеке.");
                    }else{
                        System.out.println("Найдены следующие книги автора " + authorFirstName1 + " " + lastNameOfAuthor + ": ");
                        for(Book book : foundListOfBooks){
                            System.out.println(book);
                        }
                    }
                    System.out.println("\n--- Нажмите Enter для продолжения ---");
                    scanner.nextLine();
                    break;
                case 10:
                    System.out.println("Введите айди читателя");
                    Long readerID = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println(service.findReaderById(readerID));
                    System.out.println("\n--- Нажмите Enter для продолжения ---");
                    scanner.nextLine();
                    break;
            }
        }
    }
    public static LocalDate askUserForDate(Scanner scanner){
        while(true){
            System.out.print("Введите дату рождения автора (в формате ГГГГ-ММ-ДД): ");
            String prompt = scanner.nextLine();
            try{
                return LocalDate.parse(prompt);
            }catch (DateTimeException e){
                System.out.println("Ошибка ввода! Пожалуйста введите в формате ГГГГ-ММ-ДД");
            }
        }
    }
    public static Genre askUserForGenre(Scanner scanner) {
        Genre[] allGenres = Genre.values();
        for(int i =0; i < allGenres.length; i++){
            System.out.println("[" + (i+1) + "]" + allGenres[i].getDisplayName());
        }
        System.out.println("Введите номер жанра: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        if(num >= allGenres.length || num < 1){
            System.out.println("Ошибка ввода! Вы ввели неправильную цифру");
            return askUserForGenre(scanner);
        }
        return allGenres[num - 1];

    }

    public static void runReaderMenu(Scanner scanner, LibraryService service){
        boolean statusOfApp = true;
        while(statusOfApp){
            int x = scanner.nextInt();
            scanner.nextLine();
            switch(x){
                case 0 :
                    System.out.println("Выход из меню");
                    statusOfApp = false;
                    System.out.println("\n--- Нажмите Enter для продолжения ---");
                    scanner.nextLine();
                    break;
                case 1 :
                    service.showAllBooks();
                    System.out.println("\n--- Нажмите Enter для продолжения ---");
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Введите название книги: ");
                    String bookTitle = scanner.nextLine();
                    Book foundBook = service.findBookByTitle(bookTitle);
                    System.out.println(foundBook);
                    System.out.println("\n--- Нажмите Enter для продолжения ---");
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Введите имя автора: ");
                    String authorFirstName1 = scanner.nextLine();
                    System.out.println("Введите фамилию автора: ");
                    String lastNameOfAuthor = scanner.nextLine();
                    List<Book> foundListOfBooks = service.findBooksByAuthor(authorFirstName1,lastNameOfAuthor);
                    if(foundListOfBooks.isEmpty()){
                        System.out.println("Книг с этим автором не найдено в библиотеке.");
                    }else{
                        System.out.println("Найдены следующие книги автора " + authorFirstName1 + " " + lastNameOfAuthor + ": ");
                        for(Book book : foundListOfBooks){
                            System.out.println(book);
                        }
                    }
                    System.out.println("\n--- Нажмите Enter для продолжения ---");
                    scanner.nextLine();
                    break;
                case 5:

                    service.showMyBorrowedBooks();


            }
        }
    }
}


