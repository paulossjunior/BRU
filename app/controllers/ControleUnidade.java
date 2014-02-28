package controllers;

import java.util.List;

import models.Unidade;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.CadastrarUnidade;
import views.html.indexUnidade;


public class ControleUnidade extends Controller {
	
	private static final Form<Unidade> unidadeForm = Form.form(Unidade.class);
	
	public static Result index(){
		
		List<Unidade> unidades = Unidade.findAll();
		
		return ok(indexUnidade.render(unidades));
	}
	public static Result indexCadastrar(){
		return ok(CadastrarUnidade.render(unidadeForm));
	}
	public static Result salvar()
	{
	
		Unidade unidade = Form.form(Unidade.class).bindFromRequest().get();
		if (unidade.getId() != null) {
			flash("success", "Unidade Atualizada");
			unidade.update();
		} else {
			unidade.save();
			flash("success", "Unidade Criada");
		}
		
		return redirect (routes.ControleUnidade.index());
	}
	
	public static Result editar(Long id)
	{
		Unidade unidade= Unidade.findById(id);
		
		//preenchendo o formulario com os dados do objeto
		Form<Unidade> unidadeEditarForm = unidadeForm.fill(unidade);
		    
		return ok(CadastrarUnidade.render(unidadeEditarForm));
	}
	
	public static Result excluir(Long id)
	{
		Unidade unidade = Unidade.findById(id);
		
		unidade.delete();
		
		return redirect (routes.ControleUnidade.index());
	}
	
	
}
