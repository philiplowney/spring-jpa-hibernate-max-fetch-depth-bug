package fetchDepthBug.hibernateOnlyTests;

public class HibernateTestCase_fetchDepth4 extends AbstractHibernateTestCase {
    @Override
    protected String getEntityManagerName() {
        return "persistenceUnitFetchDepth4";
    }
}
