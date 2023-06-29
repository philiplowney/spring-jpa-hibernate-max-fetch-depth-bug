package fetchDepthBug.repository;

import fetchDepthBug.domain.Form;
import org.springframework.data.repository.CrudRepository;

public interface FormRepository extends CrudRepository<Form, Long> {
}
