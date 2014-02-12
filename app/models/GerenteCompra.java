package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class GerenteCompra extends Usuario{

	@OneToOne
	private Categoria categoria;

	
	@OneToOne
	private Campus campus;
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public String getCategoriaString() {
		return categoria.getNome();
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public static Finder<Long, GerenteCompra> find = new Finder<Long, GerenteCompra>(
			Long.class, GerenteCompra.class);

	
	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}	
	
	public static List<GerenteCompra> findAll()
	{
		return find.all();
	}
	
	public static GerenteCompra findById(Long id)
	{
		return find.byId(id);
	}
	public static  GerenteCompra retrive (String email, String senha)
	{
		return find.where().eq("email", email).eq("senha",senha).findUnique();
	}

}

