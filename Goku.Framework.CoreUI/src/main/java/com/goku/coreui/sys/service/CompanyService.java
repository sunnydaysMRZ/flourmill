package com.goku.coreui.sys.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goku.coreui.sys.model.FlourmillCompany;
import com.goku.coreui.sys.model.SysMenu;
import com.goku.coreui.sys.model.SysRole;
import com.goku.coreui.sys.model.SysUser;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by nbfujx on 2018/1/9.
 */
public interface CompanyService {
	  FlourmillCompany selectByPrimaryKey(Integer UserId);
	  int saveOrEditCompany(Integer companyid , String companyName);
	  PageInfo  getCompanyForPaging(String username, String orderFiled,
				String orderSort, Integer pageindex, Integer pagenum);
//    PageInfo getUserForPaging(String username, String name,String orderFiled, String orderSort, int pageindex, int pagenum);
//    int deleteUser(String UserId);
//    int saveUser(SysUser sysUser);
//    int menuAuth(List<SysMenu> sysMenus, String userid, String moduleId);
//    int roleauth(List<SysRole> sysRoles, String userid);

}
