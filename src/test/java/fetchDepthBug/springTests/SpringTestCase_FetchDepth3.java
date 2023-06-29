package fetchDepthBug.springTests;


import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "persistence-unit=persistenceUnitFetchDepth3")
public class SpringTestCase_FetchDepth3 extends AbstractSpringTestCase {
}
