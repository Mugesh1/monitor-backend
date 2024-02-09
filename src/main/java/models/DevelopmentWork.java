package models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "development", schema = "tnhb_mon")
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DevelopmentWork {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String projectname;
    private Long mid;
    private String developmentWork;
    private String developmentContractors;
    private String expenditureSoFar1;
    private String agreementValue;
    private String dateOfCompletion;
    private String dateOfCompletionReport;
    private String workLC_released;
    private String physicalProgressDev;
    private String financialProgressDev;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	public String getDevelopmentWork() {
		return developmentWork;
	}
	public void setDevelopmentWork(String developmentWork) {
		this.developmentWork = developmentWork;
	}
	public String getDevelopmentContractors() {
		return developmentContractors;
	}
	public void setDevelopmentContractors(String developmentContractors) {
		this.developmentContractors = developmentContractors;
	}
	public String getExpenditureSoFar1() {
		return expenditureSoFar1;
	}
	public void setExpenditureSoFar1(String expenditureSoFar1) {
		this.expenditureSoFar1 = expenditureSoFar1;
	}
	public String getAgreementValue() {
		return agreementValue;
	}
	public void setAgreementValue(String agreementValue) {
		this.agreementValue = agreementValue;
	}
	public String getDateOfCompletion() {
		return dateOfCompletion;
	}
	public void setDateOfCompletion(String dateOfCompletion) {
		this.dateOfCompletion = dateOfCompletion;
	}
	public String getDateOfCompletionReport() {
		return dateOfCompletionReport;
	}
	public void setDateOfCompletionReport(String dateOfCompletionReport) {
		this.dateOfCompletionReport = dateOfCompletionReport;
	}
	public String getWorkLC_released() {
		return workLC_released;
	}
	public void setWorkLC_released(String workLC_released) {
		this.workLC_released = workLC_released;
	}
	public String getPhysicalProgressDev() {
		return physicalProgressDev;
	}
	public void setPhysicalProgressDev(String physicalProgressDev) {
		this.physicalProgressDev = physicalProgressDev;
	}
	public String getFinancialProgressDev() {
		return financialProgressDev;
	}
	public void setFinancialProgressDev(String financialProgressDev) {
		this.financialProgressDev = financialProgressDev;
	}
    
    





}
