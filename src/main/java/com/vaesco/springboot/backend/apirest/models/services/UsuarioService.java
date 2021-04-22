package com.vaesco.springboot.backend.apirest.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.vaesco.springboot.backend.apirest.models.dao.IUsuarioDao;
import com.vaesco.springboot.backend.apirest.models.entity.Usuario;

public class UsuarioService implements UserDetailsService {

	@Autowired
	private IUsuarioDao usuarioDao;
	
	
	private static final Logger log = LoggerFactory.getLogger(UsuarioService.class);


	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioDao.findByUsername(username);
		
		if(usuario == null) {
			log.error("Error en el login: no existe el usuario "+usuario+" en el sistema");
			throw new UsernameNotFoundException("Error en el login: no existe el usuario "+usuario+" en el sistema");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
													.stream()
													.map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
													.peek(authority -> log.info("Rol: ".concat(authority.getAuthority())))
													.collect(Collectors.toList());
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, authorities);
	}

}
