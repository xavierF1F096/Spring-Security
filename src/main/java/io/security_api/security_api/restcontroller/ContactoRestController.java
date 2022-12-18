package io.security_api.security_api.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.security_api.security_api.model.Contacto;
import io.security_api.security_api.repository.ContactoRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/v1/")
@RequiredArgsConstructor
public class ContactoRestController {
    @Autowired
    private final ContactoRepository contactoRepository;
    @GetMapping("contactos")
    public List<Contacto>listContacto(){return contactoRepository.findAll();}
    
}
