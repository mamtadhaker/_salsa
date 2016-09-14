package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);

    List<User> findAll();

    User save(User user);

    void delete(User user);

    boolean exists(Long id);

    
}