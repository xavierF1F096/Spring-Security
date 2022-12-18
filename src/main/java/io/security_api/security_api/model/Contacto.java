package io.security_api.security_api.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity(name = "contacto")
@Data
public class Contacto {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idContacto")
    private Long id;
    private String nombre;
    @Column(name = "fechaNacimiento")
    private LocalDate fechaNacimiento;
    private String celular;
    private String email;
}
