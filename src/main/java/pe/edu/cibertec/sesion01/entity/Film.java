package pe.edu.cibertec.sesion01.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Film {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer filmId;
  private String title;
  private String description;
  private Integer releaseYear;
  private Integer languageId;
  private Integer originalLanguageId;
  private Integer rentalDuration;
  private Double rentalRate;
  private Integer length;
  private Double replacementCost;
  private String rating;
  private String specialFeatures;
  private Date lastUpdate;
}
