package com.mars.sentencescollection.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 句子收藏管理对象 mars_sentences_collection
 * 
 * @author zy
 * @date 2022-08-01
 */
public class SentencesCollection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 收藏id */
    private Long collectionId;

    /** 句子id */
    @Excel(name = "句子id")
    private Long sentencesId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 删除标记 */
    private String delFlag;

    public void setCollectionId(Long collectionId) 
    {
        this.collectionId = collectionId;
    }

    public Long getCollectionId() 
    {
        return collectionId;
    }
    public void setSentencesId(Long sentencesId) 
    {
        this.sentencesId = sentencesId;
    }

    public Long getSentencesId() 
    {
        return sentencesId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("collectionId", getCollectionId())
            .append("sentencesId", getSentencesId())
            .append("userId", getUserId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
