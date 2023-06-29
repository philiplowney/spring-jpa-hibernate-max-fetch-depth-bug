package fetchDepthBug.repository;

import fetchDepthBug.domain.FormVersion;
import fetchDepthBug.domain.FormVersionId;
import org.springframework.data.repository.CrudRepository;

public interface FormVersionRepository extends CrudRepository<FormVersion, FormVersionId> {

}
