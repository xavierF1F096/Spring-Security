package io.security_api.security_api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.security_api.security_api.model.Usuario;
import io.security_api.security_api.repository.UsuarioRepository;
@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Usuario usuario=usuarioRepository.findOneByEmail(email).orElseThrow(() -> new UsernameNotFoundException("El usuario con email {} no existe"+email)); 
       
        return new UserDetailsImpl(usuario);                  
    }
}
