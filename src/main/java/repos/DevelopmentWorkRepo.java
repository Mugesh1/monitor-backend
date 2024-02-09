package repos;

import models.Development;
import models.DevelopmentWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DevelopmentWorkRepo extends JpaRepository<DevelopmentWork,Long> {
    List<DevelopmentWork> findByMid(Long mid);

    List<DevelopmentWork> findAllByMid(Long mid);
}
