package simple_rest.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import simple_rest.entity.User;
import simple_rest.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import static org.mockito.Mockito.mock;

class UpdateUserTest {
    @InjectMocks
    private UpdateUser updateUser;
    @MockBean
    private UserService userServiceMock;
    @Mock
    private BufferedReader mockBufferedReader;

    @Test
    void doPut_updateUserMethod() throws IOException {
        HttpServletRequest mockRequest = mock(HttpServletRequest.class);
        HttpServletResponse mockResponse = mock(HttpServletResponse.class);

        String nickname = "Kira";

        Mockito.doReturn(mockBufferedReader).when(mockRequest).getReader();
        Mockito.doReturn("{\"Kira\":\"" + nickname + "\"" +
                        "\"" + ":{\"id\":9} " +
                        "}",
                null
        ).when(mockBufferedReader).readLine();

        updateUser.doPut(mockRequest, mockResponse);

        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        Mockito.verify(userServiceMock).saveUser(argumentCaptor.capture());

        User user = argumentCaptor.getValue();
        Assertions.assertEquals(nickname, user.getNickname());
    }
}