package daikfd.projects.goalsapp.generator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.stream.Stream;

public class GoalIdGenerator implements IdentifierGenerator {

    private final String goalIdPrefix = "PL";
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        String query = "SELECT g.id FROM Goals g";
        Stream<String> ids = session.createQuery(query, String.class).stream();
        long max = ids.map(o -> o.replace(goalIdPrefix, "")).mapToLong(Long::parseLong).max().orElse(0L);
        return goalIdPrefix + (String.format("%05d", max + 1));
    }
}
