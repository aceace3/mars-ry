package com.mars.sentencescollection.mapper;

import java.util.List;
import com.mars.sentencescollection.domain.SentencesCollection;

/**
 * 句子收藏管理Mapper接口
 *
 * @author zy
 * @date 2022-08-01
 */
public interface SentencesCollectionMapper
{
    /**
     * 查询句子收藏管理
     *
     * @param collectionId 句子收藏管理主键
     * @return 句子收藏管理
     */
    public SentencesCollection selectSentencesCollectionByCollectionId(Long collectionId);

    /**
     * 查询句子收藏管理列表
     *
     * @param sentencesCollection 句子收藏管理
     * @return 句子收藏管理集合
     */
    public List<SentencesCollection> selectSentencesCollectionList(SentencesCollection sentencesCollection);

    /**
     * 新增句子收藏管理
     *
     * @param sentencesCollection 句子收藏管理
     * @return 结果
     */
    public int insertSentencesCollection(SentencesCollection sentencesCollection);

    /**
     * 修改句子收藏管理
     *
     * @param sentencesCollection 句子收藏管理
     * @return 结果
     */
    public int updateSentencesCollection(SentencesCollection sentencesCollection);

    /**
     * 删除句子收藏管理
     *
     * @param collectionId 句子收藏管理主键
     * @return 结果
     */
    public int deleteSentencesCollectionByCollectionId(Long collectionId);

    /**
     * 批量删除句子收藏管理
     *
     * @param collectionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSentencesCollectionByCollectionIds(Long[] collectionIds);

    /**
     * 逻辑删除句子收藏管理
     *
     * @param collectionId 句子收藏管理主键
     * @return 结果
     */
    public int logicDeleteSentencesCollectionByCollectionId(Long collectionId);

    /**
     * 逻辑批量删除句子收藏管理
     *
     * @param collectionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int logicDeleteSentencesCollectionByCollectionIds(Long[] collectionIds);
}
