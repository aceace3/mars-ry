package com.mars.sentences.mapper;

import java.util.List;
import com.mars.sentences.domain.Sentences;

/**
 * 句子Mapper接口
 *
 * @author zy
 * @date 2022-08-01
 */
public interface SentencesMapper
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
     * 删除句子
     *
     * @param sentencesId 句子主键
     * @return 结果
     */
    public int deleteSentencesBySentencesId(Long sentencesId);

    /**
     * 批量删除句子
     *
     * @param sentencesIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSentencesBySentencesIds(Long[] sentencesIds);

    /**
     * 逻辑删除句子
     *
     * @param sentencesId 句子主键
     * @return 结果
     */
    public int logicDeleteSentencesBySentencesId(Long sentencesId);

    /**
     * 逻辑批量删除句子
     *
     * @param sentencesIds 需要删除的数据主键集合
     * @return 结果
     */
    public int logicDeleteSentencesBySentencesIds(Long[] sentencesIds);

    /**
     * 随机获取一句
     * */
    public Sentences randomQueryOne();
}
