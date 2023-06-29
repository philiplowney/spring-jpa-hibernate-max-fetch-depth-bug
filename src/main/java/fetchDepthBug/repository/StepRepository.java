package fetchDepthBug.repository;

import fetchDepthBug.domain.Step;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StepRepository extends CrudRepository<Step, Long> {
}
