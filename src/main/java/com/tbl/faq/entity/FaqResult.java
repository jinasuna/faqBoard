package com.tbl.faq.entity;

import lombok.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
public class FaqResult {

    private int id;

    private int categoryId;

    private boolean openType;

    private String subject;

    private String content;

    private int viewCnt;

    private Date regDate;

    private Date modDate;

    private boolean actYn;

    private List<Faq> result;

}

