package com.mars.sentences.controller;

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
import com.mars.sentences.domain.Sentences;
import com.mars.sentences.service.ISentencesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 句子Controller
 *
 * @author zy
 * @date 2022-08-01
 */
@RestController
@RequestMapping("/mars/sentences")
public class SentencesController extends BaseController
{
    @Autowired
    private ISentencesService sentencesService;

    /**
     * 查询句子列表
     */
    @PreAuthorize("@ss.hasPermi('mars:sentences:list')")
    @GetMapping("/list")
    public TableDataInfo list(Sentences sentences)
    {
        startPage();
        List<Sentences> list = sentencesService.selectSentencesList(sentences);
        return getDataTable(list);
    }

    /**
     * 导出句子列表
     */
    @PreAuthorize("@ss.hasPermi('mars:sentences:export')")
    @Log(title = "句子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Sentences sentences)
    {
        List<Sentences> list = sentencesService.selectSentencesList(sentences);
        ExcelUtil<Sentences> util = new ExcelUtil<Sentences>(Sentences.class);
        util.exportExcel(response, list, "句子数据。");
    }

    /**
     * 获取句子详细信息
     */
    @PreAuthorize("@ss.hasPermi('mars:sentences:query')")
    @GetMapping(value = "/{sentencesId}")
    public AjaxResult getInfo(@PathVariable("sentencesId") Long sentencesId)
    {
        return AjaxResult.success(sentencesService.selectSentencesBySentencesId(sentencesId));
    }

    /**
     * 新增句子
     */
    @PreAuthorize("@ss.hasPermi('mars:sentences:add')")
    @Log(title = "句子", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Sentences sentences)
    {
        return toAjax(sentencesService.insertSentences(sentences));
    }

    /**
     * 修改句子
     */
    @PreAuthorize("@ss.hasPermi('mars:sentences:edit')")
    @Log(title = "句子", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Sentences sentences)
    {
        return toAjax(sentencesService.updateSentences(sentences));
    }

    /**
     * 删除句子
     */
    @PreAuthorize("@ss.hasPermi('mars:sentences:remove')")
    @Log(title = "句子", businessType = BusinessType.DELETE)
	@DeleteMapping("/{sentencesIds}")
    public AjaxResult remove(@PathVariable Long[] sentencesIds)
    {
        return toAjax(sentencesService.deleteSentencesBySentencesIds(sentencesIds));
    }
}
