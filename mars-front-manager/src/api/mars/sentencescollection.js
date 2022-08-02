import request from '@/utils/request'

// 查询句子收藏管理列表
export function listSentencescollection(query) {
  return request({
    url: '/mars/sentencescollection/list',
    method: 'get',
    params: query
  })
}

// 查询句子收藏管理详细
export function getSentencescollection(collectionId) {
  return request({
    url: '/mars/sentencescollection/' + collectionId,
    method: 'get'
  })
}

// 新增句子收藏管理
export function addSentencescollection(data) {
  return request({
    url: '/mars/sentencescollection',
    method: 'post',
    data: data
  })
}

// 修改句子收藏管理
export function updateSentencescollection(data) {
  return request({
    url: '/mars/sentencescollection',
    method: 'put',
    data: data
  })
}

// 删除句子收藏管理
export function delSentencescollection(collectionId) {
  return request({
    url: '/mars/sentencescollection/' + collectionId,
    method: 'delete'
  })
}
