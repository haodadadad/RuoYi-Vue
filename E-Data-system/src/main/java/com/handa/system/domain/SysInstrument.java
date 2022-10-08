package com.handa.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.handa.common.annotation.Excel;
import com.handa.common.core.domain.BaseEntity;

/**
 * 仪器信息对象 sys_instrument
 * 
 * @author ruoyi
 * @date 2022-09-27
 */
public class SysInstrument extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 仪器ID */
    private Long instrumentId;

    /** 仪器序列号 */
    @Excel(name = "仪器序列号")
    private String instrumentNumber;

    /** 仪器名称 */
    @Excel(name = "仪器名称")
    private String instrumentName;

    /** 仪器型号 */
    @Excel(name = "仪器型号")
    private String instrumentModel;

    public void setInstrumentId(Long instrumentId) 
    {
        this.instrumentId = instrumentId;
    }

    public Long getInstrumentId() 
    {
        return instrumentId;
    }
    public void setInstrumentNumber(String instrumentNumber) 
    {
        this.instrumentNumber = instrumentNumber;
    }

    public String getInstrumentNumber() 
    {
        return instrumentNumber;
    }
    public void setInstrumentName(String instrumentName) 
    {
        this.instrumentName = instrumentName;
    }

    public String getInstrumentName() 
    {
        return instrumentName;
    }
    public void setInstrumentModel(String instrumentModel) 
    {
        this.instrumentModel = instrumentModel;
    }

    public String getInstrumentModel() 
    {
        return instrumentModel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("instrumentId", getInstrumentId())
            .append("instrumentNumber", getInstrumentNumber())
            .append("instrumentName", getInstrumentName())
            .append("instrumentModel", getInstrumentModel())
            .append("remark", getRemark())
            .toString();
    }
}
