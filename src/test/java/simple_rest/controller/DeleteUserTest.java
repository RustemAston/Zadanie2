package simple_rest.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import simple_rest.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.mockito.Mockito.mock;

class DeleteUserTest {
    @InjectMocks
    private DeleteUser deleteUser;
    @MockBean
    private UserService userServiceMock;

    @Test
    void doDelete_findOneUserByIdMethod() {
        HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockResponse = mock(HttpServletResponse.class);

        Mockito.doReturn("/findOne?id=1").when(mockRequest).getPathInfo();
        deleteUser.doDelete(mockRequest, mockResponse);

        Mockito.verify(userServiceMock).deleteUser(Mockito.anyInt());
        Mockito.verify(mockResponse).setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}