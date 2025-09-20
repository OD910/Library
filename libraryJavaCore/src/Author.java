import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Author {

    private static final AtomicInteger counter = new AtomicInteger();

    private final Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Long getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public Author(Long id, String firstName, String lastName, LocalDate dateOfBirth){
        this.id = (long) counter.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
}
