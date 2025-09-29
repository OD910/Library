import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Reader implements Serializable {
//    private static final AtomicInteger counter = new AtomicInteger();

    private static final long serialVersionUID = 1L;
    private Long libraryCardId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate registrationDate;

    public Reader(Long libraryCardId, String firstName, String lastName, String email, String phoneNumber){
        this.libraryCardId = libraryCardId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registrationDate = LocalDate.now();
    }

    public Reader(){

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

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Reader otherReader = new Reader();
        return Objects.equals(this.libraryCardId, otherReader.libraryCardId);
    }

    @Override
    public int hashCode(){
        return Objects.hash(libraryCardId);
    }

    @Override
    public String toString(){
        return libraryCardId + " " + firstName + " " + lastName +
                " " + email + " " + phoneNumber + " " + registrationDate;
    }


}
