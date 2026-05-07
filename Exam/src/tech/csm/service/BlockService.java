package tech.csm.service;

import java.util.List;

import tech.csm.entity.Block;
import tech.csm.entity.State;

public interface BlockService {

	String addBlock(Block block);

	List<Block> getAllBlock();

	Block getBlockById(String id);

	String updateBlock(String b,String id);

	List<Block> displayBlock();

	String deleteBlock(String id);


}
