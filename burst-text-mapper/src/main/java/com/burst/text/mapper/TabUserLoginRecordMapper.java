package com.burst.text.mapper;

import com.burst.text.entity.TabUserLoginRecord;
import com.burst.text.entity.TabUserLoginRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TabUserLoginRecordMapper {
    long countByExample(TabUserLoginRecordExample example);

    int deleteByExample(TabUserLoginRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(TabUserLoginRecord record);

    int insertSelective(TabUserLoginRecord record);

    List<TabUserLoginRecord> selectByExample(TabUserLoginRecordExample example);

    TabUserLoginRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TabUserLoginRecord record, @Param("example") TabUserLoginRecordExample example);

    int updateByExample(@Param("record") TabUserLoginRecord record, @Param("example") TabUserLoginRecordExample example);

    int updateByPrimaryKeySelective(TabUserLoginRecord record);

    int updateByPrimaryKey(TabUserLoginRecord record);
}