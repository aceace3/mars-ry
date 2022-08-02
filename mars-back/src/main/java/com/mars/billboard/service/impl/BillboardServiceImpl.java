package com.mars.billboard.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mars.billboard.mapper.BillboardMapper;
import com.mars.billboard.domain.Billboard;
import com.mars.billboard.service.IBillboardService;

/**
 * 公告管理Service业务层处理
 * 
 * @author zy
 * @date 2022-08-02
 */
@Service
public class BillboardServiceImpl implements IBillboardService 
{
    @Autowired
    private BillboardMapper billboardMapper;

    /**
     * 查询公告管理
     * 
     * @param billboardId 公告管理主键
     * @return 公告管理
     */
    @Override
    public Billboard selectBillboardByBillboardId(Long billboardId)
    {
        return billboardMapper.selectBillboardByBillboardId(billboardId);
    }

    /**
     * 查询公告管理列表
     * 
     * @param billboard 公告管理
     * @return 公告管理
     */
    @Override
    public List<Billboard> selectBillboardList(Billboard billboard)
    {
        return billboardMapper.selectBillboardList(billboard);
    }

    /**
     * 新增公告管理
     * 
     * @param billboard 公告管理
     * @return 结果
     */
    @Override
    public int insertBillboard(Billboard billboard)
    {
        billboard.setCreateTime(DateUtils.getNowDate());
        return billboardMapper.insertBillboard(billboard);
    }

    /**
     * 修改公告管理
     * 
     * @param billboard 公告管理
     * @return 结果
     */
    @Override
    public int updateBillboard(Billboard billboard)
    {
        billboard.setUpdateTime(DateUtils.getNowDate());
        return billboardMapper.updateBillboard(billboard);
    }

    /**
     * 批量删除公告管理
     * 
     * @param billboardIds 需要删除的公告管理主键
     * @return 结果
     */
    @Override
    public int deleteBillboardByBillboardIds(Long[] billboardIds)
    {
        return billboardMapper.deleteBillboardByBillboardIds(billboardIds);
    }

    /**
     * 删除公告管理信息
     * 
     * @param billboardId 公告管理主键
     * @return 结果
     */
    @Override
    public int deleteBillboardByBillboardId(Long billboardId)
    {
        return billboardMapper.deleteBillboardByBillboardId(billboardId);
    }
}
