package com.vaesco.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vaesco.springboot.backend.apirest.models.entity.Cliente;
import com.vaesco.springboot.backend.apirest.models.services.IClienteService;

@CrossOrigin(origins = { "http://localhost:4200" }) // Solo puede realizar peticiones http://localhost:4200 "Angular"
@RestController
@RequestMapping("/api/v1")
public class ClienteRestController {
	
	
	private static final Logger log = LoggerFactory.getLogger(ClienteRestController.class);


	@Autowired
	private IClienteService clienteService;

	@GetMapping("/clientes")
	@ResponseStatus(code = HttpStatus.OK) // valor por defecto, no se requiere anotar
	public List<Cliente> index() {
		return (List<Cliente>) clienteService.findAll();
	}
	
	@GetMapping("/busquedas/clientes/{pagina}")
	public Page<Cliente> indexBusquedas(@PathVariable Integer pagina) {
		return clienteService.findAll(PageRequest.of(pagina, 3));
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Cliente cliente = null;

		Map<String, Object> respose = new HashMap<>();

		try {
			cliente = clienteService.findById(id);

		} catch (DataAccessException e) {
			respose.put("mensaje", "Error de conexion con la base de datos");
			respose.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));

			return new ResponseEntity<Map<String, Object>>(respose, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (cliente == null) {
			respose.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" no existe en la base de datos")));

			return new ResponseEntity<Map<String, Object>>(respose, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

	@PostMapping("/clientes")
	public ResponseEntity<?> create(@Validated @RequestBody Cliente cliente, BindingResult result) {

		Cliente clienteNew = null;
		Map<String, Object> respose = new HashMap<>();
		
		log.info(result.hasErrors()+"");
		if (result.hasErrors()) {
			
			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "El campo '".concat(err.getField()).concat("' ").concat(err.getDefaultMessage());
			}).collect(Collectors.toList());

			
			respose.put("error", errors);
			return new ResponseEntity<Map<String, Object>>(respose, HttpStatus.BAD_REQUEST);
		}

		try {
			clienteNew = clienteService.save(cliente);
		} catch (DataAccessException e) {
			respose.put("mensaje", "Error al realizar el insert en la base de datos");
			respose.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respose, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respose.put("mensaje", "El cliente ha sido creado con éxito");
		respose.put("cliente", clienteNew);
		return new ResponseEntity<Map<String, Object>>(respose, HttpStatus.CREATED);
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@Validated @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id) {

		Cliente clienteActual = clienteService.findById(id);
		Cliente clienteUpdate = null;
		Map<String, Object> respose = new HashMap<>();
		
	

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream().map(err -> {
				return "El campo '".concat(err.getField()).concat("' ").concat(err.getDefaultMessage());
			}).collect(Collectors.toList());

			respose.put("error", errors);
			return new ResponseEntity<Map<String, Object>>(respose, HttpStatus.BAD_REQUEST);
		}

		if (clienteActual == null) {
			respose.put("mensaje",
					"El cliente ID: ".concat(id.toString().concat(" no se puede editar en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(respose, HttpStatus.NOT_FOUND);
		}

		try {
			clienteActual.setNombre(cliente.getNombre());
			clienteActual.setApellido(cliente.getApellido());
			clienteActual.setEmail(cliente.getEmail());
			clienteActual.setCreateAt(cliente.getCreateAt());

			clienteUpdate = clienteService.save(clienteActual);

		} catch (DataAccessException e) {
			respose.put("mensaje", "Error al realizar el insert en la base de datos");
			respose.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respose, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		respose.put("mensaje", "El cliente ha sido actualizado con éxito");
		respose.put("cliente", clienteUpdate);

		return new ResponseEntity<Map<String, Object>>(respose, HttpStatus.OK);
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> respose = new HashMap<>();
		try {
			clienteService.delete(id);
		} catch (DataAccessException e) {
			respose.put("mensaje", "Error al eliminar el cliente en la base de datos");
			respose.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(respose, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		respose.put("mensaje", "Cliente eliminado con éxito");

		return new ResponseEntity<Map<String, Object>>(respose, HttpStatus.OK);
	}
}
