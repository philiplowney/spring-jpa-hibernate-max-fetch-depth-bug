package fetchDepthBug.springTests;


import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "persistence-unit=persistenceUnitFetchDepth5")
public class SpringTestCase_FetchDepth5 extends AbstractSpringTestCase {
}
