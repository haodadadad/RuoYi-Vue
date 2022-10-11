package com.handa.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.handa.common.annotation.Excel;
import com.handa.common.core.domain.BaseEntity;

/**
 * 记录查询对象 sys_record
 * 
 * @author guzhihao
 * @date 2022-10-10
 */
public class SysRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long recordId;

    /** 用户工号 */
    @Excel(name = "用户工号")
    private String userName;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String nickName;

    /** 仪表序列号 */
    @Excel(name = "仪表序列号")
    private String instrumentNumber;

    /** 检测结果（0合格 1不合格） */
    @Excel(name = "检测结果", readConverterExp = "0=合格,1=不合格")
    private String result;

    /** MES码 */
    @Excel(name = "MES码")
    private String mesId;

    /** 图号 */
    @Excel(name = "图号")
    private String drawingNumber;

    /** 板号 */
    @Excel(name = "板号")
    private String boradNumber;

    /** 订单号 */
    @Excel(name = "订单号")
    private String orderNumber;

    /** 位号 */
    @Excel(name = "位号")
    private String tagNumber;

    /** 故障现象 */
    @Excel(name = "故障现象")
    private String phenomenon;

    /** 故障原因 */
    @Excel(name = "故障原因")
    private String cause;

    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setInstrumentNumber(String instrumentNumber) 
    {
        this.instrumentNumber = instrumentNumber;
    }

    public String getInstrumentNumber() 
    {
        return instrumentNumber;
    }
    public void setResult(String result) 
    {
        this.result = result;
    }

    public String getResult() 
    {
        return result;
    }
    public void setMesId(String mesId) 
    {
        this.mesId = mesId;
    }

    public String getMesId() 
    {
        return mesId;
    }
    public void setDrawingNumber(String drawingNumber) 
    {
        this.drawingNumber = drawingNumber;
    }

    public String getDrawingNumber() 
    {
        return drawingNumber;
    }
    public void setBoradNumber(String boradNumber) 
    {
        this.boradNumber = boradNumber;
    }

    public String getBoradNumber() 
    {
        return boradNumber;
    }
    public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
    }
    public void setTagNumber(String tagNumber) 
    {
        this.tagNumber = tagNumber;
    }

    public String getTagNumber() 
    {
        return tagNumber;
    }
    public void setPhenomenon(String phenomenon) 
    {
        this.phenomenon = phenomenon;
    }

    public String getPhenomenon() 
    {
        return phenomenon;
    }
    public void setCause(String cause) 
    {
        this.cause = cause;
    }

    public String getCause() 
    {
        return cause;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("userName", getUserName())
            .append("nickName", getNickName())
            .append("instrumentNumber", getInstrumentNumber())
            .append("result", getResult())
            .append("mesId", getMesId())
            .append("drawingNumber", getDrawingNumber())
            .append("boradNumber", getBoradNumber())
            .append("orderNumber", getOrderNumber())
            .append("tagNumber", getTagNumber())
            .append("phenomenon", getPhenomenon())
            .append("cause", getCause())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
