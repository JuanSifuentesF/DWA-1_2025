package pe.edu.cibertec.sesion01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.cibertec.sesion01.entity.Customer;
import pe.edu.cibertec.sesion01.repository.CustomerRepository;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class Sesion01Application implements CommandLineRunner {

  //Inyeccion de dependencias
  @Autowired
  CustomerRepository customerRepository;

  public static void main(String[] args) {
    SpringApplication.run(Sesion01Application.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    /*
    * findAll() <--- Pintando en consola todos los customers
    *
    List<Customer> customers = (List<Customer>) customerRepository.findAll();
    customers.forEach(System.out::println);
    */

    /*
    * save (S Entity) <--- Guardando un customer
    *
    Customer customer = new Customer(null, 1, "Cesar", "Santos", "cesar@gmail.com",1,1,new Date(),new Date());
    customerRepository.save(customer);
    */

    /*
    * findById() - orElse() <--- devuelve un null, en el caso falle
    *
    Optional<Customer> optional = customerRepository.findById(602);
    Customer customer = optional.orElse(null);
    System.out.println(customer);
    */

    /*
    * findById() - orElseGet() <--- Si no existe resultado, ejecuta una funcion lambda
    *
    Optional<Customer> optional = customerRepository.findById(602);
    Customer customer = optional.orElseGet(() -> {
      LocalDate today = LocalDate.now();
      System.out.println("Customer not found -> "+today);
      return null;
    });
    System.out.println(customer);
    */

    /*
    * findById() - orElseThrow() <--- Si no existe resultado, permite agregar un excepcion
    *
    Optional<Customer> optional = customerRepository.findById(602);
    Customer customer = optional.orElseThrow(IllegalArgumentException::new);
    System.out.println(customer);
    */

    /*
    * findById() - isPresent() <--- Si no existe resultado, permite usar programacion estructural (if - else)
    *
    Optional<Customer> optional = customerRepository.findById(602);
    if(optional.isPresent()) {
      Customer customer = optional.get();
    } else{
      System.out.println("Customer not found");
    }
    */

    /*
    * findById() - ifPresente() <--- Si no existe resultado, devuelve "nada" "void", sin return
    *
    Optional<Customer> optional = customerRepository.findById(602);
    optional.ifPresent((customer) -> {
      LocalDate today = LocalDate.now();
      System.out.println("Customer not found -> "+today);
    });
    */

    /*
    * findById() - ifPresenteElse() <--- Si no existe resultado, representa dos lambdas, uno cuando esta presente y otro cuando no esta presente
    *
    Optional<Customer> optional = customerRepository.findById(602);
    optional.ifPresentOrElse(
          (item) -> {
            System.out.println(item);
          },
          () -> {
            System.out.println("Customer not found");
          }
    );
    */

    /*
    * existsById <--- Si existe el id o no.
    *
    if(customerRepository.existsById(800)){
      System.out.println("Customer with id 600 already exists");
    } else {
      System.out.println("Customer with id 600 created");
    }
    */

    /*
    * findAll <--- Para usar el ITERABLE del objeto, esta pensando justamente para iterar los elementos. Su naturaleza es inmutable, la lectura es veloz y mejor rendimiento.
    *              Se tiene pensado mostrar la lista
    * */
    /*Iterable<Customer> iterable_customer =  customerRepository.findAll();


    // Conversion clasica
    List<Customer> listElements = (List<Customer>) iterable_customer;

    // Otras conversiones
    List<Customer> listElements2 = List.copyOf((Collection<Customer>)iterable_customer);
    */

    /*
    // Clasico - Se itera de forma clasica
    for (Customer customer : iterable_customer) {
      System.out.println(customer);
    }

    // No tan clasico - ForEach
    iterable_customer.forEach(System.out::println); //Que esta imprimiendo ? una funcion lambda

    // Desglozando <--- Aqui la funcion lambda
    iterable_customer.forEach((customer -> {
      System.out.println(customer);
    }));
    */

    /*
    * findAllById, pide un iterable de id's, sino encuentra, no retorna nada.
    *

    Iterable<Integer> ids = List.of(1,2,3,4,5); //Se va a buscar todos estos ids
    Iterable<Customer> iterable =  customerRepository.findAllById(ids);
    System.out.println(iterable);
    */

    /*
    * deleteById, eliminar por id
    *

    Integer id = 60;
    if(customerRepository.existsById(id)) {
      customerRepository.deleteById(id);
    } else{
      System.out.println("Customer with id " + id + " does not exist");
    }
    */

    /*
    * deleteAllById, para eliminar varios ids
    * */

    List<Integer> ids = List.of(600,601,602,603);

    /* Nos va a servir para reemplazar o sobreescribir de acuerdo a la condicion del filter*/
    // Manera tradicional
    ids.stream().filter(id -> customerRepository.existsById(id)).collect(Collectors.toList());

    if(!ids.isEmpty()) {
      customerRepository.deleteAllById(ids);
    } else {
      System.out.println("No se puede eliminar el cliente");
    }

    /*Concepto general para eliminar
    // Manera de validar de forma funcional, si existen, filtrar.
    ids.stream().filter(id -> customerRepository.existsById(id)).forEach(id -> {
      System.out.println(id);
    });*/

    /*Conepto general de stream y filter
    //.stream(), permite coger esa lista de elementos de memoria y representar como un flujo de datos. Se mantiene activos y luego se pueden filtrar.
    //.filter(), permite filtrar en el espacio definido por .stream(), su ventaja, se puede ingresar logica.
    ids.stream().filter(id -> id % 2 == 0).forEach(id -> {
      System.out.println(id);
    });*/


  }
}
