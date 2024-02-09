package controllers;

import models.DataMonitoring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;



@Repository
public class DataMonitoringimpl implements GetRentalDataDao {
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		public static void main(String[] args) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://tnhb-monitor.cnqcnxjoo1nj.us-east-1.rds.amazonaws.com/tnhb_mon");
		dataSource.setUsername("root");
		dataSource.setPassword("yazhini1998");
		}

public List<DataMonitoring> getalldivisionforcircle(String circle) {
	List<DataMonitoring> domain = new ArrayList<>();
	String sqlQuery = "SELECT distinct division FROM tnhb_mon.datamon where circle = '" + circle + "'";
	domain = namedParameterJdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<>(DataMonitoring.class));
	return domain;
}


public List<DataMonitoring> getalldivisionforcircleall() {
	List<DataMonitoring> domain = new ArrayList<>();
	String sqlQuery = "SELECT distinct division,citynrural FROM tnhb_mon.datamon ";
	domain = namedParameterJdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper<>(DataMonitoring.class));
	return domain;
}

}