package com.handa.system.mapper;

import java.util.List;


import com.handa.system.domain.SysRecord;

/**
 * 记录查询Mapper接口
 * 
 * @author guzhihao
 * @date 2022-10-10
 */
public interface SysRecordMapper 
{
    /**
     * 查询记录查询
     * 
     * @param recordId 记录查询主键
     * @return 记录查询
     */
    public SysRecord selectSysRecordByRecordId(Long recordId);

    /**
     * 查询记录查询列表
     * 
     * @param sysRecord 记录查询
     * @return 记录查询集合
     */
    public List<SysRecord> selectSysRecordList(SysRecord sysRecord);

    /**
     * 新增记录查询
     * 
     * @param sysRecord 记录查询
     * @return 结果
     */
    public int insertSysRecord(SysRecord sysRecord);

    /**
     * 修改记录查询
     * 
     * @param sysRecord 记录查询
     * @return 结果
     */
    public int updateSysRecord(SysRecord sysRecord);

    /**
     * 删除记录查询
     * 
     * @param recordId 记录查询主键
     * @return 结果
     */
    public int deleteSysRecordByRecordId(Long recordId);

    /**
     * 批量删除记录查询
     * 
     * @param recordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysRecordByRecordIds(Long[] recordIds);

    /**
     * 校验MesId是否唯一
     *
     * @param mesId 用户名称
     * @return 结果
     */
    public SysRecord checkMesIdUnique(String mesId);

    /**
     * 查询记录查询
     *
     * @param mesId 记录查询主键
     * @return 记录查询
     */
    public SysRecord selectSysRecordByMesId(String mesId);

}
