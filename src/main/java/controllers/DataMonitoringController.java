package controllers;

import models.DataMonitoring;
import models.Development;
import models.DevelopmentWork;
import models.FilterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;
import repos.DataMonitoringRepo;
import repos.DevelopmentWorkRepo;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/data_monitoring")
public class DataMonitoringController {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private DataMonitoringRepo dataMonitoringRepo;

    @Autowired
    private DevelopmentWorkRepo developmentWorkRepo;

    @GetMapping
    @ResponseBody
    public List<DataMonitoring> getProjectDetails(
            @RequestParam(value = "project_name", required = false) Optional<String> projectName) {
        return projectName.isEmpty() ? dataMonitoringRepo.findAll()
                : dataMonitoringRepo.findByDataMonthIdProjectName(projectName.get());
    }

    @PostMapping("/add")
    public Development updateData(@RequestBody Development development) {

        List<DataMonitoring> dataMonitorings = development.getDataMonitoring();
        String editBy = development.getEditby();
        String timestamp = development.getTimestamp();
        if (dataMonitorings != null) {
            for (DataMonitoring dataMonitoring : dataMonitorings) {
                dataMonitoring.setMid(generateUniqueLong());
                dataMonitoring.setEditby(editBy);
                dataMonitoring.setTimestamp(timestamp);
            }
            dataMonitoringRepo.saveAll(dataMonitorings);
        }
        Long mid = dataMonitorings.get(0).getMid();

        List<DevelopmentWork> developmentWorks = development.getDevelopmentWorks();
        if (developmentWorks != null) {
            for (DevelopmentWork work : developmentWorks) {
                work.setMid(mid);
            }
            developmentWorkRepo.saveAll(developmentWorks);
        }
        return development;
    }

    private Long generateUniqueLong() {

        return System.currentTimeMillis();
    }

    @GetMapping("/GetdatabyID/{id}")
    public Optional<DataMonitoring> getRentalById(@PathVariable("id") long id) {
        return dataMonitoringRepo.findById(id);

    }

