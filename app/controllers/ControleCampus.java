package controllers;

import java.util.List;


import models.Campus;
import models.GerenteCompra;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;


public class ControleCampus extends Controller {

	private static final Form<Campus> CampusForm = Form.form(Campus.class);
	
	public static Result index() {

		List<Campus> campi = Campus.find.all();

		return ok(indexCampus.render(campi));
	}
	
	
	public static Result novo() {
        return ok(CadastrarCampus.render(CampusForm));
	}
	
	public static Result salvar()
	{
	
		Campus campus = Form.form(Campus.class).bindFromRequest().get();
		if (campus.getId()!= null)
			campus.update();
		else
			campus.save();
		
		return redirect (routes.ControleCampus.index());
	}
	
	public static Result editar(Long id)
	{
		Campus campus = Campus.find.byId(id);
		
		return ok(CadastrarCampus.render(CampusForm));
	}
	
	public static Result excluir(Long id)
	{
		Campus campus = Campus.find.byId(id);
		
		campus.delete();
		
		return redirect (routes.ControleCampus.index());
	}

}
