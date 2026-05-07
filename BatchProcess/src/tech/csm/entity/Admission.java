package tech.csm.entity;

import java.io.Serializable;
import java.util.Date;

public class Admission implements Serializable {
	
	private Integer admissionId;
	private String candidateName;
	private Date admissionDate;
	private College college;
	public Integer getAdmissionId() {
		return admissionId;
	}
	public void setAdmissionId(Integer admissionId) {
		this.admissionId = admissionId;
	}
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public Date getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
	@Override
	public String toString() {
		return "Admission [admissionId=" + admissionId + ", candidateName=" + candidateName + ", admissionDate="
				+ admissionDate + ", college=" + college + "]";
	}
	
	
	
}
