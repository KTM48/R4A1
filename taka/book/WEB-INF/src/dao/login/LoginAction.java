package login;

import bean.User;
import dao.UserDAO;
import tool.Action;
import javax.servlet.http.Cookie;
import javax.servlet.http.*;

public class LoginAction extends Action {
	public String execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {

		HttpSession session=request.getSession();

		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String userid;

		UserDAO dao=new UserDAO();
		User user = dao.search(email, pass);
		Cookie cookie = new Cookie();
		cookie.setMaxAge(60*60*24);


		if (user !=null) {
			session.setAttribute("user", user.getUser_id());
			int user_id = session;
			cookie.setValue(getAttribute("user"))
			return "userlogin-out.jsp";
		}

		return "userlogin-error.jsp";
	}
}
