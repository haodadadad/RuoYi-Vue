package com.handa.system.service.impl;

import java.util.List;

import com.handa.common.constant.UserConstants;
import com.handa.common.core.domain.entity.SysUser;
import com.handa.common.utils.DateUtils;
import com.handa.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.handa.system.mapper.SysRecordMapper;
import com.handa.system.domain.SysRecord;
import com.handa.system.service.ISysRecordService;

/**
 * 记录查询Service业务层处理
 * 
 * @author guzhihao
 * @date 2022-10-10
 */
@Service
public class SysRecordServiceImpl implements ISysRecordService 
{
    @Autowired
    private SysRecordMapper sysRecordMapper;

    /**
     * 查询记录查询
     * 
     * @param recordId 记录查询主键
     * @return 记录查询
     */
    @Override
    public SysRecord selectSysRecordByRecordId(Long recordId)
    {
        return sysRecordMapper.selectSysRecordByRecordId(recordId);
    }

    /**
     * 查询记录查询列表
     * 
     * @param sysRecord 记录查询
     * @return 记录查询
     */
    @Override
    public List<SysRecord> selectSysRecordList(SysRecord sysRecord)
    {
        return sysRecordMapper.selectSysRecordList(sysRecord);
    }

    /**
     * 新增记录查询
     * 
     * @param sysRecord 记录查询
     * @return 结果
     */
    @Override
    public int insertSysRecord(SysRecord sysRecord)
    {
        sysRecord.setCreateTime(DateUtils.getNowDate());
        return sysRecordMapper.insertSysRecord(sysRecord);
    }

    /**
     * 修改记录查询
     * 
     * @param sysRecord 记录查询
     * @return 结果
     */
    @Override
    public int updateSysRecord(SysRecord sysRecord)
    {
        sysRecord.setUpdateTime(DateUtils.getNowDate());
        return sysRecordMapper.updateSysRecord(sysRecord);
    }

    /**
     * 批量删除记录查询
     * 
     * @param recordIds 需要删除的记录查询主键
     * @return 结果
     */
    @Override
    public int deleteSysRecordByRecordIds(Long[] recordIds)
    {
        return sysRecordMapper.deleteSysRecordByRecordIds(recordIds);
    }

    /**
     * 删除记录查询信息
     * 
     * @param recordId 记录查询主键
     * @return 结果
     */
    @Override
    public int deleteSysRecordByRecordId(Long recordId)
    {
        return sysRecordMapper.deleteSysRecordByRecordId(recordId);
    }
    /**
     * 校验MES ID是否唯一
     *
     * @param sysRecord 记录信息
     * @return
     */
    @Override
    public String checkMesidUnique(SysRecord sysRecord) {
        Long recordId = StringUtils.isNull(sysRecord.getRecordId()) ? -1L : sysRecord.getRecordId();
        SysRecord info =sysRecordMapper.checkMesidUnique(sysRecord.getMesId());
        if (StringUtils.isNotNull(info) && info.getRecordId().longValue() != recordId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }
}
