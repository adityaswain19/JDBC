package tech.csm.service;

import java.util.Date;
import java.util.List;

import tech.csm.dao.AdmissionDao;
import tech.csm.entity.Admission;

public class AdmissionServiceImpl implements AdmissionService {
	private AdmissionDao admissionDao;
	
	public AdmissionServiceImpl(AdmissionDao admissionDao) {
		this.admissionDao=admissionDao;
	}
	
	
	@Override
	public String newAdmission(List<Admission> admissionList) {
		
		for(Admission a:admissionList)			
			a.setAdmissionDate(new Date());
		return admissionDao.newAdmission(admissionList);
	}

}
