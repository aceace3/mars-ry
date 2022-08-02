package com.mars.billboard.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公告管理对象 mars_billboard
 * 
 * @author zy
 * @date 2022-08-02
 */
public class Billboard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公告板id */
    private Long billboardId;

    /** 标题 */
    @Excel(name = "标题")
    private String billboardTitle;

    /** 内容 */
    @Excel(name = "内容")
    private String billboardContent;

    /** 置顶 */
    @Excel(name = "置顶")
    private String isTop;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 删除标记 */
    private String delFlag;

    public void setBillboardId(Long billboardId) 
    {
        this.billboardId = billboardId;
    }

    public Long getBillboardId() 
    {
        return billboardId;
    }
    public void setBillboardTitle(String billboardTitle) 
    {
        this.billboardTitle = billboardTitle;
    }

    public String getBillboardTitle() 
    {
        return billboardTitle;
    }
    public void setBillboardContent(String billboardContent) 
    {
        this.billboardContent = billboardContent;
    }

    public String getBillboardContent() 
    {
        return billboardContent;
    }
    public void setIsTop(String isTop) 
    {
        this.isTop = isTop;
    }

    public String getIsTop() 
    {
        return isTop;
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
            .append("billboardId", getBillboardId())
            .append("billboardTitle", getBillboardTitle())
            .append("billboardContent", getBillboardContent())
            .append("isTop", getIsTop())
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
