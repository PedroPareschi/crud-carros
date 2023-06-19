package com.pedropareschi.carros.service;

import com.pedropareschi.carros.entity.Cliente;
import com.pedropareschi.carros.repository.ClienteRepository;
import com.pedropareschi.carros.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("CPF não encontrado"));
        return new UserSS(cliente.getId(), cliente.getCpf(), cliente.getSenha());
    }
}
