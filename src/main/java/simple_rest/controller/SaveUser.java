package simple_rest.controller;

import simple_rest.Util.ConvertUserDTO2User;
import simple_rest.dto.UserDTO;
import simple_rest.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save")
public class SaveUser extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("nickname");
        int age = Integer.parseInt(req.getParameter("age"));
        userService.saveUser(ConvertUserDTO2User.getUser(new UserDTO(name, age)));
    }
}