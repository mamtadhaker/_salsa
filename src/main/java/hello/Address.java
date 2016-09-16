package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "addresses")
public class Address {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String street;
  private String city;
  private String state;
  private String country;
  
  @ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
 	private User user;

  protected Address() {}

  public Long getId() {
    return this.id;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getStreet() {
    return this.street;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCity() {
    return this.city;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getState() {
    return this.state;
  }

  public void setCountry(String country) {
    this.country = country;
  }
 
  public String getCountry() {
    return this.country;
  }

  public void setUser(User user) {
    this.user = user;
  }

  // public User getUser() {
  //   return this.user;
  // }

  @Override
  public String toString() {
  return String.format(
                " Address[id = %d, street = '%s', city = '%s', state = '%s', country = '%s']",
                id, street, city, state, country);
    }

 }