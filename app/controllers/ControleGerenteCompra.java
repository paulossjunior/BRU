package controllers;

import java.util.List;

import models.Campus;
import models.Categoria;
import models.GerenteCompra;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.CadastrarGerenteCompra;
import views.html.indexGerenteCompra;

public class ControleGerenteCompra extends Controller {

	private static final Form<GerenteCompra> GerenteCompraForm = Form
			.form(GerenteCompra.class);

	public static Result index() {

		List<GerenteCompra> gerenteCompras = GerenteCompra.find.all();

		return ok(indexGerenteCompra.render(gerenteCompras));
	}

	public static Result indexCadastrar() {
		return ok(CadastrarGerenteCompra.render(GerenteCompraForm));
	}

	public static Result salvar() {
		Form<GerenteCompra> boundForm = GerenteCompraForm.bindFromRequest();

		// Buscando os dados do formulario
		GerenteCompra gerenteCompra = boundForm.get();

		Categoria categoria = gerenteCompra.getCategoria();
		Categoria newcategoria = null;
		if (categoria.getId() != null) {
			// Buscando no banco o level selecionado
			newcategoria = Categoria.findById(categoria.getId());
		}
		Campus campi = gerenteCompra.getCampus();
		Campus newcampi = null;
		if (campi.getId() != null) {
			// Buscando no banco o level selecionado
			newcampi = Campus.findById(campi.getId());
		}

		gerenteCompra.setCampus(newcampi);
		gerenteCompra.save();

		return redirect(routes.ControleGerenteCompra.index());
	}

	public static Result editar(Long id) {
		GerenteCompra gerenteCompra = GerenteCompra.find.byId(id);

		GerenteCompraForm.fill(gerenteCompra);

		return ok(CadastrarGerenteCompra.render(GerenteCompraForm));
	}

	public static Result excluir(Long id) {
		GerenteCompra gerenteCompra = GerenteCompra.find.byId(id);

		gerenteCompra.delete();

		return redirect(routes.ControleGerenteCompra.index());
	}

}
