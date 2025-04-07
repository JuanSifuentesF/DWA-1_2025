package pe.edu.cibertec.sesion01.repository;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.sesion01.entity.Film;



public interface FilmRepository extends CrudRepository<Film, Integer> {

  /**/
  @Cacheable(value = "films")
  Iterable<Film> findAll();

  @CacheEvict(value = "films", allEntries = true) //Tiene la funcionalidad de actualizar la consulta
  Film save(Film film);


}
