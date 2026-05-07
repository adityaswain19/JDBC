package tech.csm.service;

import java.util.List;

import tech.csm.entity.State;

public interface StateService {

	List<State> getAllState();

	State getStateByName(String name);

}
