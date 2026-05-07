package tech.csm.dao;

import java.util.List;

import tech.csm.entity.Admission;

public interface AdmissionDao {

	String newAdmission(List<Admission> admissionList);

}
