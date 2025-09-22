import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class Reader {
    private static final AtomicInteger counter = new AtomicInteger();

    private final Long libraryCardId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate registrationDate;

    public Reader(Long libraryCardId, String firstName, String lastName, String email, String phoneNumber, LocalDate registrationDate){
        this.libraryCardId = (long) counter.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
    }

    public Long getLibraryCardId(){
        return libraryCardId;
    }
    public String getFirstName(){
        return  firstName;
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
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public LocalDate getRegistrationDate(){
        return registrationDate;
    }
    public void setRegistrationDate(LocalDate registrationDate){
        this.registrationDate = registrationDate;
    }


}
