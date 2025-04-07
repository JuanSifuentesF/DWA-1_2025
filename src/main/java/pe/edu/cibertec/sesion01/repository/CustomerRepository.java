package pe.edu.cibertec.sesion01.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.sesion01.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
