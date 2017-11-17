package cn.blog.dao;

import cn.blog.bean.Handle;
import cn.blog.bean.HandleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HandleMapper {
    long countByExample(HandleExample example);

    int deleteByExample(HandleExample example);

    int deleteByPrimaryKey(Integer handleid);

    int insert(Handle record);

    int insertSelective(Handle record);

    List<Handle> selectByExample(HandleExample example);

    Handle selectByPrimaryKey(Integer handleid);

    int updateByExampleSelective(@Param("record") Handle record, @Param("example") HandleExample example);

    int updateByExample(@Param("record") Handle record, @Param("example") HandleExample example);

    int updateByPrimaryKeySelective(Handle record);

    int updateByPrimaryKey(Handle record);
}