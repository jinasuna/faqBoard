package com.iconloop.posco.domain.mappers;

import static com.iconloop.posco.domain.mappers.TblFaqDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.iconloop.posco.domain.dao.TblFaq;
import java.util.List;
import java.util.function.Function;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
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

@Mapper
public interface TblFaqMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8401873+09:00", comments="Source Table: tbl_faq")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8421874+09:00", comments="Source Table: tbl_faq")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8431869+09:00", comments="Source Table: tbl_faq")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.faqId")
    int insert(InsertStatementProvider<TblFaq> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8451872+09:00", comments="Source Table: tbl_faq")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TblFaqResult")
    TblFaq selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8471884+09:00", comments="Source Table: tbl_faq")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TblFaqResult")
    List<TblFaq> selectManyWithRowbounds(SelectStatementProvider selectStatement, RowBounds rowBounds);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8481919+09:00", comments="Source Table: tbl_faq")
    default Function<SelectStatementProvider, List<TblFaq>> selectManyWithRowbounds(RowBounds rowBounds) {
        return selectStatement -> selectManyWithRowbounds(selectStatement, rowBounds);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8471884+09:00", comments="Source Table: tbl_faq")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TblFaqResult", value = {
        @Result(column="FAQ_ID", property="faqId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="FAQ_CTGR_ID", property="faqCtgrId", jdbcType=JdbcType.INTEGER),
        @Result(column="OPEN_TP", property="openTp", jdbcType=JdbcType.BIT),
        @Result(column="SBJ", property="sbj", jdbcType=JdbcType.VARCHAR),
        @Result(column="CNTNT", property="cntnt", jdbcType=JdbcType.VARCHAR),
        @Result(column="VIEW_CNT", property="viewCnt", jdbcType=JdbcType.INTEGER),
        @Result(column="REG_DT", property="regDt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="MOD_DT", property="modDt", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ACT_YN", property="actYn", jdbcType=JdbcType.BIT)
    })
    List<TblFaq> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8491883+09:00", comments="Source Table: tbl_faq")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8501901+09:00", comments="Source Table: tbl_faq")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(tblFaq);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8521889+09:00", comments="Source Table: tbl_faq")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, tblFaq);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8541902+09:00", comments="Source Table: tbl_faq")
    default int deleteByPrimaryKey(Integer faqId_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, tblFaq)
                .where(faqId, isEqualTo(faqId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8561909+09:00", comments="Source Table: tbl_faq")
    default int insert(TblFaq record) {
        return insert(SqlBuilder.insert(record)
                .into(tblFaq)
                .map(faqCtgrId).toProperty("faqCtgrId")
                .map(openTp).toProperty("openTp")
                .map(sbj).toProperty("sbj")
                .map(cntnt).toProperty("cntnt")
                .map(viewCnt).toProperty("viewCnt")
                .map(regDt).toProperty("regDt")
                .map(modDt).toProperty("modDt")
                .map(actYn).toProperty("actYn")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.858191+09:00", comments="Source Table: tbl_faq")
    default int insertSelective(TblFaq record) {
        return insert(SqlBuilder.insert(record)
                .into(tblFaq)
                .map(faqCtgrId).toPropertyWhenPresent("faqCtgrId", record::getFaqCtgrId)
                .map(openTp).toPropertyWhenPresent("openTp", record::getOpenTp)
                .map(sbj).toPropertyWhenPresent("sbj", record::getSbj)
                .map(cntnt).toPropertyWhenPresent("cntnt", record::getCntnt)
                .map(viewCnt).toPropertyWhenPresent("viewCnt", record::getViewCnt)
                .map(regDt).toPropertyWhenPresent("regDt", record::getRegDt)
                .map(modDt).toPropertyWhenPresent("modDt", record::getModDt)
                .map(actYn).toPropertyWhenPresent("actYn", record::getActYn)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8601911+09:00", comments="Source Table: tbl_faq")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<TblFaq>>> selectByExample(RowBounds rowBounds) {
        return SelectDSL.selectWithMapper(selectManyWithRowbounds(rowBounds), faqId, faqCtgrId, openTp, sbj, cntnt, viewCnt, regDt, modDt, actYn)
                .from(tblFaq);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8601911+09:00", comments="Source Table: tbl_faq")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<TblFaq>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, faqId, faqCtgrId, openTp, sbj, cntnt, viewCnt, regDt, modDt, actYn)
                .from(tblFaq);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8651903+09:00", comments="Source Table: tbl_faq")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<TblFaq>>> selectDistinctByExample(RowBounds rowBounds) {
        return SelectDSL.selectDistinctWithMapper(selectManyWithRowbounds(rowBounds), faqId, faqCtgrId, openTp, sbj, cntnt, viewCnt, regDt, modDt, actYn)
                .from(tblFaq);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8651903+09:00", comments="Source Table: tbl_faq")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<TblFaq>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, faqId, faqCtgrId, openTp, sbj, cntnt, viewCnt, regDt, modDt, actYn)
                .from(tblFaq);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8701895+09:00", comments="Source Table: tbl_faq")
    default TblFaq selectByPrimaryKey(Integer faqId_) {
        return SelectDSL.selectWithMapper(this::selectOne, faqId, faqCtgrId, openTp, sbj, cntnt, viewCnt, regDt, modDt, actYn)
                .from(tblFaq)
                .where(faqId, isEqualTo(faqId_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8721905+09:00", comments="Source Table: tbl_faq")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(TblFaq record) {
        return UpdateDSL.updateWithMapper(this::update, tblFaq)
                .set(faqCtgrId).equalTo(record::getFaqCtgrId)
                .set(openTp).equalTo(record::getOpenTp)
                .set(sbj).equalTo(record::getSbj)
                .set(cntnt).equalTo(record::getCntnt)
                .set(viewCnt).equalTo(record::getViewCnt)
                .set(regDt).equalTo(record::getRegDt)
                .set(modDt).equalTo(record::getModDt)
                .set(actYn).equalTo(record::getActYn);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.874195+09:00", comments="Source Table: tbl_faq")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(TblFaq record) {
        return UpdateDSL.updateWithMapper(this::update, tblFaq)
                .set(faqCtgrId).equalToWhenPresent(record::getFaqCtgrId)
                .set(openTp).equalToWhenPresent(record::getOpenTp)
                .set(sbj).equalToWhenPresent(record::getSbj)
                .set(cntnt).equalToWhenPresent(record::getCntnt)
                .set(viewCnt).equalToWhenPresent(record::getViewCnt)
                .set(regDt).equalToWhenPresent(record::getRegDt)
                .set(modDt).equalToWhenPresent(record::getModDt)
                .set(actYn).equalToWhenPresent(record::getActYn);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8751917+09:00", comments="Source Table: tbl_faq")
    default int updateByPrimaryKey(TblFaq record) {
        return UpdateDSL.updateWithMapper(this::update, tblFaq)
                .set(faqCtgrId).equalTo(record::getFaqCtgrId)
                .set(openTp).equalTo(record::getOpenTp)
                .set(sbj).equalTo(record::getSbj)
                .set(cntnt).equalTo(record::getCntnt)
                .set(viewCnt).equalTo(record::getViewCnt)
                .set(regDt).equalTo(record::getRegDt)
                .set(modDt).equalTo(record::getModDt)
                .set(actYn).equalTo(record::getActYn)
                .where(faqId, isEqualTo(record::getFaqId))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-07-14T07:33:51.8771902+09:00", comments="Source Table: tbl_faq")
    default int updateByPrimaryKeySelective(TblFaq record) {
        return UpdateDSL.updateWithMapper(this::update, tblFaq)
                .set(faqCtgrId).equalToWhenPresent(record::getFaqCtgrId)
                .set(openTp).equalToWhenPresent(record::getOpenTp)
                .set(sbj).equalToWhenPresent(record::getSbj)
                .set(cntnt).equalToWhenPresent(record::getCntnt)
                .set(viewCnt).equalToWhenPresent(record::getViewCnt)
                .set(regDt).equalToWhenPresent(record::getRegDt)
                .set(modDt).equalToWhenPresent(record::getModDt)
                .set(actYn).equalToWhenPresent(record::getActYn)
                .where(faqId, isEqualTo(record::getFaqId))
                .build()
                .execute();
    }
}