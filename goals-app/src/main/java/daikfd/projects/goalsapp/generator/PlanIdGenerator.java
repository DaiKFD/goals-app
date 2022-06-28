package daikfd.projects.goalsapp.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.stream.Stream;

public class PlanIdGenerator implements IdentifierGenerator {

    private final String planIdPrefix = "PL";
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        String query = "SELECT p.id FROM Plans p";
        Stream<String> ids = session.createQuery(query, String.class).stream();
        long max = ids.map(o -> o.replace(planIdPrefix, "")).mapToLong(Long::parseLong).max().orElse(0L);
        return planIdPrefix + (String.format("%05d", max + 1));
    }
}
