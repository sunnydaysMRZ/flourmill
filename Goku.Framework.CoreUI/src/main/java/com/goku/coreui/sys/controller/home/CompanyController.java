package com.goku.coreui.sys.controller.home;

import com.goku.coreui.sys.config.log.LoggerInfo;
import com.goku.coreui.sys.model.FlourmillCompany;

import org.springframework.ui.Model;

/**
 * Created by nbfujx on 2017/12/25.
 */

public interface CompanyController {
    @LoggerInfo(Method = "/dannyboss/company/managePage",Name = "增删公司页面")
    String manageCompanyPage(Model model,Integer companyid);
 
    @LoggerInfo(Method = "/dannyboss/company/manageCompany",Name = "录入公司信息")
    String addOrEditCompany(Model model,FlourmillCompany flourmillCompany);
//    @LoggerInfo(Method = "/dannyboss/company/countrylist",Name = "增删公司页面")
//	String countryList(Model model, String companyName, String sortName,
//			String sortOrder, int pageNumber, int pageSize);
    
}
