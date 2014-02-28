package controllers;

import java.util.List;
import models.Campus;
import models.Categoria;
import models.Unidade;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.CadastrarCategoria;
import views.html.indexCategoria;

public class ControleCategoria extends Controller {

	private static final Form<Categoria> categoriaForm = Form
			.form(Categoria.class);

	public static Result index() {

		List<Categoria> categorias = Categoria.findAll();

		return ok(indexCategoria.render(categorias));
	}

	public static Result indexCadastrar() {
		return ok(CadastrarCategoria.render(categoriaForm));
	}

	public static Result salvar() {

		Categoria categoria = Form.form(Categoria.class).bindFromRequest()
				.get();
		
		// Verificando se a categoria existe.
		// Caso o ID seja diferente de zero significa que estou editando um
		// dado.
		if (categoria.getId() != null) {
			flash("success", "Categoria Atualizada");
			categoria.update();
		} else {
			categoria.save();
			flash("success", "Categoria Criada");
		}

		return redirect(routes.ControleCategoria.index());
	}

	public static Result editar(Long id) {
		Categoria categoria = Categoria.findById(id);

		// preenchendo o formulario com os dados do objeto
		Form<Categoria> categoriaEditarForm = categoriaForm.fill(categoria);

		return ok(CadastrarCategoria.render(categoriaEditarForm));
	}

	public static Result excluir(Long id) {
		Categoria categoria = Categoria.findById(id);

		categoria.delete();

		return redirect(routes.ControleCategoria.index());
	}

}
