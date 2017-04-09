package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

@WebServlet("/Login")

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメ－タの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		// Userインスタンス(ユ－ザ－情報)の生成
		User user = new User(name, pass);


		// ログイン処理
		LoginLogic loginLogic = new LoginLogic();
		boolean isLogin = loginLogic.execute(user);

		// ログイン成功時の処理
		if(isLogin) {
		// ユ－ザ－情報をセッションスコ－プに保存
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
		}

		// ログイン結果画面にフォワ－ド
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
			dispatcher.forward(request, response);

	}

}
