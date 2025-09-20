import java.time.LocalDate;

public class BorrowingRecord {
    private Long id;
    private Book book;
    private Reader reader;
    private LocalDate dueDate;
    private LocalDate returnDate;
}
