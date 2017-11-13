package cn.blog.dao;

import cn.blog.bean.TokenExample;
import cn.blog.bean.Token;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TokenMapper {
    long countByExample(TokenExample example);

    int deleteByExample(TokenExample example);

    int insert(Token record);

    int insertSelective(Token record);

    List<Token> selectByExample(TokenExample example);

    int updateByExampleSelective(@Param("record") Token record, @Param("example") TokenExample example);

    int updateByExample(@Param("record") Token record, @Param("example") TokenExample example);
}