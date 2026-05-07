package tech.csm.service;

import java.util.List;

import tech.csm.dao.BlockDao;
import tech.csm.entity.Block;
import tech.csm.entity.State;

public class BlockServiceImpl implements BlockService {
	
	BlockDao blockDao;

	public BlockServiceImpl(BlockDao blockDao) {
		this.blockDao = blockDao;
	}

	@Override
	public String addBlock(Block block) {
		return blockDao.addBlock(block);
	}

	@Override
	public List<Block> getAllBlock() {
		return blockDao.getAllBlock();
	}

	@Override
	public Block getBlockById(String id) {
		return blockDao.getBlockById(id);
	}

	@Override
	public String updateBlock(String b,String id) {
		return blockDao.updateBlock(b,id);
	}

	@Override
	public List<Block> displayBlock() {
		return blockDao.displayBlock();
	}

	@Override
	public String deleteBlock(String id) {
		return blockDao.deleteBlock(id);
	}
	
	
	

}
