package com.mars.sentencescollection.controller;

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
import com.mars.sentencescollection.domain.SentencesCollection;
import com.mars.sentencescollection.service.ISentencesCollectionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 句子收藏管理Controller
 * 
 * @author zy
 * @date 2022-08-01
 */
@RestController
@RequestMapping("/mars/sentencescollection")
public class SentencesCollectionController extends BaseController
{
    @Autowired
    private ISentencesCollectionService sentencesCollectionService;

    /**
     * 查询句子收藏管理列表
     */
    @PreAuthorize("@ss.hasPermi('mars:sentencescollection:list')")
    @GetMapping("/list")
    public TableDataInfo list(SentencesCollection sentencesCollection)
    {
        startPage();
        List<SentencesCollection> list = sentencesCollectionService.selectSentencesCollectionList(sentencesCollection);
        return getDataTable(list);
    }

    /**
     * 导出句子收藏管理列表
     */
    @PreAuthorize("@ss.hasPermi('mars:sentencescollection:export')")
    @Log(title = "句子收藏管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SentencesCollection sentencesCollection)
    {
        List<SentencesCollection> list = sentencesCollectionService.selectSentencesCollectionList(sentencesCollection);
        ExcelUtil<SentencesCollection> util = new ExcelUtil<SentencesCollection>(SentencesCollection.class);
        util.exportExcel(response, list, "句子收藏管理数据");
    }

    /**
     * 获取句子收藏管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('mars:sentencescollection:query')")
    @GetMapping(value = "/{collectionId}")
    public AjaxResult getInfo(@PathVariable("collectionId") Long collectionId)
    {
        return AjaxResult.success(sentencesCollectionService.selectSentencesCollectionByCollectionId(collectionId));
    }

    /**
     * 新增句子收藏管理
     */
    @PreAuthorize("@ss.hasPermi('mars:sentencescollection:add')")
    @Log(title = "句子收藏管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SentencesCollection sentencesCollection)
    {
        return toAjax(sentencesCollectionService.insertSentencesCollection(sentencesCollection));
    }

    /**
     * 修改句子收藏管理
     */
    @PreAuthorize("@ss.hasPermi('mars:sentencescollection:edit')")
    @Log(title = "句子收藏管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SentencesCollection sentencesCollection)
    {
        return toAjax(sentencesCollectionService.updateSentencesCollection(sentencesCollection));
    }

    /**
     * 删除句子收藏管理
     */
    @PreAuthorize("@ss.hasPermi('mars:sentencescollection:remove')")
    @Log(title = "句子收藏管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{collectionIds}")
    public AjaxResult remove(@PathVariable Long[] collectionIds)
    {
        return toAjax(sentencesCollectionService.deleteSentencesCollectionByCollectionIds(collectionIds));
    }
}
