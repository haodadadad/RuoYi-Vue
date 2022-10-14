package com.handa.system.service;

import java.util.List;
import com.handa.system.domain.SysRecord;

/**
 * 记录查询Service接口
 * 
 * @author guzhihao
 * @date 2022-10-10
 */
public interface ISysRecordService 
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
     * 批量删除记录查询
     * 
     * @param recordIds 需要删除的记录查询主键集合
     * @return 结果
     */
    public int deleteSysRecordByRecordIds(Long[] recordIds);

    /**
     * 删除记录查询信息
     * 
     * @param recordId 记录查询主键
     * @return 结果
     */
    public int deleteSysRecordByRecordId(Long recordId);


    /**
     * 校验Mesid是否唯一
     *
     * @param sysRecord 记录信息
     * @return 结果
     */
    public String checkMesidUnique(SysRecord sysRecord);
}
