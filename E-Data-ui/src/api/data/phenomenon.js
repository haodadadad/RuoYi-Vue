import request from '@/utils/request'

// 查询故障信息列表
export function listPhenomenon(query) {
  return request({
    url: '/data/phenomenon/list',
    method: 'get',
    params: query
  })
}

// 查询故障信息详细
export function getPhenomenon(phenomenonId) {
  return request({
    url: '/data/phenomenon/' + phenomenonId,
    method: 'get'
  })
}
// 跟据图号查询故障信息详细
export function getPhenomenonInfo(drawingNumber) {
  return request({
    url: '/data/phenomenon/drawingNumber/' + drawingNumber,
    method: 'get'
  })
}

// 新增故障信息
export function addPhenomenon(data) {
  return request({
    url: '/data/phenomenon',
    method: 'post',
    data: data
  })
}

// 修改故障信息
export function updatePhenomenon(data) {
  return request({
    url: '/data/phenomenon',
    method: 'put',
    data: data
  })
}

// 删除故障信息
export function delPhenomenon(phenomenonId) {
  return request({
    url: '/data/phenomenon/' + phenomenonId,
    method: 'delete'
  })
}
