package fetchDepthBug.hibernateOnlyTests;

public class HibernateTestCase_fetchDepth3 extends AbstractHibernateTestCase {
    @Override
    protected String getEntityManagerName() {
        return "persistenceUnitFetchDepth3";
    }
}
