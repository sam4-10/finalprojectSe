package edu.miu.mumschedule.demo.domain;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long blockID;

    private String blockName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
//    private int FPPNum;
//    private int MPPNum;
//    private String entryName;

//    @JoinColumn(name ="entryid",nullable = false)
//    @ManyToOne(fetch = FetchType.EAGER)
//    private Entry entry;
    @OneToMany()
    @JoinColumn(name = "block_id")
Set<Course> courses = new HashSet<>();

    @OneToMany()
    @JoinColumn(name = "section_id")
    Set<Section> sections = new HashSet<>();

}
