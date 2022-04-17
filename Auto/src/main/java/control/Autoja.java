package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.MalliAuto;
import model.dao.Dao;

/**
 * Servlet implementation class Autoja
 */
@WebServlet("/Autoja")
public class Autoja extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Autoja() {
		super();
		System.out.println("Autoja.Autoja()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Autoja.doGet()");
		Dao dao = new Dao();
		ArrayList<MalliAuto> autot = dao.listaaKaikki();
		System.out.println(autot);
		//Laitetaan uusi JSONObjekti nimelt‰ autoja, joka pit‰‰ sis‰ll‰‰n autot arraylistin
		String strJSON = new JSONObject().put("autoja", autot).toString();
		//Kirjoitetaan t‰m‰ serveletin http rajapintaan
		//M‰‰ritet‰‰n tulevan kirjoituksen tyypiksi application Json
		response.setContentType("application/json");
		//Tehd‰‰n PrintWriter nimelt‰‰n out
		PrintWriter out = response.getWriter();
		//K‰sket‰‰n out-printteri‰ kirjoittamaan strJSON ulos
		out.println(strJSON);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Autoja.doPost()");
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Autoja.doPut()");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Autoja.doDelete()");
	}

}
