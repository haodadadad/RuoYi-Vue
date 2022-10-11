import request from '@/utils/request'

// 查询记录查询列表
export function listRecord(query) {
  return request({
    url: '/data/record/list',
    method: 'get',
    params: query
  })
}

// 查询记录查询详细
export function getRecord(recordId) {
  return request({
    url: '/data/record/' + recordId,
    method: 'get'
  })
}

// 新增记录查询
export function addRecord(data) {
  return request({
    url: '/data/record',
    method: 'post',
    data: data
  })
}

// 修改记录查询
export function updateRecord(data) {
  return request({
    url: '/data/record',
    method: 'put',
    data: data
  })
}

// 删除记录查询
export function delRecord(recordId) {
  return request({
    url: '/data/record/' + recordId,
    method: 'delete'
  })
}
