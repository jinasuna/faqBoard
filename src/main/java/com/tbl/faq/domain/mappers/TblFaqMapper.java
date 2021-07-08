package com.tbl.faq.domain.mappers;

import com.tbl.faq.domain.dao.TblFaq;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import javax.annotation.Generated;
import java.util.List;
import java.util.function.Function;

import static com.tbl.faq.domain.mappers.TblFaqDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface TblFaqMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.opAlarmId")
    int insert(InsertStatementProvider<TblOpAlarm> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TblOpAlarmResult")
    TblOpAlarm selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TblOpAlarmResult")
    List<TblOpAlarm> selectManyWithRowbounds(SelectStatementProvider selectStatement, RowBounds rowBounds);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    default Function<SelectStatementProvider, List<TblOpAlarm>> selectManyWithRowbounds(RowBounds rowBounds) {
        return selectStatement -> selectManyWithRowbounds(selectStatement, rowBounds);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TblOpAlarmResult", value = {
        @Result(column="OP_ALARM_ID", property="opAlarmId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="OP_ID", property="opId", jdbcType=JdbcType.BIGINT),
        @Result(column="REF_ID", property="refId", jdbcType=JdbcType.BIGINT),
        @Result(column="ALARM_TP", property="alarmTp", jdbcType=JdbcType.INTEGER),
        @Result(column="CNTNT", property="cntnt", jdbcType=JdbcType.VARCHAR),
        @Result(column="REG_DT", property="regDt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MOD_DT", property="modDt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="READ_YN", property="readYn", jdbcType=JdbcType.CHAR),
        @Result(column="ACT_YN", property="actYn", jdbcType=JdbcType.CHAR)
    })
    List<TblOpAlarm> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(tblOpAlarm);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, tblOpAlarm);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    default int deleteByPrimaryKey(Long opAlarmId_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, tblOpAlarm)
                .where(opAlarmId, isEqualTo(opAlarmId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    default int insert(TblOpAlarm record) {
        return insert(SqlBuilder.insert(record)
                .into(tblOpAlarm)
                .map(opId).toProperty("opId")
                .map(refId).toProperty("refId")
                .map(alarmTp).toProperty("alarmTp")
                .map(cntnt).toProperty("cntnt")
                .map(regDt).toProperty("regDt")
                .map(modDt).toProperty("modDt")
                .map(readYn).toProperty("readYn")
                .map(actYn).toProperty("actYn")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    default int insertSelective(TblOpAlarm record) {
        return insert(SqlBuilder.insert(record)
                .into(tblOpAlarm)
                .map(opId).toPropertyWhenPresent("opId", record::getOpId)
                .map(refId).toPropertyWhenPresent("refId", record::getRefId)
                .map(alarmTp).toPropertyWhenPresent("alarmTp", record::getAlarmTp)
                .map(cntnt).toPropertyWhenPresent("cntnt", record::getCntnt)
                .map(regDt).toPropertyWhenPresent("regDt", record::getRegDt)
                .map(modDt).toPropertyWhenPresent("modDt", record::getModDt)
                .map(readYn).toPropertyWhenPresent("readYn", record::getReadYn)
                .map(actYn).toPropertyWhenPresent("actYn", record::getActYn)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<TblOpAlarm>>> selectByExample(RowBounds rowBounds) {
        return SelectDSL.selectWithMapper(selectManyWithRowbounds(rowBounds), opAlarmId, opId, refId, alarmTp, cntnt, regDt, modDt, readYn, actYn)
                .from(tblOpAlarm);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<TblOpAlarm>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, opAlarmId, opId, refId, alarmTp, cntnt, regDt, modDt, readYn, actYn)
                .from(tblOpAlarm);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<TblOpAlarm>>> selectDistinctByExample(RowBounds rowBounds) {
        return SelectDSL.selectDistinctWithMapper(selectManyWithRowbounds(rowBounds), opAlarmId, opId, refId, alarmTp, cntnt, regDt, modDt, readYn, actYn)
                .from(tblOpAlarm);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<TblOpAlarm>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, opAlarmId, opId, refId, alarmTp, cntnt, regDt, modDt, readYn, actYn)
                .from(tblOpAlarm);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    default TblOpAlarm selectByPrimaryKey(Long opAlarmId_) {
        return SelectDSL.selectWithMapper(this::selectOne, opAlarmId, opId, refId, alarmTp, cntnt, regDt, modDt, readYn, actYn)
                .from(tblOpAlarm)
                .where(opAlarmId, isEqualTo(opAlarmId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(TblOpAlarm record) {
        return UpdateDSL.updateWithMapper(this::update, tblOpAlarm)
                .set(opId).equalTo(record::getOpId)
                .set(refId).equalTo(record::getRefId)
                .set(alarmTp).equalTo(record::getAlarmTp)
                .set(cntnt).equalTo(record::getCntnt)
                .set(regDt).equalTo(record::getRegDt)
                .set(modDt).equalTo(record::getModDt)
                .set(readYn).equalTo(record::getReadYn)
                .set(actYn).equalTo(record::getActYn);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(TblOpAlarm record) {
        return UpdateDSL.updateWithMapper(this::update, tblOpAlarm)
                .set(opId).equalToWhenPresent(record::getOpId)
                .set(refId).equalToWhenPresent(record::getRefId)
                .set(alarmTp).equalToWhenPresent(record::getAlarmTp)
                .set(cntnt).equalToWhenPresent(record::getCntnt)
                .set(regDt).equalToWhenPresent(record::getRegDt)
                .set(modDt).equalToWhenPresent(record::getModDt)
                .set(readYn).equalToWhenPresent(record::getReadYn)
                .set(actYn).equalToWhenPresent(record::getActYn);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    default int updateByPrimaryKey(TblOpAlarm record) {
        return UpdateDSL.updateWithMapper(this::update, tblOpAlarm)
                .set(opId).equalTo(record::getOpId)
                .set(refId).equalTo(record::getRefId)
                .set(alarmTp).equalTo(record::getAlarmTp)
                .set(cntnt).equalTo(record::getCntnt)
                .set(regDt).equalTo(record::getRegDt)
                .set(modDt).equalTo(record::getModDt)
                .set(readYn).equalTo(record::getReadYn)
                .set(actYn).equalTo(record::getActYn)
                .where(opAlarmId, isEqualTo(record::getOpAlarmId))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-05-26T14:23:20.047+09:00", comments="Source Table: tbl_op_alarm")
    default int updateByPrimaryKeySelective(TblOpAlarm record) {
        return UpdateDSL.updateWithMapper(this::update, tblOpAlarm)
                .set(opId).equalToWhenPresent(record::getOpId)
                .set(refId).equalToWhenPresent(record::getRefId)
                .set(alarmTp).equalToWhenPresent(record::getAlarmTp)
                .set(cntnt).equalToWhenPresent(record::getCntnt)
                .set(regDt).equalToWhenPresent(record::getRegDt)
                .set(modDt).equalToWhenPresent(record::getModDt)
                .set(readYn).equalToWhenPresent(record::getReadYn)
                .set(actYn).equalToWhenPresent(record::getActYn)
                .where(opAlarmId, isEqualTo(record::getOpAlarmId))
                .build()
                .execute();
    }
}