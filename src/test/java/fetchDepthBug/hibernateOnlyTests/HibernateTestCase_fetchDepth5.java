package fetchDepthBug.hibernateOnlyTests;

public class HibernateTestCase_fetchDepth5 extends AbstractHibernateTestCase {
    @Override
    protected String getEntityManagerName() {
        return "persistenceUnitFetchDepth5";
    }
}
