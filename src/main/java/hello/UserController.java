package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired UserRepository repository;
  
  private static final Logger log = LoggerFactory.getLogger(Application.class);
             
  @RequestMapping
  @ResponseBody
  public List<User> index() {
     List<User> users = repository.findAll();
    // return users.toString();
    return users;
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public User create(@RequestBody User user) {
    	log.info("User :");
			log.info("--------------------------------");
			log.info(user.toString());
    	log.info("Address :");
			log.info("--------------------------------");
			log.info(user.getAddresses().toString());
  
    //List<Address> address = addressRepository.save(user.getAddress());
    user = repository.save(user);
    // address.setUserId(user.getId());
    // addressRepository.save(address);
    return user;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public User update(@PathVariable("id") Long id, @RequestBody User user) {
    if(repository.exists(id)) {
      repository.save(user);
    }
    return user;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public boolean delete(@PathVariable("id") Long id) {
     if(repository.exists(id)) {
      User user = repository.findOne(id);
      repository.delete(user);
    }
    return true;
  }

}