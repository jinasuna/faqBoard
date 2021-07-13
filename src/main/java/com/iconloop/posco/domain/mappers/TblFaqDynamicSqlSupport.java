package com.iconloop.posco.domain.mappers;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TblFaqDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8331862+09:00", comments="Source Table: tbl_faq")
    public static final TblFaq tblFaq = new TblFaq();

    /**
     * Database Column Remarks:
     *   faq id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8341873+09:00", comments="Source field: tbl_faq.FAQ_ID")
    public static final SqlColumn<Integer> faqId = tblFaq.faqId;

    /**
     * Database Column Remarks:
     *   faq category id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8361889+09:00", comments="Source field: tbl_faq.FAQ_CTGR_ID")
    public static final SqlColumn<Integer> faqCtgrId = tblFaq.faqCtgrId;

    /**
     * Database Column Remarks:
     *   open type(0:unopened, 1:opened)
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8371862+09:00", comments="Source field: tbl_faq.OPEN_TP")
    public static final SqlColumn<Boolean> openTp = tblFaq.openTp;

    /**
     * Database Column Remarks:
     *   subject
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8371862+09:00", comments="Source field: tbl_faq.SBJ")
    public static final SqlColumn<String> sbj = tblFaq.sbj;

    /**
     * Database Column Remarks:
     *   content
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8371862+09:00", comments="Source field: tbl_faq.CNTNT")
    public static final SqlColumn<String> cntnt = tblFaq.cntnt;

    /**
     * Database Column Remarks:
     *   view count
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8371862+09:00", comments="Source field: tbl_faq.VIEW_CNT")
    public static final SqlColumn<Integer> viewCnt = tblFaq.viewCnt;

    /**
     * Database Column Remarks:
     *   registered date
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8381862+09:00", comments="Source field: tbl_faq.REG_DT")
    public static final SqlColumn<Date> regDt = tblFaq.regDt;

    /**
     * Database Column Remarks:
     *   modified date
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8381862+09:00", comments="Source field: tbl_faq.MOD_DT")
    public static final SqlColumn<Date> modDt = tblFaq.modDt;

    /**
     * Database Column Remarks:
     *   activate yn(0:no, 1:yes)
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8381862+09:00", comments="Source field: tbl_faq.ACT_YN")
    public static final SqlColumn<Boolean> actYn = tblFaq.actYn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8341873+09:00", comments="Source Table: tbl_faq")
    public static final class TblFaq extends SqlTable {
        public final SqlColumn<Integer> faqId = column("FAQ_ID", JDBCType.INTEGER);

        public final SqlColumn<Integer> faqCtgrId = column("FAQ_CTGR_ID", JDBCType.INTEGER);

        public final SqlColumn<Boolean> openTp = column("OPEN_TP", JDBCType.BIT);

        public final SqlColumn<String> sbj = column("SBJ", JDBCType.VARCHAR);

        public final SqlColumn<String> cntnt = column("CNTNT", JDBCType.VARCHAR);

        public final SqlColumn<Integer> viewCnt = column("VIEW_CNT", JDBCType.INTEGER);

        public final SqlColumn<Date> regDt = column("REG_DT", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> modDt = column("MOD_DT", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> actYn = column("ACT_YN", JDBCType.BIT);

        public TblFaq() {
            super("tbl_faq");
        }
    }
}