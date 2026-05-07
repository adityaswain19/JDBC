package tech.csm.service;

import java.util.List;

import tech.csm.dao.StateDao;
import tech.csm.entity.State;

public class StateServiceImpl implements StateService {
	
	StateDao stateDao;

	public StateServiceImpl(StateDao stateDao) {
		this.stateDao = stateDao;
	}

	@Override
	public List<State> getAllState() {
		return stateDao.getAllState();
	}

	@Override
	public State getStateByName(String name) {
		return stateDao.getStateByName(name);
	}
	

}
