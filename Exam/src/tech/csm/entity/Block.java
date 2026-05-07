package tech.csm.entity;

import java.io.Serializable;

public class Block implements Serializable {
	
	private String blockId;
	private String blockName;
	private String BDOName;
	private State state;
	
	
	public String getBlockId() {
		return blockId;
	}
	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public String getBDOName() {
		return BDOName;
	}
	public void setBDOName(String bDOName) {
		BDOName = bDOName;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Block [blockId=" + blockId + ", blockName=" + blockName + ", BDOName=" + BDOName + ", state=" + state
				+ "]";
	}
	
	
	

}
