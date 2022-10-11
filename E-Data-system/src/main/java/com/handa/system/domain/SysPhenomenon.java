package com.handa.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.handa.common.annotation.Excel;
import com.handa.common.core.domain.BaseEntity;

/**
 * 故障信息对象 sys_phenomenon
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
public class SysPhenomenon extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 故障现象ID */
    private Long phenomenonId;

    /** 图号 */
    @Excel(name = "图号")
    private String drawingNumber;

    /** 故障现象 */
    @Excel(name = "故障现象")
    private String phenomenon;

    public void setPhenomenonId(Long phenomenonId) 
    {
        this.phenomenonId = phenomenonId;
    }

    public Long getPhenomenonId() 
    {
        return phenomenonId;
    }
    public void setDrawingNumber(String drawingNumber) 
    {
        this.drawingNumber = drawingNumber;
    }

    public String getDrawingNumber() 
    {
        return drawingNumber;
    }
    public void setPhenomenon(String phenomenon) 
    {
        this.phenomenon = phenomenon;
    }

    public String getPhenomenon() 
    {
        return phenomenon;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("phenomenonId", getPhenomenonId())
            .append("drawingNumber", getDrawingNumber())
            .append("phenomenon", getPhenomenon())
            .toString();
    }
}
