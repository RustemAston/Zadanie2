package simple_rest.controller;

import simple_rest.Util.ConvertUser2DTO;
import simple_rest.Util.Mapper2JSON;
import simple_rest.entity.User;
import simple_rest.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/findAll")
public class FindAllUsers extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter printWriter = resp.getWriter()) {

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            for (User user : userService.findAll()) {
                printWriter.println(Mapper2JSON.getJSON(ConvertUser2DTO.getUserDTO(user)));
            }
        }
    }
}