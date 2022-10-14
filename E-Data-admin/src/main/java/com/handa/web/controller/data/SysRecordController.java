package com.handa.web.controller.data;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.handa.common.constant.UserConstants;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.handa.common.annotation.Log;
import com.handa.common.core.controller.BaseController;
import com.handa.common.core.domain.AjaxResult;
import com.handa.common.enums.BusinessType;
import com.handa.system.domain.SysRecord;
import com.handa.system.service.ISysRecordService;
import com.handa.common.utils.poi.ExcelUtil;
import com.handa.common.core.page.TableDataInfo;

/**
 * 记录查询Controller
 * 
 * @author guzhihao
 * @date 2022-10-10
 */
@RestController
@RequestMapping("/data/record")
public class SysRecordController extends BaseController
{
    @Autowired
    private ISysRecordService sysRecordService;

    /**
     * 查询记录查询列表
     */
    @PreAuthorize("@ss.hasPermi('data:record:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysRecord sysRecord)
    {
        startPage();
        List<SysRecord> list = sysRecordService.selectSysRecordList(sysRecord);
        return getDataTable(list);
    }

    /**
     * 导出记录查询列表
     */
    @PreAuthorize("@ss.hasPermi('data:record:export')")
    @Log(title = "记录查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysRecord sysRecord)
    {
        List<SysRecord> list = sysRecordService.selectSysRecordList(sysRecord);
        ExcelUtil<SysRecord> util = new ExcelUtil<SysRecord>(SysRecord.class);
        util.exportExcel(response, list, "记录查询数据");
    }

    /**
     * 获取记录查询详细信息
     */
    @PreAuthorize("@ss.hasPermi('data:record:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return AjaxResult.success(sysRecordService.selectSysRecordByRecordId(recordId));
    }

    /**
     * 新增记录查询
     */
    @PreAuthorize("@ss.hasPermi('data:record:add')")
    @Log(title = "记录查询", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysRecord sysRecord)
    {
        if(UserConstants.NOT_UNIQUE.equals(sysRecordService.checkMesidUnique(sysRecord))){
            return AjaxResult.error("MES码已扫码，请到记录列表查询");
        }
        return toAjax(sysRecordService.insertSysRecord(sysRecord));
    }

    /**
     * 修改记录查询
     */
    @PreAuthorize("@ss.hasPermi('data:record:edit')")
    @Log(title = "记录查询", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysRecord sysRecord)
    {
        return toAjax(sysRecordService.updateSysRecord(sysRecord));
    }

    /**
     * 删除记录查询
     */
    @PreAuthorize("@ss.hasPermi('data:record:remove')")
    @Log(title = "记录查询", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(sysRecordService.deleteSysRecordByRecordIds(recordIds));
    }
}
