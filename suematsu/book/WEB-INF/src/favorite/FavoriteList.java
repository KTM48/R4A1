
package favorite;

import bean.*;
import dao.*;
import tool.Page;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.List;

@WebServlet(urlPatterns={"/favorite/favoritelist"})
public class FavoriteList extends HttpServlet {

	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {

			int Keyword=5;
			FavoriteDAO dao=new FavoriteDAO();
			List<Favoritebean> list=dao.search(Keyword);

			request.setAttribute("list", list);
			request.getRequestDispatcher("/favorite/favoritelist.jsp").forward(request,response); //フォワードを行う

		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
