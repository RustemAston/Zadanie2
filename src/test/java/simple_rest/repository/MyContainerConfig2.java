package simple_rest.repository;

//@SpringBootTest
//@Testcontainers
//@AutoConfigureMockMvc(addFilters = false)
//@ContextConfiguration(initializers = {MyContainerConfig2.Initializer.class})
//@TestPropertySource(properties = {"spring.config.location=classpath:application-properties.yml"})
//public class MyContainerConfig2 {
//        private static final String DATABASE_NAME = "spring-app";
//
//        @Container
//        public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:11.1")
//                .withReuse(true)
//                .withDatabaseName(DATABASE_NAME);
//
//        static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
//            public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
//                TestPropertyValues.of(
//                        "CONTAINER.USERNAME=" + postgreSQLContainer.getUsername(),
//                        "CONTAINER.PASSWORD=" + postgreSQLContainer.getPassword(),
//                        "CONTAINER.URL=" + postgreSQLContainer.getJdbcUrl()
//                ).applyTo(configurableApplicationContext.getEnvironment());
//        }
//    }
//}