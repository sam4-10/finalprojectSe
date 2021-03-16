package edu.miu.mumschedule.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String month;
    private String year;


//    private String entryName;
//    private int FPPNum;
//    private int MPPNum;
//    private String startDate;
//    private String endDate;


    @OneToMany()
    @JoinColumn(name = "entry_id")
    private Set<Block> blockList = new HashSet<Block>();



//    public void addBlock(Block block) {
//        blockList.add(block);
//        block.setEntry(this);
//    }
//    public String getEntryName() {
//        return entryName;
//    }
//
//    public void setEntryName(String entryName) {
//        this.entryName = entryName;
//    }
}
