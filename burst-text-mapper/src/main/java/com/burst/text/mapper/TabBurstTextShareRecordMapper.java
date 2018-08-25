package com.burst.text.mapper;

import com.burst.text.entity.TabBurstTextShareRecord;
import com.burst.text.entity.TabBurstTextShareRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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