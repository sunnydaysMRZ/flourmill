package com.goku.coreui.sys.controller.index.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;
import com.goku.coreui.sys.controller.index.IndexController;
import com.goku.coreui.sys.model.FlourmillCompany;
import com.goku.coreui.sys.model.ext.TablePage;
import com.goku.coreui.sys.service.CompanyService;
import com.goku.coreui.sys.util.CamelUtil;
import com.goku.coreui.sys.util.PageUtil;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by nbfujx on 2017/12/25.
 */
@Controller
@RequestMapping("/sys")
public class IndexControllerImpl implements IndexController {

	@Autowired
    CompanyService companyService;
	 @Autowired
	CamelUtil camelUtil;
	@Autowired
	PageUtil pageUtil;
	
    @Override
    @RequestMapping("/index")
    public String  index(ModelMap   model,@RequestParam(required=false) String companyName,
            @RequestParam(required=false)  String sortName, @RequestParam(required=false)  String sortOrder,
            @RequestParam(value="pageNumber",required=false,defaultValue="1") Integer pageNumber, @RequestParam(value="pageSize",required=false,defaultValue="16") Integer pageSize) {
    	PageInfo page=companyService.getCompanyForPaging(companyName,camelUtil.camelToUnderline(sortName),sortOrder,pageNumber,pageSize);
    	model.addAttribute("page", page.getList());
        return  "sys/index";
       
    }



}
