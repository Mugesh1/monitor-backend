package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "datalayout", schema = "tnhb_mon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataMonitoringLayout {

    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String uniquecode;
    private String citynrural;
    private String circle;
    private String division;
    private String village;
    private String sftsno;
    private String extentacres;
    private String brnodate;
    private String fsvaluers;
    private String wc79rs;
    private String rfsrs;
    private String layoutapproval;
    private String lbapproval;
    private String contractor;
    private String agreementvalue;
    private String doc;
    private String ddc;
    private String expenditure;
    private String lcreleased;
    private String physicalprogress;
    private String financialprogress;
    private String stageofwork;
    private String giftdeed;
    private String hotolb;
    private String cost;
    private String rera;
    private String completionreport;
    private String map;
    private String comments;
    private String timestamp;
    private String editby;
    
    private String dateOfCompletionReport1;


    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUniquecode() {
		return uniquecode;
	}
	public void setUniquecode(String uniquecode) {
		this.uniquecode = uniquecode;
	}
	public String getCitynrural() {
		return citynrural;
	}
	public void setCitynrural(String citynrural) {
		this.citynrural = citynrural;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getSftsno() {
		return sftsno;
	}
	public void setSftsno(String sftsno) {
		this.sftsno = sftsno;
	}
	public String getExtentacres() {
		return extentacres;
	}
	public void setExtentacres(String extentacres) {
		this.extentacres = extentacres;
	}
	public String getBrnodate() {
		return brnodate;
	}
	public void setBrnodate(String brnodate) {
		this.brnodate = brnodate;
	}
	public String getFsvaluers() {
		return fsvaluers;
	}
	public void setFsvaluers(String fsvaluers) {
		this.fsvaluers = fsvaluers;
	}
	public String getWc79rs() {
		return wc79rs;
	}
	public void setWc79rs(String wc79rs) {
		this.wc79rs = wc79rs;
	}
	public String getRfsrs() {
		return rfsrs;
	}
	public void setRfsrs(String rfsrs) {
		this.rfsrs = rfsrs;
	}
	public String getLayoutapproval() {
		return layoutapproval;
	}
	public void setLayoutapproval(String layoutapproval) {
		this.layoutapproval = layoutapproval;
	}
	public String getLbapproval() {
		return lbapproval;
	}
	public void setLbapproval(String lbapproval) {
		this.lbapproval = lbapproval;
	}
	public String getContractor() {
		return contractor;
	}
	public void setContractor(String contractor) {
		this.contractor = contractor;
	}
	public String getAgreementvalue() {
		return agreementvalue;
	}
	public void setAgreementvalue(String agreementvalue) {
		this.agreementvalue = agreementvalue;
	}
	public String getDoc() {
		return doc;
	}
	public void setDoc(String doc) {
		this.doc = doc;
	}
	public String getDdc() {
		return ddc;
	}
	public void setDdc(String ddc) {
		this.ddc = ddc;
	}
	public String getExpenditure() {
		return expenditure;
	}
	public void setExpenditure(String expenditure) {
		this.expenditure = expenditure;
	}
	public String getLcreleased() {
		return lcreleased;
	}
	public void setLcreleased(String lcreleased) {
		this.lcreleased = lcreleased;
	}
	public String getPhysicalprogress() {
		return physicalprogress;
	}
	public void setPhysicalprogress(String physicalprogress) {
		this.physicalprogress = physicalprogress;
	}
	public String getFinancialprogress() {
		return financialprogress;
	}
	public void setFinancialprogress(String financialprogress) {
		this.financialprogress = financialprogress;
	}
	public String getStageofwork() {
		return stageofwork;
	}
	public void setStageofwork(String stageofwork) {
		this.stageofwork = stageofwork;
	}
	public String getGiftdeed() {
		return giftdeed;
	}
	public void setGiftdeed(String giftdeed) {
		this.giftdeed = giftdeed;
	}
	public String getHotolb() {
		return hotolb;
	}
	public void setHotolb(String hotolb) {
		this.hotolb = hotolb;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getRera() {
		return rera;
	}
	public void setRera(String rera) {
		this.rera = rera;
	}
	public String getCompletionreport() {
		return completionreport;
	}
	public void setCompletionreport(String completionreport) {
		this.completionreport = completionreport;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
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
	public DataMonitoringLayoutId getDataMonthId() {
		return dataMonthId;
	}
	public void setDataMonthId(DataMonitoringLayoutId dataMonthId) {
		this.dataMonthId = dataMonthId;
	}
	@EmbeddedId
    @JsonIgnore
    private DataMonitoringLayoutId dataMonthId = new DataMonitoringLayoutId();

    @JsonProperty(value = "project_name")
    private String getProjectName()
    {
        return this.dataMonthId.getProjectName();
    }
    @JsonProperty(value = "month")
    private String getMonth()
    {
        return this.dataMonthId.getMonth();
    }

    public void setProjectName(String projectName) {this.dataMonthId.setProjectName(projectName);}
    public void setMonth(String month) {
        this.dataMonthId.setMonth(month);
    }


}
