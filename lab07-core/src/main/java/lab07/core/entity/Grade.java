package lab07.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@JsonIgnoreProperties({"student"})//leave it like this, it will help the JSON serialization
public class Grade extends GenericEntity{

  //TODO add the fields and JPA annotations
}
