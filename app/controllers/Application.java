package controllers;

import models.Categoria;

import models.GerenteCompra;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.Session;
import views.html.*;

public class Application extends Controller {

	private static final Form<GerenteCompra> gerenteCompraForm = Form.form(GerenteCompra.class);

	public static Result index() {
		return ok(index.render(gerenteCompraForm));
	}

	public static Result signIn() {
		Form<GerenteCompra> boundForm = gerenteCompraForm.bindFromRequest();

		// Verificando os campos
		if (boundForm.field("senha").valueOr("").isEmpty())
			boundForm.reject("senha", "Favor preencher a senha");

		if (boundForm.field("email").valueOr("").isEmpty())
			boundForm.reject("email", "Favor preencher o email");

		if (boundForm.hasErrors()) {
			return badRequest(index.render(boundForm));
		}

		// Buscando os dados do formulario
		GerenteCompra gerenteCompraForm = boundForm.get();

		GerenteCompra gerenteCompra = GerenteCompra.retrive(gerenteCompraForm.getEmail(),
				gerenteCompraForm.getSenha());

		if (gerenteCompra == null) {
			boundForm.reject("error", "UserNotFound");
			flash("error", "Usuário não encontrado");
			return badRequest(index.render(boundForm));
		}

		// Criando uma sessao para o usuário
		Session session = ctx().session();
		// Adicionando o id do usuário na sessão
		session.put("GerenteCompra", gerenteCompra.getId().toString());
		flash("success", "Usuário Logado");

		return ok(principal.render());
	}

}
