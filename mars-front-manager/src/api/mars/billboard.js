import request from '@/utils/request'

// 查询公告管理列表
export function listBillboard(query) {
  return request({
    url: '/mars/billboard/list',
    method: 'get',
    params: query
  })
}

// 查询公告管理详细
export function getBillboard(billboardId) {
  return request({
    url: '/mars/billboard/' + billboardId,
    method: 'get'
  })
}

// 新增公告管理
export function addBillboard(data) {
  return request({
    url: '/mars/billboard',
    method: 'post',
    data: data
  })
}

// 修改公告管理
export function updateBillboard(data) {
  return request({
    url: '/mars/billboard',
    method: 'put',
    data: data
  })
}

// 删除公告管理
export function delBillboard(billboardId) {
  return request({
    url: '/mars/billboard/' + billboardId,
    method: 'delete'
  })
}
