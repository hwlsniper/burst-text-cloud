package com.burst.text.mapper;

import com.burst.text.entity.TabBurstTextBrowseRecord;
import com.burst.text.entity.TabBurstTextBrowseRecordExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TabBurstTextBrowseRecordMapper {
    long countByExample(TabBurstTextBrowseRecordExample example);

    int deleteByExample(TabBurstTextBrowseRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(TabBurstTextBrowseRecord record);

    int insertSelective(TabBurstTextBrowseRecord record);

    List<TabBurstTextBrowseRecord> selectByExample(TabBurstTextBrowseRecordExample example);

    TabBurstTextBrowseRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TabBurstTextBrowseRecord record, @Param("example") TabBurstTextBrowseRecordExample example);

    int updateByExample(@Param("record") TabBurstTextBrowseRecord record, @Param("example") TabBurstTextBrowseRecordExample example);

    int updateByPrimaryKeySelective(TabBurstTextBrowseRecord record);

    int updateByPrimaryKey(TabBurstTextBrowseRecord record);
}