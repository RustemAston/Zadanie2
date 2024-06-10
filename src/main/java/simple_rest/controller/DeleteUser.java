package simple_rest.controller;

import simple_rest.service.UserService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/delete")
public class DeleteUser extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        int userId = 0;
        try {
            userId = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        userService.deleteUser(userId);
    }
}