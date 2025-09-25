import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private static final String DB_BOOKS = "books.db";
    private static final String DB_AUTHORS = "authors.db";
    public LibraryService(){

    }

    public static void saveAuthors(List<Author> authors) throws IOException{
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DB_AUTHORS))){
            oos.writeObject(authors);
        } catch (IOException r){
            System.out.println("Возникла ошибка :" + r.getMessage());
        }
    }

    public static List<Author> loadAuthors() throws IOException, ClassNotFoundException{
        File file = new File(DB_AUTHORS);
        if(!file.exists()) return new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            return(List<Author>) ois.readObject();
        }
    }

    public static void saveBooks(List<Book> books) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DB_BOOKS))) {
            oos.writeObject(books);
        } catch (IOException r){
            System.out.println("Возникла ошибка :" + r.getMessage());
        }
    }

    public static List<Book> loadBooks() throws IOException, ClassNotFoundException{
        File file = new File(DB_BOOKS);
        if(!file.exists()) return new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            return (List<Book>) ois.readObject();
        }
    }



    public void addNewBook(String title, int publicationYear, Genre genre, int totalCopies, int availableCopies) throws IOException, ClassNotFoundException{
        //сюда надо сделать метод который открывает файл с уже созданными авторами и чекает есть ли такой автор
        // если такой есть то он просто вызвает метод который берет этого автора
        // и мы просто вставляем в поле author у новой книги автора с нашего файла
        // а если такого нет мы вызываем метод который создает такого автора и его же вставляем в наше поле объекта book.
        //
        ArrayList<Book> books = new ArrayList<>(loadBooks());
        ArrayList<Author> authors = new ArrayList<>(loadAuthors());

        for(int i = 0; i < authors.size(); i++){
            if(authors.get(i) == )
        }

        Book newBook = new Book(title, author, publicationYear, genre, totalCopies, availableCopies);

        for(int i = 0; i < books.size(); i++){
            if(books.get(i) == newBook){
                System.out.println("Такая книга уже есть в базе");
            } else{
                books.add(newBook);
                saveBooks(books);
            }
        }


    }

}
