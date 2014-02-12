package controllers;

import play.mvc.Controller;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.Session;
import views.html.*;

public class ControlePrincipal  extends Controller {
	
	public static Result index() {
		return ok(principal.render());
	}

	
}
