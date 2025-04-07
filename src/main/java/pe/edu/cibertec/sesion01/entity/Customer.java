package pe.edu.cibertec.sesion01.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@Table(name = "customer") <-- ya no es necesario
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer customer_id;
  private Integer store_id;
  private String first_name;
  private String last_name;
  private String email;
  private Integer address_id;
  private Integer active;
  private Date create_date;
  private Date last_update;

}
