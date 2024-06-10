package simple_rest.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import simple_rest.entity.Many2ManyEntity;
import simple_rest.entity.One2ManyEntity;
import simple_rest.entity.User;
import simple_rest.exception.NoUserFoundException;
import simple_rest.repository.UserDAO;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserServiceTest {
    @InjectMocks
    UserService userServiceMock;
    @Mock
    UserDAO userDAOMock;

    @BeforeEach
    void init(){
        userServiceMock = Mockito.mock(UserService.class);
        userDAOMock = Mockito.mock(UserDAO.class);
    }

    @Test
    void shouldReturn_findAll() {
        List<User> users = new ArrayList<>();
        users.add(new User("Roma", 20));
        users.add(new User("Leonid", 37));
        Mockito.when(userServiceMock.findAll()).thenReturn(users);

        Assertions.assertEquals(2, users.size());
        verify(userServiceMock,Mockito.times(1)).findAll();
    }

    @Test
    void shouldReturn_findById() {
        User userMock = Mockito.mock(User.class);
        Mockito.when(userServiceMock.findById(1)).thenReturn(userMock);

        verify(userServiceMock).findById(1);
    }

    @Test
    void should_saveUser() {
        Mockito.doCallRealMethod().when(userServiceMock).saveUser(any(User.class));

        User user = new User("Pavlusha", 16);

        Assertions.assertEquals(7, UserDAO.findAll().size());
        verify(userServiceMock).saveUser(user);
    }

    @Test
    void should_updateUser() {
        User user = new User("Pavlusha", 16);
        Mockito.doCallRealMethod().when(userServiceMock).updateUser(1, user);
    }

    @Test
    void should_deleteUser() {
        Mockito.doNothing().when(userServiceMock).deleteUser(1);
        Mockito.verify(userDAOMock).deleteUser(1);
    }

    @Test
    void should_Throw_Exception_When_No_user_Is_Found() {
        Mockito.doThrow(NoUserFoundException.class).when(userServiceMock).deleteUser(114);
    }

    @Test
    void shouldReturn_One2Many() {
        List<One2ManyEntity> list = new ArrayList<>();

        Mockito.when(userServiceMock.getOne2Many()).thenReturn(list);
        Mockito.verify(userServiceMock).getOne2Many();
    }

    @Test
    void shouldReturn_Many2Many() {
        List<Many2ManyEntity> list = new ArrayList<>();

        Mockito.when(userServiceMock.getMany2Many()).thenReturn(list);
        Mockito.verify(userServiceMock).getMany2Many();
    }
}