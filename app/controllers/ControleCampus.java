package controllers;

import java.util.List;

import models.Campus;
import models.GerenteCompra;
import models.Unidade;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class ControleCampus extends Controller {

	private static final Form<Campus> campusForm = Form.form(Campus.class);

	public static Result index() {

		List<Campus> campi = Campus.find.all();
		System.out.println(campi.size());
		return ok(indexCampus.render(campi));
	}

	public static Result novo() {
		return ok(CadastrarCampus.render(campusForm));
	}

	public static Result salvar() {

		Campus campus = Form.form(Campus.class).bindFromRequest().get();
		if (campus.getId() != null) {
			flash("success", "Campus Atualizado");
			campus.update();
		} else {
			campus.save();
			flash("success", "Campus Criado");
		}

		return redirect(routes.ControleCampus.index());
	}

	public static Result editar(Long id) {
		Campus campus = Campus.findById(id);

		// preenchendo o formulario com os dados do objeto
		Form<Campus> campusEditarForm = campusForm.fill(campus);

		return ok(CadastrarCampus.render(campusEditarForm));
	}

	public static Result excluir(Long id) {
		Campus campus = Campus.find.byId(id);

		campus.delete();

		return redirect(routes.ControleCampus.index());
	}

}
