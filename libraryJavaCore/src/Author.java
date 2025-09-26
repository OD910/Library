import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Author implements Serializable {

    private static final AtomicInteger counter = new AtomicInteger();

    private static final long serialVersionUID = 1L;
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

    public Author(String firstName, String lastName, LocalDate dateOfBirth){
        this.id = (long) counter.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Author otherAuhtor = (Author) obj;
        if(this.firstName.equals(otherAuhtor.firstName)  && this.lastName.equals(otherAuhtor.lastName)){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString(){
        return getFirstName() + " " + getLastName();
    }
}
