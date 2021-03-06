package controllers;

import java.util.List;

import models.Categoria;
import models.Produto;
import models.Unidade;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class ControleProduto extends Controller {

	private static final Form<Produto> produtoForm = Form.form(Produto.class);

	public static Result index() {

		List<Produto> produtos = Produto.find.all();

		return ok(indexProduto.render(produtos));
	}

	public static Result indexCadastrar() {
		return ok(CadastrarProduto.render(produtoForm));
	}

	public static Result salvar() {
		Form<Produto> boundForm = produtoForm.bindFromRequest();

		// Buscando os dados do formulario
		Produto produto = boundForm.get();

		Categoria categoria = produto.getCategoria();
		Categoria newcategoria = null;
		if (categoria.getId() != null) {
			// Buscando no banco o level selecionado
			newcategoria = Categoria.findById(categoria.getId());
		}
		Unidade unidade = produto.getUnidade();
		Unidade newunidade = null;
		if (unidade.getId() != null) {
			// Buscando no banco o level selecionado
			newunidade = unidade.findById(unidade.getId());
		}

		produto.setUnidade(newunidade);
		produto.setCategoria(newcategoria);
		if (produto.getId() != null) {
			flash("success", "Produto Atualizado");
			produto.update();
		} else {
			produto.save();
			flash("success", "Produto Criado");
		}

		return redirect(routes.ControleProduto.index());
	}

	public static Result editar(Long id) {
		Produto produto = Produto.findById(id);

		// preenchendo o formulario com os dados do objeto
		Form<Produto> produtoEditarForm = produtoForm.fill(produto);

		return ok(CadastrarProduto.render(produtoEditarForm));
	}

	public static Result excluir(Long id) {
		Produto produto = Produto.findById(id);

		produto.delete();

		return redirect(routes.ControleProduto.index());
	}

}
