package com.tbl.faq.domain.dto;

import com.tbl.faq.domain.dao.TblFaq;
import lombok.*;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@ToString
public class FaqInfo {

    private int id;

    private int categoryId;

    private boolean openType;

    private String subject;

    private String content;

    private int viewCnt;

    private Date regDate;

    private Date modDate;

    private boolean actYn;

    private List<TblFaq> result;

}

