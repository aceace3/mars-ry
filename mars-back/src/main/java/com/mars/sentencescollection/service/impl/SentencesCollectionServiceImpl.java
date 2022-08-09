package com.mars.sentencescollection.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mars.sentencescollection.mapper.SentencesCollectionMapper;
import com.mars.sentencescollection.domain.SentencesCollection;
import com.mars.sentencescollection.service.ISentencesCollectionService;

/**
 * 句子收藏管理Service业务层处理
 *
 * @author zy
 * @date 2022-08-01
 */
@Service
public class SentencesCollectionServiceImpl implements ISentencesCollectionService
{
    @Autowired
    private SentencesCollectionMapper sentencesCollectionMapper;

    /**
     * 查询句子收藏管理
     *
     * @param collectionId 句子收藏管理主键
     * @return 句子收藏管理
     */
    @Override
    public SentencesCollection selectSentencesCollectionByCollectionId(Long collectionId)
    {
        return sentencesCollectionMapper.selectSentencesCollectionByCollectionId(collectionId);
    }

    /**
     * 查询句子收藏管理列表
     *
     * @param sentencesCollection 句子收藏管理
     * @return 句子收藏管理
     */
    @Override
    public List<SentencesCollection> selectSentencesCollectionList(SentencesCollection sentencesCollection)
    {
        return sentencesCollectionMapper.selectSentencesCollectionList(sentencesCollection);
    }

    /**
     * 新增句子收藏管理
     *
     * @param sentencesCollection 句子收藏管理
     * @return 结果
     */
    @Override
    public int insertSentencesCollection(SentencesCollection sentencesCollection)
    {
        sentencesCollection.setCreateTime(DateUtils.getNowDate());
        return sentencesCollectionMapper.insertSentencesCollection(sentencesCollection);
    }

    /**
     * 修改句子收藏管理
     *
     * @param sentencesCollection 句子收藏管理
     * @return 结果
     */
    @Override
    public int updateSentencesCollection(SentencesCollection sentencesCollection)
    {
        sentencesCollection.setUpdateTime(DateUtils.getNowDate());
        return sentencesCollectionMapper.updateSentencesCollection(sentencesCollection);
    }

    /**
     * 批量删除句子收藏管理
     *
     * @param collectionIds 需要删除的句子收藏管理主键
     * @return 结果
     */
    @Override
    public int deleteSentencesCollectionByCollectionIds(Long[] collectionIds)
    {
        return sentencesCollectionMapper.deleteSentencesCollectionByCollectionIds(collectionIds);
    }

    /**
     * 删除句子收藏管理信息
     *
     * @param collectionId 句子收藏管理主键
     * @return 结果
     */
    @Override
    public int deleteSentencesCollectionByCollectionId(Long collectionId)
    {
        return sentencesCollectionMapper.deleteSentencesCollectionByCollectionId(collectionId);
    }

    /**
     * 逻辑批量删除句子收藏管理
     *
     * @param collectionIds 需要删除的句子收藏管理主键
     * @return 结果
     */
    @Override
    public int logicDeleteSentencesCollectionByCollectionIds(Long[] collectionIds)
    {
        return sentencesCollectionMapper.logicDeleteSentencesCollectionByCollectionIds(collectionIds);
    }

    /**
     * 逻辑删除句子收藏管理信息
     *
     * @param collectionId 句子收藏管理主键
     * @return 结果
     */
    @Override
    public int logicDeleteSentencesCollectionByCollectionId(Long collectionId)
    {
        return sentencesCollectionMapper.logicDeleteSentencesCollectionByCollectionId(collectionId);
    }
}
