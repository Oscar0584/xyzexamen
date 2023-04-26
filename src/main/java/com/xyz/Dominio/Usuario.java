package com.xyz.Dominio;



import jakarta.persistence.Column;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class Usuario implements Comparable<Usuario> {
	

	@Id
	@Column(name = "ID", columnDefinition = "number")
	int id;

	@Column(name = "NOMBRE", columnDefinition = "NVARCHAR2(50)")
	String nombre;

	@Column(name = "APP", columnDefinition = "NVARCHAR2(50)")
	String app;

	@Column(name = "APM", columnDefinition = "NVARCHAR2(50)")
	String apm;

	@Column(name = "EDAD", columnDefinition = "number")
	int edad;

	@Column(name = "STATUS", columnDefinition = "NVARCHAR2(50)")
	String status;

	@Column(name = "FECHA_ENT", columnDefinition = "number")
	double fecha_ent;

	@Column(name = "FECHA_SAL", columnDefinition = "number")
	double fecha_sal;

	public Usuario() {

	}

	public Usuario(int id) {

		this.id = id;
	}
	
	public Usuario(double fecha_ent) {
		
		this.fecha_ent = fecha_ent;
	}

	

	

	public Usuario(int id, String nombre, String app, String apm, int edad, String status, double fecha_ent,
			double fecha_sal) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.app = app;
		this.apm = apm;
		this.edad = edad;
		this.status = status;
		this.fecha_ent = fecha_ent;
		this.fecha_sal = fecha_sal;
	}

	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", app=" + app + ", apm=" + apm + ", edad=" + edad
				+ ", status=" + status + ", fecha_ent=" + fecha_ent + ", fecha_sal=" + fecha_sal + "]";
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getApm() {
		return apm;
	}

	public void setApm(String apm) {
		this.apm = apm;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getFecha_ent() {
		return fecha_ent;
	}

	public void setFecha_ent(double fecha_ent) {
		this.fecha_ent = fecha_ent;
	}

	public double getFecha_sal() {
		return fecha_sal;
	}

	public void setFecha_sal(double fecha_sal) {
		this.fecha_sal = fecha_sal;
	}

	@Override
	public int compareTo(Usuario o) {
		// TODO Auto-generated method stub
		return o.getId() - this.getId();
	}

}
