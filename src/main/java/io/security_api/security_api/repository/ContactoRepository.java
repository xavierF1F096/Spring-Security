package io.security_api.security_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.security_api.security_api.model.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto,Long>{
    
}
