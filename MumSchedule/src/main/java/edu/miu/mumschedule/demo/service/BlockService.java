package edu.miu.mumschedule.demo.service;



import edu.miu.mumschedule.demo.domain.Block;

import java.util.List;



public interface BlockService {

    public void save(Block block);
    public void deleteById(long id);
    public List<Block> findAll();
    public Block findById(long id);

//    public Block getBlockByBlockID(int blockid);
//    public Block getBlockByBlockName(String blockName);
//    public List<Block> getAllBlock();
}
