package edu.miu.mumschedule.demo.service;



import edu.miu.mumschedule.demo.domain.Block;

import java.util.List;

public interface BlockServiceInterface {
    List<Block> findAll();

    void save(Block block);

    Block findById(Long blockid);

    void deleteById(Long id);
}
