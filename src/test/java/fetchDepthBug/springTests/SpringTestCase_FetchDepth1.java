package fetchDepthBug.springTests;


import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "persistence-unit=persistenceUnitFetchDepth1")
public class SpringTestCase_FetchDepth1 extends AbstractSpringTestCase {
}
