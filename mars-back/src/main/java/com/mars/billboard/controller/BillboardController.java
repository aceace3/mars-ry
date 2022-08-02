package com.mars.billboard.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.mars.billboard.domain.Billboard;
import com.mars.billboard.service.IBillboardService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公告管理Controller
 * 
 * @author zy
 * @date 2022-08-02
 */
@RestController
@RequestMapping("/mars/billboard")
public class BillboardController extends BaseController
{
    @Autowired
    private IBillboardService billboardService;

    /**
     * 查询公告管理列表
     */
    @PreAuthorize("@ss.hasPermi('mars:billboard:list')")
    @GetMapping("/list")
    public TableDataInfo list(Billboard billboard)
    {
        startPage();
        List<Billboard> list = billboardService.selectBillboardList(billboard);
        return getDataTable(list);
    }

    /**
     * 导出公告管理列表
     */
    @PreAuthorize("@ss.hasPermi('mars:billboard:export')")
    @Log(title = "公告管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Billboard billboard)
    {
        List<Billboard> list = billboardService.selectBillboardList(billboard);
        ExcelUtil<Billboard> util = new ExcelUtil<Billboard>(Billboard.class);
        util.exportExcel(response, list, "公告管理数据");
    }

    /**
     * 获取公告管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('mars:billboard:query')")
    @GetMapping(value = "/{billboardId}")
    public AjaxResult getInfo(@PathVariable("billboardId") Long billboardId)
    {
        return AjaxResult.success(billboardService.selectBillboardByBillboardId(billboardId));
    }

    /**
     * 新增公告管理
     */
    @PreAuthorize("@ss.hasPermi('mars:billboard:add')")
    @Log(title = "公告管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Billboard billboard)
    {
        return toAjax(billboardService.insertBillboard(billboard));
    }

    /**
     * 修改公告管理
     */
    @PreAuthorize("@ss.hasPermi('mars:billboard:edit')")
    @Log(title = "公告管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Billboard billboard)
    {
        return toAjax(billboardService.updateBillboard(billboard));
    }

    /**
     * 删除公告管理
     */
    @PreAuthorize("@ss.hasPermi('mars:billboard:remove')")
    @Log(title = "公告管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{billboardIds}")
    public AjaxResult remove(@PathVariable Long[] billboardIds)
    {
        return toAjax(billboardService.deleteBillboardByBillboardIds(billboardIds));
    }
}
