package fetchDepthBug.hibernateOnlyTests;

public class HibernateTestCase_fetchDepth1 extends AbstractHibernateTestCase {
    @Override
    protected String getEntityManagerName() {
        return "persistenceUnitFetchDepth1";
    }
}
