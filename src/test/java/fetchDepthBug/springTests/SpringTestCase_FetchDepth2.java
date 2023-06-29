package fetchDepthBug.springTests;


import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "persistence-unit=persistenceUnitFetchDepth2")
public class SpringTestCase_FetchDepth2 extends AbstractSpringTestCase {
}
