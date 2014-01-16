package models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Categoria extends Model {
	@Id
	private Long id;

	@Required
	private String nome;
	
	@OneToOne(mappedBy="categoria")
	private GerenteCompra gerenteCompra;
	
	@OneToMany(mappedBy="categoria")
	private List<Produto> produtos;

	private static Finder<Long, Categoria> find = new Finder<Long, Categoria>(
			Long.class, Categoria.class);

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public GerenteCompra getGerenteCompra() {
		return gerenteCompra;
	}

	public void setGerenteCompra(GerenteCompra gerenteCompra) {
		this.gerenteCompra = gerenteCompra;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	// Buscando os valores
	public static Map<String, String> categorias() {
		LinkedHashMap<String, String> vals = new LinkedHashMap<String, String>();

		for (Categoria categoria : find.all()) {
			vals.put(categoria.getId().toString(), categoria.getNome());
		}
		return vals;

	}
	
	public static List<Categoria> findAll()
	{
		return find.all();
	}
	
	public static Categoria findById(Long id)
	{
		return find.byId(id);
	}

}
