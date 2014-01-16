package controllers;

import java.util.List;

import models.Categoria;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.CadastrarCategoria;
import views.html.indexCategoria;

public class ControleCategoria extends Controller{

	public static Result index() {
		
		List<Categoria> categorias = Categoria.findAll();
		
        return ok(indexCategoria.render(categorias));
    }
	
	public static Result indexCadastrar() {
        return ok(CadastrarCategoria.render(new Categoria()));
    }
	
	
	public static Result salvar()
	{
	
		Categoria categoria = Form.form(Categoria.class).bindFromRequest().get();
		//Verificando se a categoria existe. 
		//Caso o ID seja diferente de zero significa que estou editando um dado.
		if (categoria.getId()!= null)
		{
			flash("success","Atualizada");
			categoria.update();
		}	
		else{
			categoria.save();
			flash("success","Categoria Criada");
		}
			
		
		return redirect (routes.ControleCategoria.index());
	}
	
	public static Result editar(Long id)
	{
		Categoria categoria = Categoria.findById(id);
		
		return ok(CadastrarCategoria.render(categoria));
	}
	
	public static Result excluir(Long id)
	{
		Categoria categoria = Categoria.findById(id);
		
		categoria.delete();
		
		return redirect (routes.ControleCategoria.index());
	}

}
