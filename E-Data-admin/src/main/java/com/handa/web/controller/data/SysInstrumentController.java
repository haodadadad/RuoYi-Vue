package com.handa.web.controller.data;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.handa.system.domain.SysInstrument;
import com.handa.system.service.ISysInstrumentService;
import com.handa.common.utils.poi.ExcelUtil;
import com.handa.common.core.page.TableDataInfo;

/**
 * 仪器信息Controller
 * 
 * @author ruoyi
 * @date 2022-09-27
 */
@RestController
@RequestMapping("/data/instrument")
public class SysInstrumentController extends BaseController
{
    @Autowired
    private ISysInstrumentService sysInstrumentService;

    /**
     * 查询仪器信息列表
     */
    @PreAuthorize("@ss.hasPermi('data:instrument:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysInstrument sysInstrument)
    {
        startPage();
        List<SysInstrument> list = sysInstrumentService.selectSysInstrumentList(sysInstrument);
        return getDataTable(list);
    }

    /**
     * 导出仪器信息列表
     */
    @PreAuthorize("@ss.hasPermi('data:instrument:export')")
    @Log(title = "仪器信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysInstrument sysInstrument)
    {
        List<SysInstrument> list = sysInstrumentService.selectSysInstrumentList(sysInstrument);
        ExcelUtil<SysInstrument> util = new ExcelUtil<SysInstrument>(SysInstrument.class);
        util.exportExcel(response, list, "仪器信息数据");
    }

    /**
     * 获取仪器信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('data:instrument:query')")
    @GetMapping(value = "/{instrumentId}")
    public AjaxResult getInfo(@PathVariable("instrumentId") Long instrumentId)
    {
        return AjaxResult.success(sysInstrumentService.selectSysInstrumentByInstrumentId(instrumentId));
    }

    /**
     * 新增仪器信息
     */
    @PreAuthorize("@ss.hasPermi('data:instrument:add')")
    @Log(title = "仪器信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysInstrument sysInstrument)
    {
        return toAjax(sysInstrumentService.insertSysInstrument(sysInstrument));
    }

    /**
     * 修改仪器信息
     */
    @PreAuthorize("@ss.hasPermi('data:instrument:edit')")
    @Log(title = "仪器信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysInstrument sysInstrument)
    {
        return toAjax(sysInstrumentService.updateSysInstrument(sysInstrument));
    }

    /**
     * 删除仪器信息
     */
    @PreAuthorize("@ss.hasPermi('data:instrument:remove')")
    @Log(title = "仪器信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{instrumentIds}")
    public AjaxResult remove(@PathVariable Long[] instrumentIds)
    {
        return toAjax(sysInstrumentService.deleteSysInstrumentByInstrumentIds(instrumentIds));
    }
}
