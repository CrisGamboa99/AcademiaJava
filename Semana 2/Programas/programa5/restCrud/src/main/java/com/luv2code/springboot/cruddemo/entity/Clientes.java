package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="clientes") // Se cambia el nombre de la tabla por clientes
public class Clientes { // Se cambia el nombre de la clase

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre") // Se cambian los nombres de los campos y las variables correspondientes
    private String nombre;

    @Column(name="apellido")
    private String apellido;
    
    @Column(name="edad") // Se añade un nuevo campo de edad
    private int edad;

    @Column(name="correo")
    private String correo;


    // define constructors
    // Se cambia el nombre de los constructores para concordar con el de la clase
    public Clientes() { 

    }

    // Se cambian las variables del constructor
    public Clientes(String nombre, String apellido, int edad, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad; // Se añade la variable edad al constructor
        this.correo = correo;
    }

    // define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    // Se cambian los getters y setters para concordar con las variables
    public String getNombre() {
        return nombre;
    }

    public void setNombres(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() { // Se añade get de edad
		return edad;
	}

	public void setEdad(int edad) { // Se añade set de edad
		this.edad = edad;
	}

	public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // define toString
    // También se cambia para concordar con las variables
    @Override
    public String toString() {
        return "Clientes{" +
                "id=" + id +
                ", nombres='" + nombre + '\'' +
                ", apellidos='" + apellido + '\'' +
                ", edad='" + edad + '\'' + // Se añade edad
                ", correo='" + correo + '\'' +
                '}';
    }
}








