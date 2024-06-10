package simple_rest.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import simple_rest.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.mockito.Mockito.mock;

class FindAllUsersTest {
    @InjectMocks
    private FindAllUsers findAllServlet;
    @MockBean
    private UserService userServiceMock;

    @Test
    void doGet_findAllUsersMethod() {
        HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockResponse = mock(HttpServletResponse.class);

        Mockito.doReturn("/findAll").when(mockRequest).getPathInfo();
        findAllServlet.doGet(mockRequest, mockResponse);
        Mockito.verify(userServiceMock).findAll();
    }
}