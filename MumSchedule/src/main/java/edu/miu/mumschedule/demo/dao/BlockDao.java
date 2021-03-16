package edu.miu.mumschedule.demo.dao;

import edu.miu.mumschedule.demo.domain.Block;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public interface BlockDao extends JpaRepository<Block,Long> {



}
