package tech.csm.dao;

import java.util.List;

import tech.csm.entity.State;

public interface StateDao {

	List<State> getAllState();

	State getStateByName(String name);

}
