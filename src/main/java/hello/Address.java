package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Address {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String street;
  private String city;
  private String state;
  private String country;
  @ManyToOne
	@JoinColumn(name="userId", nullable=false)
 	private Long userId;

  protected Address() {}

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

  public void setUserId(Long userId) {
    this.userId = userId;
  }

   public Long getUserId() {
    return this.userId;
  }

  @Override
  public String toString() {
  return String.format(
                " Address[id = %d, street = '%s', city = '%s', state = '%s', country = '%s']",
                id, street, city, state, country);
    }

 }