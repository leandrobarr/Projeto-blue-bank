package bluebank.rest.api.repository;

import bluebank.rest.api.model.ClienteModel;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<ClienteModel, Integer> {
}
