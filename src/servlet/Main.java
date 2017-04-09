package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		// つぶやきリストをアプリケ－ションスコ－プから取得
		ServletContext application = this.getServletContext();
		List<Mutter> mutterList =
				(List<Mutter>) application.getAttribute("mutterList");

		/*取得できなかった場合はつぶやきリストを新規作成して
		 * セッションスコ－プからユ－ザ－情報を取得
		 */
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("loginUser");

		// ログインしていない場合リダイレクト
		if(loginUser == null) {
			response.sendRedirect("/docoTsubu/");
		} else {
			// ログイン済の場合　フォワ－ド
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
				dispatcher.forward(request, response);
		}
	}
}
