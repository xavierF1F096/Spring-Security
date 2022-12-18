package io.security_api.security_api.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.security_api.security_api.model.Usuario;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class UserDetailsImpl implements UserDetails{

     private final Usuario usuario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return usuario.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true ;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    //metod extra que no viene de la interface UserDetail
    public String getNombre(){
        return usuario.getNombre();
    }
    
}
