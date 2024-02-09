package repos;


import models.DataMonitoringLayout;
import models.DataMonitoringLayoutId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DMLayoutRepo extends JpaRepository<DataMonitoringLayout, DataMonitoringLayoutId> {
    Optional<DataMonitoringLayout> findById(Long id);
    List<DataMonitoringLayout> findByDivision(String values);

    List<DataMonitoringLayout> findByCircle(String values);

    List<DataMonitoringLayout> findByCitynrural(String values);


    void deleteLayoutByDataMonthIdProjectName(String projectName);
}
