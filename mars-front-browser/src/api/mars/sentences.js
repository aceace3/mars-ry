import request from '@/utils/request'

// 查询句子列表
export function listSentences(query) {
  return request({
    url: '/mars/sentences/list',
    method: 'get',
    params: query
  })
}

// 查询句子详细
export function getSentences(sentencesId) {
  return request({
    url: '/mars/sentences/' + sentencesId,
    method: 'get'
  })
}

// 新增句子
export function addSentences(data) {
  return request({
    url: '/mars/sentences',
    method: 'post',
    data: data
  })
}

// 修改句子
export function updateSentences(data) {
  return request({
    url: '/mars/sentences',
    method: 'put',
    data: data
  })
}

// 删除句子
export function delSentences(sentencesId) {
  return request({
    url: '/mars/sentences/' + sentencesId,
    method: 'delete'
  })
}

export function randomQueryOne() {
  return request({
    url: '/mars/sentences/randomQueryOne',
    method: 'get',
    // params: query
  })
}
