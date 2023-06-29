package fetchDepthBug.hibernateOnlyTests;

public class HibernateTestCase_fetchDepth2 extends AbstractHibernateTestCase {
    @Override
    protected String getEntityManagerName() {
        return "persistenceUnitFetchDepth2";
    }
}
