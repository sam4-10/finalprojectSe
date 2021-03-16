package edu.miu.mumschedule.demo.serviceImpl;


import edu.miu.mumschedule.demo.dao.BlockDao;
import edu.miu.mumschedule.demo.domain.Block;
import edu.miu.mumschedule.demo.service.BlockServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockServiceInterface {

@Autowired
BlockDao blockRepository;
    @Override
    public List<Block> findAll() {
        return blockRepository.findAll();
    }

    @Override
    public void save(Block block) {
        blockRepository.save(block);
    }

    @Override
    public Block findById(Long blockid) {
        return blockRepository.findById(blockid).get();
    }

    @Override
    public void deleteById(Long id) {
        blockRepository.deleteById(id);
    }
}
