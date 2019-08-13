package org.modelo.sregion;

public class Region_2 {
	private int id;
	private String nombre;
	
	////constructores////
	
	public Region_2()
	{
		
	}
	//Select * from region_2 where id = ?
	//Delete from Region_2 where id = ?
	
	public Region_2(int id)
	{
		this.id = id;
	}
	//Insert into region_2 values (?,?)
	public Region_2(int id,  String nombre)
	{
		this.id = id;
		this.nombre = nombre;
	}
	//update region_2 set name = ? where id = ?
	public Region_2(String nombre, int id)
	{
		this.nombre = nombre;
		this.id = id;
		
	}
	
	
	//get set	
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
	
}
