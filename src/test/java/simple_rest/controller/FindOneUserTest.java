package simple_rest.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import simple_rest.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.mockito.Mockito.mock;

class FindOneUserTest {
    @InjectMocks
    private FindOneUser findOneUser;
    @MockBean
    private UserService userServiceMock;

    @Test
    void findOneUserByIdMethod() {
        HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockResponse = mock(HttpServletResponse.class);

        Mockito.doReturn("/findOne?id=1").when(mockRequest).getPathInfo();
        findOneUser.doGet(mockRequest, mockResponse);
        Mockito.verify(userServiceMock).findById(1);
    }
}