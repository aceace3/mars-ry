package com.mars.billboard.mapper;

import java.util.List;
import com.mars.billboard.domain.Billboard;

/**
 * 公告管理Mapper接口
 * 
 * @author zy
 * @date 2022-08-02
 */
public interface BillboardMapper 
{
    /**
     * 查询公告管理
     * 
     * @param billboardId 公告管理主键
     * @return 公告管理
     */
    public Billboard selectBillboardByBillboardId(Long billboardId);

    /**
     * 查询公告管理列表
     * 
     * @param billboard 公告管理
     * @return 公告管理集合
     */
    public List<Billboard> selectBillboardList(Billboard billboard);

    /**
     * 新增公告管理
     * 
     * @param billboard 公告管理
     * @return 结果
     */
    public int insertBillboard(Billboard billboard);

    /**
     * 修改公告管理
     * 
     * @param billboard 公告管理
     * @return 结果
     */
    public int updateBillboard(Billboard billboard);

    /**
     * 删除公告管理
     * 
     * @param billboardId 公告管理主键
     * @return 结果
     */
    public int deleteBillboardByBillboardId(Long billboardId);

    /**
     * 批量删除公告管理
     * 
     * @param billboardIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBillboardByBillboardIds(Long[] billboardIds);
}
