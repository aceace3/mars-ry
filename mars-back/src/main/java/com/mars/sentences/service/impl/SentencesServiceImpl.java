package com.mars.sentences.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mars.sentences.mapper.SentencesMapper;
import com.mars.sentences.domain.Sentences;
import com.mars.sentences.service.ISentencesService;

/**
 * 句子Service业务层处理
 *
 * @author zy
 * @date 2022-08-01
 */
@Service
public class SentencesServiceImpl implements ISentencesService
{
    @Autowired
    private SentencesMapper sentencesMapper;

    /**
     * 查询句子
     *
     * @param sentencesId 句子主键
     * @return 句子
     */
    @Override
    public Sentences selectSentencesBySentencesId(Long sentencesId)
    {
        return sentencesMapper.selectSentencesBySentencesId(sentencesId);
    }

    /**
     * 查询句子列表
     *
     * @param sentences 句子
     * @return 句子
     */
    @Override
    public List<Sentences> selectSentencesList(Sentences sentences)
    {
        return sentencesMapper.selectSentencesList(sentences);
    }

    /**
     * 新增句子
     *
     * @param sentences 句子
     * @return 结果
     */
    @Override
    public int insertSentences(Sentences sentences)
    {
        sentences.setCreateTime(DateUtils.getNowDate());
        return sentencesMapper.insertSentences(sentences);
    }

    /**
     * 修改句子
     *
     * @param sentences 句子
     * @return 结果
     */
    @Override
    public int updateSentences(Sentences sentences)
    {
        sentences.setUpdateTime(DateUtils.getNowDate());
        return sentencesMapper.updateSentences(sentences);
    }

    /**
     * 批量删除句子
     *
     * @param sentencesIds 需要删除的句子主键
     * @return 结果
     */
    @Override
    public int deleteSentencesBySentencesIds(Long[] sentencesIds)
    {
        return sentencesMapper.deleteSentencesBySentencesIds(sentencesIds);
    }

    /**
     * 删除句子信息
     *
     * @param sentencesId 句子主键
     * @return 结果
     */
    @Override
    public int deleteSentencesBySentencesId(Long sentencesId)
    {
        return sentencesMapper.deleteSentencesBySentencesId(sentencesId);
    }

    /**
     * 逻辑批量删除句子
     *
     * @param sentencesIds 需要删除的句子主键
     * @return 结果
     */
    @Override
    public int logicDeleteSentencesBySentencesIds(Long[] sentencesIds)
    {
        return sentencesMapper.logicDeleteSentencesBySentencesIds(sentencesIds);
    }

    /**
     * 逻辑删除句子信息
     *
     * @param sentencesId 句子主键
     * @return 结果
     */
    @Override
    public int logicDeleteSentencesBySentencesId(Long sentencesId)
    {
        return sentencesMapper.logicDeleteSentencesBySentencesId(sentencesId);
    }

    /**
     * 随机获取一句
     * */
    public Sentences randomQueryOne(){
        return sentencesMapper.randomQueryOne();
    }
}
