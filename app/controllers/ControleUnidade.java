package controllers;

import models.Campus;
import models.Unidade;

import java.util.List;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;


public class ControleUnidade extends Controller {
	
	private static final Form<Unidade> UnidadeForm = Form.form(Unidade.class);
	
	public static Result index(){
		
		List<Unidade> unidades = Unidade.findAll();
		
		return ok(indexUnidade.render(unidades));
	}
	public static Result indexCadastrar(){
		return ok(CadastrarUnidade.render(UnidadeForm));
	}
	public static Result salvar()
	{
	
		Unidade unidade = Form.form(Unidade.class).bindFromRequest().get();
		if (unidade.getId()!= null)
			unidade.update();
		else
			unidade.save();
		
		return redirect (routes.ControleUnidade.index());
	}
	
	public static Result editar(Long id)
	{
		Unidade unidade= Unidade.findById(id);
		
		return ok(CadastrarUnidade.render(UnidadeForm));
	}
	
	public static Result excluir(Long id)
	{
		Unidade unidade = Unidade.findById(id);
		
		unidade.delete();
		
		return redirect (routes.ControleUnidade.index());
	}
	
	
}
