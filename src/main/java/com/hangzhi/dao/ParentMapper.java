package com.hangzhi.dao;

import com.hangzhi.bean.Parent;
import com.hangzhi.bean.ParentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParentMapper {
    int countByExample(ParentExample example);

    int deleteByExample(ParentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Parent record);

    int insertSelective(Parent record);

    List<Parent> selectByExample(ParentExample example);

    Parent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Parent record, @Param("example") ParentExample example);

    int updateByExample(@Param("record") Parent record, @Param("example") ParentExample example);

    int updateByPrimaryKeySelective(Parent record);

    int updateByPrimaryKey(Parent record);
}