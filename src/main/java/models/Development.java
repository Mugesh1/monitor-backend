package models;

import lombok.Data;

import java.util.List;

@Data
public class Development {
    private String month;
    private String timestamp;
    private String editby;
    private List<DataMonitoring> dataMonitoring;
    private List<DevelopmentWork> developmentWorks;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getEditby() {
		return editby;
	}
	public void setEditby(String editby) {
		this.editby = editby;
	}
	public List<DataMonitoring> getDataMonitoring() {
		return dataMonitoring;
	}
	public void setDataMonitoring(List<DataMonitoring> dataMonitoring) {
		this.dataMonitoring = dataMonitoring;
	}
	public List<DevelopmentWork> getDevelopmentWorks() {
		return developmentWorks;
	}
	public void setDevelopmentWorks(List<DevelopmentWork> developmentWorks) {
		this.developmentWorks = developmentWorks;
	}
    
    


}
