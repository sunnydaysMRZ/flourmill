package com.goku.coreui.sys.controller.index;

import javax.servlet.http.HttpServletRequest;

import com.goku.coreui.sys.config.log.LoggerInfo;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

/**
 * Created by nbfujx on 2017/12/25.
 */
public interface IndexController {


//    String  index(Model model);
  
    @LoggerInfo(Method = "/sys/index",Name = "系统模块首页")
	String index(ModelMap  model, String companyName, String sortName,
			String sortOrder, Integer pageNumber, Integer pageSize);
}
