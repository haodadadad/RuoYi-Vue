package com.handa.system.mapper;

import java.util.List;
import com.handa.system.domain.SysInstrument;

/**
 * 仪器信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-27
 */
public interface SysInstrumentMapper 
{
    /**
     * 查询仪器信息
     * 
     * @param instrumentId 仪器信息主键
     * @return 仪器信息
     */
    public SysInstrument selectSysInstrumentByInstrumentId(Long instrumentId);

    /**
     * 查询仪器信息列表
     * 
     * @param sysInstrument 仪器信息
     * @return 仪器信息集合
     */
    public List<SysInstrument> selectSysInstrumentList(SysInstrument sysInstrument);

    /**
     * 新增仪器信息
     * 
     * @param sysInstrument 仪器信息
     * @return 结果
     */
    public int insertSysInstrument(SysInstrument sysInstrument);

    /**
     * 修改仪器信息
     * 
     * @param sysInstrument 仪器信息
     * @return 结果
     */
    public int updateSysInstrument(SysInstrument sysInstrument);

    /**
     * 删除仪器信息
     * 
     * @param instrumentId 仪器信息主键
     * @return 结果
     */
    public int deleteSysInstrumentByInstrumentId(Long instrumentId);

    /**
     * 批量删除仪器信息
     * 
     * @param instrumentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysInstrumentByInstrumentIds(Long[] instrumentIds);
}
