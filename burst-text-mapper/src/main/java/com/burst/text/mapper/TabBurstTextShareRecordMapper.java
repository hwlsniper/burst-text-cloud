package com.burst.text.mapper;

import com.burst.text.entity.TabBurstTextShareRecord;
import com.burst.text.entity.TabBurstTextShareRecordExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TabBurstTextShareRecordMapper {
    long countByExample(TabBurstTextShareRecordExample example);

    int deleteByExample(TabBurstTextShareRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(TabBurstTextShareRecord record);

    int insertSelective(TabBurstTextShareRecord record);

    List<TabBurstTextShareRecord> selectByExample(TabBurstTextShareRecordExample example);

    TabBurstTextShareRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TabBurstTextShareRecord record, @Param("example") TabBurstTextShareRecordExample example);

    int updateByExample(@Param("record") TabBurstTextShareRecord record, @Param("example") TabBurstTextShareRecordExample example);

    int updateByPrimaryKeySelective(TabBurstTextShareRecord record);

    int updateByPrimaryKey(TabBurstTextShareRecord record);
}