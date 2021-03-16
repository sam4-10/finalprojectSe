package edu.miu.mumschedule.demo.scheduleBuilderSubSystem;



import edu.miu.mumschedule.demo.domain.Entry;

import java.util.List;

public abstract class ScheduleBuilder {

public final  void buildSchedule(){
         getEntry();
}
    abstract List<Entry>  getEntry();
}
