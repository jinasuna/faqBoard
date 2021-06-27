package com.tbl.faq.entity;
import javax.persistence.*;
import java.util.Date;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tbl_faq")
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faq_id")
    private int id;

    @Column(name = "faq_ctgr_id")
    private int categoryId;

    @Column(name = "open_tp")
    private boolean openType;

    @Column(name = "sbj")
    private String subject;

    @Column(name = "cntnt")
    private String content;

    @Column(name = "view_cnt")
    private int viewCnt;

    @Column(name = "reg_dt")
    private Date regDate;

    @Column(name = "mod_dt")
    private Date modDate;

    @Column(name = "act_yn")
    private boolean actYn;

    @Builder
    public Faq(int id, int categoryId, boolean openType, String subject, String content,
               int viewCnt, boolean actYn){
        super();
        this.id = id;
        this.categoryId = categoryId;
        this.openType = openType;
        this.subject = subject;
        this.content = content;
        this.viewCnt = viewCnt;
        this.actYn = actYn;
    }
}
