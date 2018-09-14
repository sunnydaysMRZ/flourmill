package com.goku.coreui.sys.controller.home.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.goku.coreui.sys.controller.home.CompanyController;
import com.goku.coreui.sys.controller.sysuser.UserController;
import com.goku.coreui.sys.model.FlourmillCompany;
import com.goku.coreui.sys.model.SysUser;
import com.goku.coreui.sys.service.CompanyService;
import com.goku.coreui.sys.service.SysUserService;
import com.goku.coreui.sys.util.CamelUtil;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

/**
 * Created by nbfujx on 2017/12/25.
 */
@Controller
@RequestMapping("/dannyboss/company")
public class CompanyControllerImpl implements CompanyController {

	@Autowired
    CompanyService companyService;
	
	 @Autowired
	CamelUtil camelUtil;

	@Override
	@RequestMapping("/managePage")
	public String manageCompanyPage(Model model,@RequestParam(value="companyid", required=false, defaultValue="") Integer companyid) {
		FlourmillCompany flourmillCompany=companyService.selectByPrimaryKey(companyid);
	    model.addAttribute("flourmillCompany",flourmillCompany);
        return  "dannyboss/company/edit";
	}

	@Override
	@RequestMapping("/manageCompany")
	@ResponseBody
	public String addOrEditCompany(Model model,@RequestBody FlourmillCompany flourmillCompany) {
		int result=companyService.saveOrEditCompany(flourmillCompany.getId(), flourmillCompany.getCompanyName());
        if(result>0) {
            return JSON.toJSONString ("true");
        }else{
            return JSON.toJSONString ("false");
        }
		
	}
	
//
//	@Override
//	@RequestMapping("/countrylist")
//	public String countryList(Model model,@RequestParam(required=false) String companyName,
//            @RequestParam(required=false)  String sortName, @RequestParam(required=false)  String sortOrder,
//            @RequestParam int pageNumber, @RequestParam int pageSize) {
//		PageInfo pageInfo=companyService.getCompanyForPaging(companyName,camelUtil.camelToUnderline(sortName),sortOrder,pageNumber,pageSize);
//	    model.addAttribute("list",pageInfo);
//	    
//        return  "dannyboss/company/edit";
//	}


}
