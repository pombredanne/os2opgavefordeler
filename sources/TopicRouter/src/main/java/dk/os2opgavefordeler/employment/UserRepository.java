package dk.os2opgavefordeler.employment;

import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.Repository;

import dk.os2opgavefordeler.model.User;

import javax.enterprise.context.ApplicationScoped;

@Repository(forEntity = User.class)
public abstract class UserRepository extends AbstractEntityRepository<User, Long> {

    public abstract User findByEmail(String email);

}