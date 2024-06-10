package simple_rest.controller;

import simple_rest.Util.ConvertOne2ManyEntity2DTO;
import simple_rest.Util.Mapper2JSON;
import simple_rest.dto.One2ManyEntityDTO;
import simple_rest.service.UserService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/one2many")
public class OneToMany extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<One2ManyEntityDTO> listEntitiesDTO = userService.getOne2Many().stream()
                .map(ConvertOne2ManyEntity2DTO::getOne2ManyEntityDTO).toList(); // conversion from One2ManyEntity to DTO

        try(PrintWriter printWriter = resp.getWriter()) {

            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");

            listEntitiesDTO.forEach(x -> printWriter.println(Mapper2JSON.getJSON(x)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}