import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryService {
    private List<Book> books;
    private List<Author> authors;
    private List<Reader> readers;
    private List<BorrowingRecord> borrowingRecords;
    private long nextBookId =1;
    private long nextReaderId = 1;
    private long nextAuthorId = 1;

    private static final String LIBRARY_DB = "libraryJavaCore/data/library.db";


    private void saveData() {
        LibraryData libraryData = new LibraryData(this.books, this.authors, this.readers, this.borrowingRecords);
        libraryData.setNextAuthorId(this.nextAuthorId);
        libraryData.setNextBookId(this.nextBookId);
        libraryData.setNextReaderId(this.nextReaderId);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(LIBRARY_DB))) {
            oos.writeObject(libraryData);
        } catch (IOException r) {
            System.out.println("Возникла ошибка :" + r.getMessage()); //шш негров зарежу
        }
    }

    private LibraryData loadData() throws IOException, ClassNotFoundException{
        File file = new File(LIBRARY_DB);
        if(!file.exists()) return new LibraryData();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            return (LibraryData) ois.readObject();
        }
    }

    public LibraryService() throws IOException, ClassNotFoundException {
        try{
            LibraryData data = loadData();
            System.out.println("Библиотека загружает данные из бд...");
            this.books = data.getBooks();
            this.authors = data.getAuthors();
            this.readers = data.getReaders();
            this.borrowingRecords = data.getBorrowingRecords();
            this.nextBookId = data.getNextBookId();
            if(this.nextBookId == 0){
                this.nextBookId = 1;
            }
            this.nextReaderId = data.getNextReaderId();
            if(this.nextReaderId == 0){
                this.nextReaderId = 1;
            }
            this.nextAuthorId = data.getNextAuthorId();
            if(this.nextAuthorId == 0){
                this.nextAuthorId = 1;
            }
        } catch(IOException | ClassNotFoundException e){
            System.out.println("Возникла ошибка с получением данных из бд: " + e.getMessage());
            this.books = new ArrayList<>();
            this.borrowingRecords = new ArrayList<>();
            this.authors = new ArrayList<>();
            this.readers = new ArrayList<>();
        }
//        catch(IOException e){
//            System.out.println("Возникла ошибка с получением данных: " + e.getMessage());
//        }
//        catch (ClassNotFoundException e){
//            System.out.println("Возникла ошибка с обработкой классов: " + e.getMessage());
//        }
    }

    public void addNewBook(String title, String authorFirstName, String authorLastName, LocalDate authorDateOfBirth,
                           int publicationYear, Genre genre, int totalCopies, int availableCopies){
//        System.out.println("Добавление новой книги");
//        Author author = findOrCreateAuthor(authorFirstName, authorLastName, authorDateOfBirth);
//        System.out.println("Поиск уже существующего автора");
        Author author = findAuthor(authorFirstName, authorLastName);
        if(author == null){
            author = createNewAuthor(authorFirstName, authorLastName, authorDateOfBirth);
        }
        boolean exists= false;
        for(int i = 0; i < this.books.size(); i++) {
            if(this.books.get(i).getTitle().equals(title)) {
                exists = true;
                System.out.println("Такая книга уже есть в базе");
                break;
            }
        }
        if(!exists) {
            Book newBook = new Book(nextBookId++, title, author, publicationYear, genre, totalCopies, availableCopies);
            this.books.add(newBook);
            saveData();
            System.out.println("Книга добавлена");
        }
    }

