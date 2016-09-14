package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ArrayList;
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
public class AddressController {
  @Autowired AddressRepository repository;
  @Autowired UserRepository userRepository;

  private static final Logger log = LoggerFactory.getLogger(Application.class);
             
  @RequestMapping("/addresses")
  @ResponseBody
  public List<Address> index() {
    return repository.findAll();
  }

  @RequestMapping(value = "/user/{userId}/address", method = RequestMethod.POST)

  public boolean updateAddress(@PathVariable("userId") Long userId, @RequestBody Address address){
    if(userRepository.exists(userId)) {
      User user = userRepository.findOne(userId);
        address.setUserId(userId);
        List<Address> addresses = new ArrayList<Address>();
        //address = repository.save(address);
        addresses.add(address);
        user.setAddresses(addresses);
        user = userRepository.save(user);
        return true;
      }
      return false;
    }
  }

