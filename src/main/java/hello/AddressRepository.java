package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

    List<Address> findAll();

    Address findOne(Long id);

    Address save(Address address);

    void delete(Address address);

    boolean exists(Long id);
    
}