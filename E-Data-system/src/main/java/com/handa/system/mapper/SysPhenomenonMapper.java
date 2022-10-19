package com.handa.system.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.handa.system.domain.SysPhenomenon;

/**
 * 故障信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public interface SysPhenomenonMapper extends BaseMapper<SysPhenomenon>
{
    /**
     * 查询故障信息
     * 
     * @param phenomenonId 故障信息主键
     * @return 故障信息
     */
    public SysPhenomenon selectSysPhenomenonByPhenomenonId(Long phenomenonId);

    /**
     * 查询故障信息列表
     * 
     * @param sysPhenomenon 故障信息
     * @return 故障信息集合
     */
    public List<SysPhenomenon> selectSysPhenomenonList(SysPhenomenon sysPhenomenon);

    /**
     * 新增故障信息
     * 
     * @param sysPhenomenon 故障信息
     * @return 结果
     */
    public int insertSysPhenomenon(SysPhenomenon sysPhenomenon);

    /**
     * 修改故障信息
     * 
     * @param sysPhenomenon 故障信息
     * @return 结果
     */
    public int updateSysPhenomenon(SysPhenomenon sysPhenomenon);

    /**
     * 删除故障信息
     * 
     * @param phenomenonId 故障信息主键
     * @return 结果
     */
    public int deleteSysPhenomenonByPhenomenonId(Long phenomenonId);

    /**
     * 批量删除故障信息
     * 
     * @param phenomenonIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysPhenomenonByPhenomenonIds(Long[] phenomenonIds);

    public List<SysPhenomenon> selectSysPhenomenonByDrawingNumber(String drawingNumber);
}
