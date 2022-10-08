package com.handa.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.handa.system.mapper.SysInstrumentMapper;
import com.handa.system.domain.SysInstrument;
import com.handa.system.service.ISysInstrumentService;

/**
 * 仪器信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-27
 */
@Service
public class SysInstrumentServiceImpl implements ISysInstrumentService 
{
    @Autowired
    private SysInstrumentMapper sysInstrumentMapper;

    /**
     * 查询仪器信息
     * 
     * @param instrumentId 仪器信息主键
     * @return 仪器信息
     */
    @Override
    public SysInstrument selectSysInstrumentByInstrumentId(Long instrumentId)
    {
        return sysInstrumentMapper.selectSysInstrumentByInstrumentId(instrumentId);
    }

    /**
     * 查询仪器信息列表
     * 
     * @param sysInstrument 仪器信息
     * @return 仪器信息
     */
    @Override
    public List<SysInstrument> selectSysInstrumentList(SysInstrument sysInstrument)
    {
        return sysInstrumentMapper.selectSysInstrumentList(sysInstrument);
    }

    /**
     * 新增仪器信息
     * 
     * @param sysInstrument 仪器信息
     * @return 结果
     */
    @Override
    public int insertSysInstrument(SysInstrument sysInstrument)
    {
        return sysInstrumentMapper.insertSysInstrument(sysInstrument);
    }

    /**
     * 修改仪器信息
     * 
     * @param sysInstrument 仪器信息
     * @return 结果
     */
    @Override
    public int updateSysInstrument(SysInstrument sysInstrument)
    {
        return sysInstrumentMapper.updateSysInstrument(sysInstrument);
    }

    /**
     * 批量删除仪器信息
     * 
     * @param instrumentIds 需要删除的仪器信息主键
     * @return 结果
     */
    @Override
    public int deleteSysInstrumentByInstrumentIds(Long[] instrumentIds)
    {
        return sysInstrumentMapper.deleteSysInstrumentByInstrumentIds(instrumentIds);
    }

    /**
     * 删除仪器信息信息
     * 
     * @param instrumentId 仪器信息主键
     * @return 结果
     */
    @Override
    public int deleteSysInstrumentByInstrumentId(Long instrumentId)
    {
        return sysInstrumentMapper.deleteSysInstrumentByInstrumentId(instrumentId);
    }
}
