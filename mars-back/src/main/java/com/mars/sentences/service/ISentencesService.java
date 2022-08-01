package com.mars.sentences.service;

import java.util.List;
import com.mars.sentences.domain.Sentences;

/**
 * 句子Service接口
 * 
 * @author zy
 * @date 2022-08-01
 */
public interface ISentencesService 
{
    /**
     * 查询句子
     * 
     * @param sentencesId 句子主键
     * @return 句子
     */
    public Sentences selectSentencesBySentencesId(Long sentencesId);

    /**
     * 查询句子列表
     * 
     * @param sentences 句子
     * @return 句子集合
     */
    public List<Sentences> selectSentencesList(Sentences sentences);

    /**
     * 新增句子
     * 
     * @param sentences 句子
     * @return 结果
     */
    public int insertSentences(Sentences sentences);

    /**
     * 修改句子
     * 
     * @param sentences 句子
     * @return 结果
     */
    public int updateSentences(Sentences sentences);

    /**
     * 批量删除句子
     * 
     * @param sentencesIds 需要删除的句子主键集合
     * @return 结果
     */
    public int deleteSentencesBySentencesIds(Long[] sentencesIds);

    /**
     * 删除句子信息
     * 
     * @param sentencesId 句子主键
     * @return 结果
     */
    public int deleteSentencesBySentencesId(Long sentencesId);
}
