package edu.miu.mumschedule.demo.scheduleBuilderSubSystem;


import edu.miu.mumschedule.demo.domain.Entry;
import edu.miu.mumschedule.demo.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SchedulBuilderFacade extends ScheduleBuilder{

    @Autowired
    EntryService entryService;
    @Override
   List<Entry>  getEntry() {
        return entryService.findAll() ;
    }
}
