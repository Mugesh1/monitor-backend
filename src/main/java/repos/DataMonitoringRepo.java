package repos;

import models.DataMonitoring;
import models.DataMonitoringId;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DataMonitoringRepo extends JpaRepository<DataMonitoring, DataMonitoringId> {
  List<DataMonitoring> findByDataMonthIdProjectName(String projectName);

	List<DataMonitoring> findByDivision(String values);
	
	List<DataMonitoring> findByCircle(String values);
	
	List<DataMonitoring> findByCitynrural(String values);
	Optional<DataMonitoring> findById(Long id);

  List<DataMonitoring> findByDivisionOrFsAdministrativesanctionValueOrTypeOfWork(String division,String fsAdministrativesanctionValue,String Typeofwork);
  DataMonitoring findByDataMonthIdProjectNameAndDataMonthIdMonth(String projectName, String month);
  void deleteByDataMonthIdProjectName(String projectName);

    List<DataMonitoring> findByMid(Long mid);
}