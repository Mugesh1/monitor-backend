package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class DataMonitoringId implements Serializable {
  @Column(name = "month")
  private String month;
  @Column(name = "project_name")
  private String projectName;
public String getMonth() {
	return month;
}
public void setMonth(String month) {
	this.month = month;
}
public String getProjectName() {
	return projectName;
}
public void setProjectName(String projectName) {
	this.projectName = projectName;
}
  
  
}
