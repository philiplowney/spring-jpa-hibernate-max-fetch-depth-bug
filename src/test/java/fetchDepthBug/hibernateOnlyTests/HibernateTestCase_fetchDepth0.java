package fetchDepthBug.hibernateOnlyTests;

public class HibernateTestCase_fetchDepth0 extends AbstractHibernateTestCase {
    @Override
    protected String getEntityManagerName() {
        return "persistenceUnitFetchDepth0";
    }
}
