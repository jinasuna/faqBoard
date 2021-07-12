package com.tbl.faq.domain.mappers;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;

public final class TblFaqDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.046+09:00", comments="Source Table: tbl_op_alarm")
    public static final TblOpAlarm tblOpAlarm = new TblOpAlarm();

    /**
     * Database Column Remarks:
     *   operator alarm id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.046+09:00", comments="Source field: tbl_op_alarm.OP_ALARM_ID")
    public static final SqlColumn<Long> opAlarmId = tblOpAlarm.opAlarmId;

    /**
     * Database Column Remarks:
     *   operator id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.046+09:00", comments="Source field: tbl_op_alarm.OP_ID")
    public static final SqlColumn<Long> opId = tblOpAlarm.opId;

    /**
     * Database Column Remarks:
     *   reference id
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.046+09:00", comments="Source field: tbl_op_alarm.REF_ID")
    public static final SqlColumn<Long> refId = tblOpAlarm.refId;

    /**
     * Database Column Remarks:
     *   alarm type(10:강제퇴실 승인요청, 11:강제퇴실 승인, 12:강제퇴실 승인 거부, 21:조기졸업 신청, 22:조기졸업 취소, 31:계약만료 d-7, 32:계약만료 d-day, 41:출입창지 오류, 42:OA기기 오류)
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.046+09:00", comments="Source field: tbl_op_alarm.ALARM_TP")
    public static final SqlColumn<Integer> alarmTp = tblOpAlarm.alarmTp;

    /**
     * Database Column Remarks:
     *   content
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.046+09:00", comments="Source field: tbl_op_alarm.CNTNT")
    public static final SqlColumn<String> cntnt = tblOpAlarm.cntnt;

    /**
     * Database Column Remarks:
     *   registered date
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source field: tbl_op_alarm.REG_DT")
    public static final SqlColumn<Date> regDt = tblOpAlarm.regDt;

    /**
     * Database Column Remarks:
     *   modified date
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source field: tbl_op_alarm.MOD_DT")
    public static final SqlColumn<Date> modDt = tblOpAlarm.modDt;

    /**
     * Database Column Remarks:
     *   read yn(0:no, 1:yes)
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source field: tbl_op_alarm.READ_YN")
    public static final SqlColumn<Boolean> readYn = tblOpAlarm.readYn;

    /**
     * Database Column Remarks:
     *   activate yn(0:no, 1:yes)
     */
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source field: tbl_op_alarm.ACT_YN")
    public static final SqlColumn<Boolean> actYn = tblOpAlarm.actYn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.046+09:00", comments="Source Table: tbl_op_alarm")
    public static final class TblOpAlarm extends SqlTable {
        public final SqlColumn<Long> opAlarmId = column("OP_ALARM_ID", JDBCType.BIGINT);

        public final SqlColumn<Long> opId = column("OP_ID", JDBCType.BIGINT);

        public final SqlColumn<Long> refId = column("REF_ID", JDBCType.BIGINT);

        public final SqlColumn<Integer> alarmTp = column("ALARM_TP", JDBCType.INTEGER);

        public final SqlColumn<String> cntnt = column("CNTNT", JDBCType.VARCHAR);

        public final SqlColumn<Date> regDt = column("REG_DT", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> modDt = column("MOD_DT", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> readYn = column("READ_YN", JDBCType.CHAR);

        public final SqlColumn<Boolean> actYn = column("ACT_YN", JDBCType.CHAR);

        public TblOpAlarm() {
            super("tbl_op_alarm");
        }
    }
}