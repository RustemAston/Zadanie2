package simple_rest.controller;

import simple_rest.Util.ConvertMany2ManyEntity2DTO;
import simple_rest.Util.Mapper2JSON;
import simple_rest.dto.Many2ManyEntityDTO;
import simple_rest.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/many2many")
public class Many2Many extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Many2ManyEntityDTO> listEntitiesDTO = userService.getMany2Many().stream()
                .map(ConvertMany2ManyEntity2DTO::getMany2ManyEntityDTO).toList(); // conversion from Many2ManyEntity to DTO

        try(PrintWriter printWriter = resp.getWriter()) {

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            listEntitiesDTO.forEach(x -> printWriter.println(Mapper2JSON.getJSON(x)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}