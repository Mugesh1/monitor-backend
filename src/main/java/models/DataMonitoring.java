package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "datamon", schema = "tnhb_mon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataMonitoring {

  private Long id;
  private String division;
  private String circle;
  private String citynrural;
  private String fsAdministrativesanctionValue;
  private String revisedFS;
  private String revisedRFS;
  private String typeOfWork;
  private String contractorName;
  private String thirdPartySupervision;
  private String developmentWork;
  private String agreementValue;
  private String totalUnits;
  private String soldUnits;
  private String unsoldUnits;
  private String expenditureSoFar;
  private String otherExpenditureSoFar;
  private String siteHandingover;
  private String dueDateOfCompletion;
  private String anticipatedDateOfCompletion;
  private String eoTUpto;
  private String pmc;
  private String pmcAgreementValue;
  private String pmcExpenditureSoFar;
  private String pendingApproval;
  private String eb;
  private String waterSewage;
  private String giftDeed;
  private String handingOverToLocal;
  private String b_R_No_AndDate;
  private String workLC_released;
  private  String financialAchievement;
  private String costingStatus;

  private String comments;
  private String timestamp;
  private String editby;
  private String surveyno;
  private String totalextent;
  private String map;
  private String uniquecode;
  //newly added


  private String planningPermission;
  private String buildingPermission;

  private String dateOfCommencement;
  private String physicalProgress;
  private String lc_released_current_month;
  private String financialProgress;
  private String wc79;
  private String waterSupply;
  private String pmc_lc_released;
  private String developmentContractors;
  private String agreementValue1;
  private String expenditureSoFar1;
  private String completionCertificate;
  private String dateOfCompletionReport;
  private String rera;
  private String hig;
  private String mig_I;
  private String village;
  private String cmwssb_twad;
  private String dateOfCompletionReport2;


public Long getMid() {
	return mid;
}
public void setMid(Long mid) {
	this.mid = mid;
}
public DataMonitoringId getDataMonthId() {
	return dataMonthId;
}
public void setDataMonthId(DataMonitoringId dataMonthId) {
	this.dataMonthId = dataMonthId;
}
@Column(name = "mid", length = 36)
  private Long mid;

  @EmbeddedId
  @JsonIgnore
  private DataMonitoringId dataMonthId = new DataMonitoringId();
  
  @JsonProperty(value = "project_name")
public String getProjectName() 
  {
	  return this.dataMonthId.getProjectName();
	  }
  @JsonProperty(value = "month")
  public String getMonth()
  {
	  return this.dataMonthId.getMonth();
	  }
  
  public void setProjectName(String projectName) {this.dataMonthId.setProjectName(projectName);}
  public void setMonth(String month) {
    this.dataMonthId.setMonth(month);
  }
}