//    public Author findOrCreateAuthor(String firstName, String lastName, LocalDate dateOfBirth){
//        for(int i = 0; i < this.authors.size(); i++){
//            if(this.authors.get(i).getFirstName().equals(firstName) && this.authors.get(i)
//                    .getLastName().equals(lastName)) {
//                System.out.println("Такой автор уже есть в базе ");
//                return authors.get(i);
//            }
//            }
//        System.out.println("Такого автора нет в базе, добавление нового ");
//        Author author = new Author(firstName, lastName, dateOfBirth);
//        this.authors.add(author);
//        return author;
//        }

    public void showAllBooks(){
        for(Book book : this.books){
            System.out.println(book.toString());
        }
     }

     // создаем метод для поиска книги по тайтлу
     // мы вставляем в параметр тайтл, а метод находит по этому тайтлу
    // открывает список и проходит по нему если есть подходящий то возвращает его

    public Book findBookByTitle(String title){
        //Book newBook = new Book();
        for(int i = 0; i < this.books.size(); i++){
            if(this.books.get(i).getTitle().equalsIgnoreCase(title)){
                System.out.println("Книга по вашему запросу найдена: " + this.books.get(i).toString());
                return this.books.get(i);
            }
        }
        System.out.println("Такой книги нет в базе");
        return null;
    }

    public Book findBookById(Long bookId){
        for(Book book : this.books){
            if(Objects.equals(book.getId(), bookId)){
                return book;
            }
        }
        return null;
    }

    public List<Book> findBooksByAuthor(String authorFirstName, String authorLastName){
        Author author = findAuthor(authorFirstName, authorLastName);
        List<Book> newListBooks = new ArrayList<>();
        if(author != null){
            for(Book book : this.books){
                if(book.getAuthor().equals(author)) {
                    newListBooks.add(book);
                }
            }
        }
//        if(newListBooks.isEmpty()){
//            System.out.println("Книг с таким автором нет в базе");
//            return null;
//        }
        return newListBooks;
    }
    // TODO: разеделить метод findOrCreateAuthor() на два метода findAuthor() и createAuthor() ,
    //  для того чтобы я мог переиспользовать эти методы.

    public Author findAuthor(String firstName, String lastName){
        for(Author author : this.authors){
            if(author.getFirstName().equalsIgnoreCase(firstName) && author.getLastName().equalsIgnoreCase(lastName)){
                return author;
            }
        }
        return null;
    }

    public Author createNewAuthor(String firstName, String lastName, LocalDate dateOfBirth){
        Author newAuthor = new Author(nextAuthorId++,firstName, lastName,dateOfBirth);
        this.authors.add(newAuthor);
        return newAuthor;
    }

    public Reader findReaderById(Long id){
        for(Reader reader : this.readers){
            if(reader.getLibraryCardId().equals(id)){
                return reader;
            }
        }
        return null;
    }

    public void addNewReader(String firstName, String lastName, String email, String phoneNumber){
        boolean exists = false;
        for(Reader reader : this.readers){
            if(reader.getEmail().equalsIgnoreCase(email)){
                exists = true;
                break; //завершаем цикл потому что уже есть такой чувак, а в мейне сами напишем что такой чел есть
            }
        }
        if(!exists){
            Reader newReader = new Reader(nextReaderId++, firstName, lastName, email, phoneNumber);
            this.readers.add(newReader);
            saveData();
        }
    }

    public void showAllReaders(){
        for(Reader reader : this.readers){
            System.out.println(reader.toString());
        }
    }

    public void borrowBook(Long bookId, Long readerId){
        Reader reader = findReaderById(readerId);
        if(reader == null){
            System.out.println("Читатель с таким id не найден");
            return;
        }
        Book book = findBookById(bookId);
        if(book == null){
            System.out.println("Книги с таким id не найден");
            return;
        }
        for(BorrowingRecord result : this.borrowingRecords){
            if(result.getBook().equals(book) && result.getReader().equals(reader) && result.getReturnDate() == null){
                System.out.println("Читателю уже выдана эта книга");
                return;
            }
        }

        if(book.getAvailableCopies() <= 0 ){
            System.out.println("Все экземпляры этой книги на руках");
            return;
        }


        book.setAvailableCopies(book.getAvailableCopies() - 1 );
        BorrowingRecord br = new BorrowingRecord(book, reader, LocalDate.now().plusDays(14));
        this.borrowingRecords.add(br);
        System.out.println("Книга [" + book.getTitle() + "] успешна выдана читателю [" + reader.getFirstName() + "] ");
        saveData();

    }

//    public BorrowingRecord getBorrowingRecordByBookId(Long bookId){
//        for(BorrowingRecord record : this.borrowingRecords){
//            if(record.getBook().getId().equals(bookId)){
//                return record;
//            }
//        }
//        return null;
//    }

    public void returnBook(Long bookId){
        Book book = findBookById(bookId);
        BorrowingRecord activeRecord = null;
        if(book == null){
            System.out.println("Книги с таким id не найден");
            return;
        }
        for(BorrowingRecord br : this.borrowingRecords){
            if(br.getBook().getId().equals(bookId) && br.getReturnDate() == null){
                activeRecord = br;
                System.out.println("Запись найдена");
                break;
            }
        }
        if(activeRecord == null){
            System.out.println("Такая книга не числится в выдаче");
            return;
        }
        activeRecord.setReturnDate(LocalDate.now());
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        System.out.println("Книга [" + book.getTitle() + "] успешно возвращена");
        saveData();


    }

    public void showBorrowingRecords(){
        for(BorrowingRecord br : this.borrowingRecords){
            System.out.println(br.toString());
        }
    }




}




    // TODO: сделать методы addNewReader(), findReaderById(), showAllReaders(), borrowBook(), returnBook()




//    public static void saveBooks(List<Book> books) throws IOException {
//        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DB_BOOKS))) {
//            oos.writeObject(books);
//        } catch (IOException r){
//            System.out.println("Возникла ошибка :" + r.getMessage());
//        }
//    }

//    public void addNewBook(String title, int publicationYear, Genre genre, int totalCopies, int availableCopies) throws IOException, ClassNotFoundException{
//        //сюда надо сделать метод который открывает файл с уже созданными авторами и чекает есть ли такой автор
//        // если такой есть то он просто вызвает метод который берет этого автора
//        // и мы просто вставляем в поле author у новой книги автора с нашего файла
//        // а если такого нет мы вызываем метод который создает такого автора и его же вставляем в наше поле объекта book.
//        //
//        ArrayList<Book> books = new ArrayList<>(loadBooks());
//        ArrayList<Author> authors = new ArrayList<>(loadAuthors());
//
//        for(int i = 0; i < authors.size(); i++){
//            if(authors.get(i) == )
//        }
//
//        Book newBook = new Book(title, author, publicationYear, genre, totalCopies, availableCopies);
//
//        for(int i = 0; i < books.size(); i++){
//            if(books.get(i) == newBook){
//                System.out.println("Такая книга уже есть в базе");
//            } else{
//                books.add(newBook);
//                saveBooks(books);
//            }
//        }
//
//
//    }


