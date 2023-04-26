package com.xyz.Controller;

import java.util.Collections;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyz.Dao.MetodosDao;
import com.xyz.Dominio.Usuario;
import com.xyz.Servicio.Implementacion;


@RestController
@RequestMapping(path = "WebService")
@CrossOrigin("*")
public class WebService {

	@Autowired
	Implementacion imp;

	// http://localhost:9006/WebService/listar
	@GetMapping(path = "listar")
	public List<Usuario> listar() {
		List<Usuario> lista = imp.listar();
		Collections.sort(lista);
		return lista;
	}

	// http://localhost:9006/WebService/guardar
	@PostMapping(path = "guardar")
	public ResponseEntity<String> guardar(@RequestBody Usuario cliente) {
		imp.guardar(cliente);

		return new ResponseEntity<String>("Se guardo el cliente: " + cliente.getApp(), HttpStatus.OK);
	}

	// http://localhost:9006/WebService/editar
	@PostMapping(path = "editar")
	public ResponseEntity<String> editar(@RequestBody Usuario cliente) {
		imp.editar(cliente);

		return new ResponseEntity<String>("Se edito el cliente: " + cliente.getApp(), HttpStatus.OK);
	}

	// http://localhost:9006/WebService/eliminar
	@PostMapping(path = "eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Usuario cliente) {
		imp.eliminar(cliente);

		return new ResponseEntity<String>("Se elimino el cliente: " + cliente.getApp(), HttpStatus.OK);
	}

	// http://localhost:9006/WebService/buscar
	@PostMapping(path = "buscar")
	public Usuario buscar(@RequestBody Usuario cliente) {
		cliente = imp.buscar(cliente);

		return cliente;
	}
	
	@Autowired
	MetodosDao dao;
	// http://localhost:9006/WebService/pagar
	@PostMapping(path="pagar")
	public  ResponseEntity<String> pagar(@RequestBody Usuario cliente) {
		
		List<Usuario> lista = imp.listar();
		
		Usuario c1 = null;
		double resultado = 0;
		double pago = 0;
		for(Usuario c : lista) {
			if (c.getId() == cliente.getId()) {
				c1 = c;
				pago = (c.getFecha_ent() + cliente.getFecha_ent()); 
				break;
			}
		}
		
		
		
		resultado = (c1.getFecha_sal() - pago);
		
		c1.setFecha_ent(pago);
		c1.setFecha_sal(resultado);
		
		imp.editar(c1);
		
		return new ResponseEntity<String>("el cliente abono: " + pago + " Resta tanto: " + resultado, HttpStatus.OK);
	}
	
	
}