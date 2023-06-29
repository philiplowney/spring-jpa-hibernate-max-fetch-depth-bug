package fetchDepthBug.repository;

import fetchDepthBug.domain.FormOption;
import fetchDepthBug.domain.FormVersionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface FormOptionRepository extends CrudRepository<FormOption, FormVersionId> {
}
