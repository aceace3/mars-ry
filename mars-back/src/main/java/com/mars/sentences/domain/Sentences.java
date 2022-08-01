package com.mars.sentences.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 句子对象 mars_sentences
 * 
 * @author zy
 * @date 2022-08-01
 */
public class Sentences extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 句子id */
    private Long sentencesId;

    /** 句子内容text */
    @Excel(name = "句子内容text")
    private String contentText;

    /** 句子内容html */
    @Excel(name = "句子内容html")
    private String contentHtml;

    /** 来源 */
    @Excel(name = "来源")
    private String source;

    /** 置顶 */
    @Excel(name = "置顶")
    private String isTop;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 投稿者 */
    @Excel(name = "投稿者")
    private String author;

    /** 投稿者email */
    @Excel(name = "投稿者email")
    private String authorEmail;

    /** 投稿者的话 */
    @Excel(name = "投稿者的话")
    private String authorTalk;

    /** 1-已发布/2-审核中 */
    @Excel(name = "1-已发布/2-审核中")
    private Long type;

    /** 允许展示email */
    @Excel(name = "允许展示email")
    private String permitShowEmail;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 删除标记 */
    private String delFlag;

    public void setSentencesId(Long sentencesId) 
    {
        this.sentencesId = sentencesId;
    }

    public Long getSentencesId() 
    {
        return sentencesId;
    }
    public void setContentText(String contentText) 
    {
        this.contentText = contentText;
    }

    public String getContentText() 
    {
        return contentText;
    }
    public void setContentHtml(String contentHtml) 
    {
        this.contentHtml = contentHtml;
    }

    public String getContentHtml() 
    {
        return contentHtml;
    }
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getSource() 
    {
        return source;
    }
    public void setIsTop(String isTop) 
    {
        this.isTop = isTop;
    }

    public String getIsTop() 
    {
        return isTop;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }
    public void setAuthorEmail(String authorEmail) 
    {
        this.authorEmail = authorEmail;
    }

    public String getAuthorEmail() 
    {
        return authorEmail;
    }
    public void setAuthorTalk(String authorTalk) 
    {
        this.authorTalk = authorTalk;
    }

    public String getAuthorTalk() 
    {
        return authorTalk;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setPermitShowEmail(String permitShowEmail) 
    {
        this.permitShowEmail = permitShowEmail;
    }

    public String getPermitShowEmail() 
    {
        return permitShowEmail;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
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
            .append("sentencesId", getSentencesId())
            .append("contentText", getContentText())
            .append("contentHtml", getContentHtml())
            .append("source", getSource())
            .append("isTop", getIsTop())
            .append("userId", getUserId())
            .append("author", getAuthor())
            .append("authorEmail", getAuthorEmail())
            .append("authorTalk", getAuthorTalk())
            .append("type", getType())
            .append("permitShowEmail", getPermitShowEmail())
            .append("sort", getSort())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
