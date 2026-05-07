package tech.csm.dao;

import java.util.List;

import tech.csm.entity.Block;
import tech.csm.entity.State;

public interface BlockDao {

	String addBlock(Block block);

	List<Block> getAllBlock();

	Block getBlockById(String id);

	String updateBlock(String b,String id);

	List<Block> displayBlock();

	String deleteBlock(String id);

}
