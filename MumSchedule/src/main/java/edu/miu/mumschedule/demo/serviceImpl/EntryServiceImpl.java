package edu.miu.mumschedule.demo.serviceImpl;


import edu.miu.mumschedule.demo.dao.EntryDao;
import edu.miu.mumschedule.demo.domain.Entry;
import edu.miu.mumschedule.demo.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    EntryDao entryDao;

    @Override
    public void save(Entry entry) {
        entryDao.save(entry);
        return;
    }

    @Override
    public void deleteById(long id) {
        entryDao.deleteById(id);
    }

    @Override
    public List<Entry> findAll() {
        return entryDao.findAll();
    }

    @Override
    public Entry findById(long id) {
        Optional<Entry> result = entryDao.findById(id);
        Entry theEntry=null;
        if(result.isPresent()){
            theEntry= result.get();
        }else{
            throw new RuntimeException("Did Not Find Entry Id: "+ id);
        }
        return theEntry;
    }
//    @Override
//    public List<Entry> getAllEntry(){
//        return entryDao.getAllEntry();
//    }
//
//    @Override
//    public Entry getEntryByEntryName(String entryName) {
//        return entryDao.findEntryByEntryName(entryName);
//    }
//
//    @Override
//    public Entry getEntryByEntryID(int entryid) {
//        return entryDao.findEntryByEntryID(entryid);
//    }
}
