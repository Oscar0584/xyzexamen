package com.xyz.Servicio;

import java.util.List;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyz.Dao.MetodosDao;
import com.xyz.Dominio.Usuario;



@Service
public class Implementacion implements Metodos {
	@Autowired
	MetodosDao dao;

	@Override
	public void guardar(Usuario cliente) {
		List <Usuario> lista = (List<Usuario>) dao.findAll();
		
		if(lista.isEmpty()) {
			dao.save(cliente);
		}else {
			for (Usuario c : lista) {
				if(c.getApp().equals(cliente.getApp())) {
					System.out.println("El cliente ya esxiste");
				}else {
					dao.save(cliente);
				}
			}
		}
	}
	
	

	@Override
	public void editar(Usuario cliente) {
		dao.save(cliente);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Usuario cliente) {
		dao.delete(cliente);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario buscar(Usuario cliente) {
		Usuario cli = dao.findById(cliente.getId()).orElse(null);
		return cli;
	}

	@Override
	public List<Usuario> listar() {
		List <Usuario> lista = new ArrayList<Usuario>();
		lista = (List<Usuario>) dao.findAll(); 
		return lista;
	}


	
	
}
