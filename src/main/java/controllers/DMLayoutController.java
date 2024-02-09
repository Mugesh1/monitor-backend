package controllers;

import models.DataMonitoring;
import models.DataMonitoringLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;
import repos.DMLayoutRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/data_monitoring")
public class DMLayoutController {

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private DMLayoutRepo dmLayoutRepo;

    @PostMapping("/addlayout")
    @ResponseBody
    public DataMonitoringLayout updateLayoutData(@RequestBody DataMonitoringLayout data) {
        return dmLayoutRepo.save(data);
    }

    @PostMapping("/addlayout/{id}")
    @ResponseBody
    public DataMonitoringLayout updateLayoutDatabyid(@PathVariable("id") long id,@RequestBody DataMonitoringLayout data) {
        dmLayoutRepo.findById(id);
        return dmLayoutRepo.save(data);
    }

    @GetMapping("/GetLayoutdatabyID/{id}")
    public Optional<DataMonitoringLayout> getLayoutRentalById(@PathVariable("id") long id) {
        return dmLayoutRepo.findById(id);

    }

//    @GetMapping("/GetLayoutdata")
//    public List<DataMonitoringLayout> getLayoutAll() {
//        return dmLayoutRepo.findAll();
//    }


    @GetMapping("/GetLayoutdata")
    public List<DataMonitoringLayout>getLayoutAll(@RequestParam( "types")String types, @RequestParam( "values")String values)
    {
        if(types.equals("circle")   ) {
            return dmLayoutRepo.findByCircle(values);
        }
        if(types.equals("All")   ) {
            return dmLayoutRepo.findAll();
        }
        if(types.equals("chief")   ) {
            return dmLayoutRepo.findByCitynrural(values);
        }
        else {
            return  dmLayoutRepo.findByDivision(values);
        }
    }



    @DeleteMapping("/removeLayout/{project_name}")
    @Transactional
    public ResponseEntity<Object> removeLayoutData(@PathVariable("project_name")String projectName) {
        dmLayoutRepo.deleteLayoutByDataMonthIdProjectName(projectName);
        return ResponseEntity.ok().build();
    }


}
