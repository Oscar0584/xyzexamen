package com.xyz.Servicio;

import java.util.List;

import com.xyz.Dominio.Usuario;





public interface Metodos {

	public void guardar(Usuario cliente);
	public void editar(Usuario cliente);
	public void eliminar(Usuario cliente);
	public Usuario buscar(Usuario cliente);
	public List<Usuario> listar();
}
