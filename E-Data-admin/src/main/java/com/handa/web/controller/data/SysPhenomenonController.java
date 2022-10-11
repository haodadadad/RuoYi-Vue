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
import com.handa.system.domain.SysPhenomenon;
import com.handa.system.service.ISysPhenomenonService;
import com.handa.common.utils.poi.ExcelUtil;
import com.handa.common.core.page.TableDataInfo;

/**
 * 故障信息Controller
 * 
 * @author ruoyi
 * @date 2022-10-10
 */
@RestController
@RequestMapping("/data/phenomenon")
public class SysPhenomenonController extends BaseController
{
    @Autowired
    private ISysPhenomenonService sysPhenomenonService;

    /**
     * 查询故障信息列表
     */
    @PreAuthorize("@ss.hasPermi('data:phenomenon:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysPhenomenon sysPhenomenon)
    {
        startPage();
        List<SysPhenomenon> list = sysPhenomenonService.selectSysPhenomenonList(sysPhenomenon);
        return getDataTable(list);
    }

    /**
     * 导出故障信息列表
     */
    @PreAuthorize("@ss.hasPermi('data:phenomenon:export')")
    @Log(title = "故障信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysPhenomenon sysPhenomenon)
    {
        List<SysPhenomenon> list = sysPhenomenonService.selectSysPhenomenonList(sysPhenomenon);
        ExcelUtil<SysPhenomenon> util = new ExcelUtil<SysPhenomenon>(SysPhenomenon.class);
        util.exportExcel(response, list, "故障信息数据");
    }

    /**
     * 获取故障信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('data:phenomenon:query')")
    @GetMapping(value = "/{phenomenonId}")
    public AjaxResult getInfo(@PathVariable("phenomenonId") Long phenomenonId)
    {
        return AjaxResult.success(sysPhenomenonService.selectSysPhenomenonByPhenomenonId(phenomenonId));
    }

    /**
     * 新增故障信息
     */
    @PreAuthorize("@ss.hasPermi('data:phenomenon:add')")
    @Log(title = "故障信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysPhenomenon sysPhenomenon)
    {
        return toAjax(sysPhenomenonService.insertSysPhenomenon(sysPhenomenon));
    }

    /**
     * 修改故障信息
     */
    @PreAuthorize("@ss.hasPermi('data:phenomenon:edit')")
    @Log(title = "故障信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysPhenomenon sysPhenomenon)
    {
        return toAjax(sysPhenomenonService.updateSysPhenomenon(sysPhenomenon));
    }

    /**
     * 删除故障信息
     */
    @PreAuthorize("@ss.hasPermi('data:phenomenon:remove')")
    @Log(title = "故障信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{phenomenonIds}")
    public AjaxResult remove(@PathVariable Long[] phenomenonIds)
    {
        return toAjax(sysPhenomenonService.deleteSysPhenomenonByPhenomenonIds(phenomenonIds));
    }
}
