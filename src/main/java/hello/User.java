package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses;

    protected User() {}

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Address> getAddresses() {
        return this.addresses;
    }

    public void setAddresses(List<Address> addresses) {
         this.addresses = addresses;
    }

    @Override
    public String toString() {
        // if(this.getAddresses() != null){
        //     return "\n User:[id: "+id+" firstName: "+firstName+" lastName: "+lastName+" address: "+addresses;
        // }
        // else {
        //     return "\n User:[id: "+id+" firstName: "+firstName+" lastName: "+lastName;
        // }
        return String.format(
                "Customer[id: %d, firstName: '%s', lastName: '%s']",
                id, firstName, lastName);
    }

}