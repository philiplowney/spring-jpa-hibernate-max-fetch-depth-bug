package fetchDepthBug.repository;

import fetchDepthBug.domain.Program;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProgramRepository extends CrudRepository<Program, Long> {
    Optional<Program> findById(Long programId);

}
