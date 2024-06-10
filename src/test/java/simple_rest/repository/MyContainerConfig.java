package simple_rest.repository;

//@DataJpaTest
//@Testcontainers
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class MyContainerConfig {
//    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:14-alpine");
//
//    @DynamicPropertySource
//    static void configureProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", postgres::getJdbcUrl);
//        registry.add("spring.datasource.username", postgres::getUsername);
//        registry.add("spring.datasource.password", postgres::getPassword);
//    }
//
//    @Autowired
//    UserDAO userDao;
//
//    @BeforeEach
//    void setUp() {
//        userDao.deleteAll();
//        userDao.save(new Todo(null, "Todo Item 1", true, 1));
//        userDao.save(new Todo(null, "Todo Item 2", false, 2));
//        userDao.save(new Todo(null, "Todo Item 3", false, 3));
//    }
//
//    @Test
//    void shouldGetPendingTodos() {
//        assertThat(userDao.getPendingTodos()).hasSize(2);
//    }
//}