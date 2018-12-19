package top.doperj.product.dao;

import top.doperj.product.domain.AttributeSet;

public interface AttributeSetMapper {
    int deleteByPrimaryKey(Integer attributeSetId);

    int insert(AttributeSet record);

    int insertSelective(AttributeSet record);

    AttributeSet selectByPrimaryKey(Integer attributeSetId);

    int updateByPrimaryKeySelective(AttributeSet record);

    int updateByPrimaryKey(AttributeSet record);
}