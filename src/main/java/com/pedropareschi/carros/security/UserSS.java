package com.pedropareschi.carros.security;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class UserSS implements UserDetails {

    private Long id;
    private String cpf;
    private String senha;
    private Collection<? extends GrantedAuthority> authorities;

    public Long getId() {
        return id;
    }

    public UserSS(Long id, String cpf, String senha) {
        this.id = id;
        this.cpf = cpf;
        this.senha = senha;
        Set<String> permissoes = new HashSet<>();
        permissoes.add("ROLE_CLIENTE");
        this.authorities = permissoes.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return cpf;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
