package com.handa.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.handa.system.mapper.SysPhenomenonMapper;
import com.handa.system.domain.SysPhenomenon;
import com.handa.system.service.ISysPhenomenonService;

/**
 * 故障信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@Service
public class SysPhenomenonServiceImpl implements ISysPhenomenonService 
{
    @Autowired
    private SysPhenomenonMapper sysPhenomenonMapper;

    /**
     * 查询故障信息
     * 
     * @param phenomenonId 故障信息主键
     * @return 故障信息
     */
    @Override
    public SysPhenomenon selectSysPhenomenonByPhenomenonId(Long phenomenonId)
    {
        return sysPhenomenonMapper.selectSysPhenomenonByPhenomenonId(phenomenonId);
    }

    /**
     * 查询故障信息列表
     * 
     * @param sysPhenomenon 故障信息
     * @return 故障信息
     */
    @Override
    public List<SysPhenomenon> selectSysPhenomenonList(SysPhenomenon sysPhenomenon)
    {
        return sysPhenomenonMapper.selectSysPhenomenonList(sysPhenomenon);
    }

    /**
     * 新增故障信息
     * 
     * @param sysPhenomenon 故障信息
     * @return 结果
     */
    @Override
    public int insertSysPhenomenon(SysPhenomenon sysPhenomenon)
    {
        return sysPhenomenonMapper.insertSysPhenomenon(sysPhenomenon);
    }

    /**
     * 修改故障信息
     * 
     * @param sysPhenomenon 故障信息
     * @return 结果
     */
    @Override
    public int updateSysPhenomenon(SysPhenomenon sysPhenomenon)
    {
        return sysPhenomenonMapper.updateSysPhenomenon(sysPhenomenon);
    }

    /**
     * 批量删除故障信息
     * 
     * @param phenomenonIds 需要删除的故障信息主键
     * @return 结果
     */
    @Override
    public int deleteSysPhenomenonByPhenomenonIds(Long[] phenomenonIds)
    {
        return sysPhenomenonMapper.deleteSysPhenomenonByPhenomenonIds(phenomenonIds);
    }

    /**
     * 删除故障信息信息
     * 
     * @param phenomenonId 故障信息主键
     * @return 结果
     */
    @Override
    public int deleteSysPhenomenonByPhenomenonId(Long phenomenonId)
    {
        return sysPhenomenonMapper.deleteSysPhenomenonByPhenomenonId(phenomenonId);
    }
}