    @PostMapping("/add/{mid}")
    public ResponseEntity<Development> editById(@PathVariable Long mid, @RequestBody Development updatedData) {
        List<DataMonitoring> optionalDataMonitoring = dataMonitoringRepo.findByMid(mid);
        List<DevelopmentWork> optionalDevelopmentWork = developmentWorkRepo.findByMid(mid);

        if (!optionalDataMonitoring.isEmpty() && !optionalDevelopmentWork.isEmpty()) {
            DataMonitoring existingDataMonitoring = optionalDataMonitoring.get(0);
            DevelopmentWork existingDevelopmentWork = optionalDevelopmentWork.get(0);
            existingDataMonitoring.setAgreementValue(updatedData.getDataMonitoring().get(0).getAgreementValue());
            existingDataMonitoring.setFsAdministrativesanctionValue(
                    updatedData.getDataMonitoring().get(0).getFsAdministrativesanctionValue());
            existingDataMonitoring.setRevisedFS(updatedData.getDataMonitoring().get(0).getRevisedFS());
            existingDataMonitoring.setContractorName(updatedData.getDataMonitoring().get(0).getContractorName());
            existingDataMonitoring.setExpenditureSoFar(updatedData.getDataMonitoring().get(0).getExpenditureSoFar());
            existingDataMonitoring.setAgreementValue(updatedData.getDataMonitoring().get(0).getAgreementValue());
            existingDataMonitoring.setPmc(updatedData.getDataMonitoring().get(0).getPmc());
            existingDataMonitoring.setPmcAgreementValue(updatedData.getDataMonitoring().get(0).getPmcAgreementValue());
            existingDataMonitoring
                    .setPmcExpenditureSoFar(updatedData.getDataMonitoring().get(0).getPmcExpenditureSoFar());
            existingDataMonitoring.setEb(updatedData.getDataMonitoring().get(0).getEb());
            existingDataMonitoring.setB_R_No_AndDate(updatedData.getDataMonitoring().get(0).getB_R_No_AndDate());
            existingDataMonitoring.setCostingStatus(updatedData.getDataMonitoring().get(0).getCostingStatus());
            existingDataMonitoring.setSurveyno(updatedData.getDataMonitoring().get(0).getSurveyno());
            existingDataMonitoring.setTotalextent(updatedData.getDataMonitoring().get(0).getTotalextent());
            existingDataMonitoring.setMap(updatedData.getDataMonitoring().get(0).getMap());
            existingDataMonitoring.setUniquecode(updatedData.getDataMonitoring().get(0).getUniquecode());
            existingDataMonitoring
                    .setPlanningPermission(updatedData.getDataMonitoring().get(0).getPlanningPermission());
            existingDataMonitoring
                    .setBuildingPermission(updatedData.getDataMonitoring().get(0).getBuildingPermission());
            existingDataMonitoring
                    .setDateOfCommencement(updatedData.getDataMonitoring().get(0).getDateOfCommencement());
            existingDataMonitoring.setPhysicalProgress(updatedData.getDataMonitoring().get(0).getPhysicalProgress());
            existingDataMonitoring.setLc_released_current_month(
                    updatedData.getDataMonitoring().get(0).getLc_released_current_month());
            existingDataMonitoring.setFinancialProgress(updatedData.getDataMonitoring().get(0).getFinancialProgress());
            existingDataMonitoring.setWc79(updatedData.getDataMonitoring().get(0).getWc79());
            existingDataMonitoring.setPmc_lc_released(updatedData.getDataMonitoring().get(0).getPmc_lc_released());
            existingDataMonitoring.setAgreementValue1(updatedData.getDataMonitoring().get(0).getAgreementValue1());
            existingDataMonitoring
                    .setCompletionCertificate(updatedData.getDataMonitoring().get(0).getCompletionCertificate());
            existingDataMonitoring
                    .setDateOfCompletionReport(updatedData.getDataMonitoring().get(0).getDateOfCompletionReport());
            existingDataMonitoring.setRera(updatedData.getDataMonitoring().get(0).getRera());
            existingDataMonitoring.setVillage(updatedData.getDataMonitoring().get(0).getVillage());
            existingDataMonitoring.setCmwssb_twad(updatedData.getDataMonitoring().get(0).getCmwssb_twad());
            existingDataMonitoring
                    .setDateOfCompletionReport2(updatedData.getDataMonitoring().get(0).getDateOfCompletionReport2());

            List<DevelopmentWork> updatedDevelopmentWorks = updatedData.getDevelopmentWorks();
            if (updatedDevelopmentWorks != null && !updatedDevelopmentWorks.isEmpty()) {
                DevelopmentWork updatedDevelopmentWork = updatedDevelopmentWorks.get(0);
                existingDevelopmentWork.setDevelopmentWork(updatedDevelopmentWork.getDevelopmentWork());
                existingDevelopmentWork.setDevelopmentContractors(updatedDevelopmentWork.getDevelopmentContractors());
                existingDevelopmentWork.setAgreementValue(updatedDevelopmentWork.getAgreementValue());
                existingDevelopmentWork.setDateOfCompletion(updatedDevelopmentWork.getDateOfCompletion());
                existingDevelopmentWork.setDateOfCompletionReport(updatedDevelopmentWork.getDateOfCompletionReport());
                existingDevelopmentWork.setExpenditureSoFar1(updatedDevelopmentWork.getExpenditureSoFar1());
                existingDevelopmentWork.setWorkLC_released(updatedDevelopmentWork.getWorkLC_released());
                existingDevelopmentWork.setFinancialProgressDev(updatedDevelopmentWork.getFinancialProgressDev());
                existingDevelopmentWork.setPhysicalProgressDev(updatedDevelopmentWork.getPhysicalProgressDev());
            }

            dataMonitoringRepo.save(existingDataMonitoring);
            developmentWorkRepo.save(existingDevelopmentWork);

            Development updatedDevelopment = new Development();
            updatedDevelopment.setMonth(existingDataMonitoring.getMonth());
            updatedDevelopment.setTimestamp(existingDataMonitoring.getTimestamp());
            updatedDevelopment.setEditby(existingDataMonitoring.getEditby());
            updatedDevelopment.setDataMonitoring(Collections.singletonList(existingDataMonitoring));
            updatedDevelopment.setDevelopmentWorks(Collections.singletonList(existingDevelopmentWork));

            return new ResponseEntity<>(updatedDevelopment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getData/{mid}")
    public ResponseEntity<Development> getDataById(@PathVariable Long mid) {
        List<DataMonitoring> dataMonitoringList = dataMonitoringRepo.findByMid(mid);
        List<DevelopmentWork> developmentWorkList = developmentWorkRepo.findByMid(mid);

        if (!dataMonitoringList.isEmpty() && !developmentWorkList.isEmpty()) {
            Development development = new Development();

            DataMonitoring dataMonitoring = dataMonitoringList.get(0);
            DevelopmentWork developmentWork = developmentWorkList.get(0);

            development.setMonth(dataMonitoring.getMonth());
            development.setTimestamp(dataMonitoring.getTimestamp());
            development.setEditby(dataMonitoring.getEditby());
            development.setDataMonitoring(dataMonitoringList);
            development.setDevelopmentWorks(developmentWorkList);

            return new ResponseEntity<>(development, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/remove/{project_name}")
    @Transactional
    public ResponseEntity<Object> removeData(@PathVariable("project_name") String projectName) {
        dataMonitoringRepo.deleteByDataMonthIdProjectName(projectName);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/project/{project_name}/key/{month}")
    @ResponseBody
    public DataMonitoring getProjectDetailsByMonth(@RequestParam(value = "project_name") String projectName,
            @RequestParam(value = "month") String month) {
        return dataMonitoringRepo.findByDataMonthIdProjectNameAndDataMonthIdMonth(projectName, month);
    }

    @GetMapping("/filter")
    @ResponseBody
    public List<DataMonitoring> getFilters(FilterDTO filters) {
        return dataMonitoringRepo.findByDivisionOrFsAdministrativesanctionValueOrTypeOfWork(filters.division(),
                filters.fsAdministrativesanctionValue(), filters.typeOfWork());
    }

    @GetMapping("/GetData")
    public List<DataMonitoring> getAllemployees(@RequestParam("types") String types,
            @RequestParam("values") String values) {
        if (types.equals("circle")) {
            return dataMonitoringRepo.findByCircle(values);
        }
        if (types.equals("All")) {
            return dataMonitoringRepo.findAll();
        }
        if (types.equals("chief")) {
            return dataMonitoringRepo.findByCitynrural(values);
        } else {
            return dataMonitoringRepo.findByDivision(values);
        }
    }

    @Autowired
    DataMonitoringimpl dataMonitoringimpl;

    @GetMapping("/GetDataDivisions")
    public List<DataMonitoring> getdivision(@RequestParam("circle") String circle) {
        if (circle.equals("All")) {
            return dataMonitoringimpl.getalldivisionforcircleall();
        }
        if (circle.equals("City")) {
            return dataMonitoringimpl.getalldivisionforcircleall();
        }
        if (circle.equals("Rural")) {
            return dataMonitoringimpl.getalldivisionforcircleall();
        } else {
            return dataMonitoringimpl.getalldivisionforcircle(circle);
        }
    }

}