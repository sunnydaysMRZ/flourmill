package com.goku.coreui.sys.controller.sysmenu.impl;

import com.goku.coreui.sys.controller.sysmenu.MenuController;
import com.goku.coreui.sys.model.SysMenu;
import com.goku.coreui.sys.service.impl.SysMenuServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

/**
 * Created by nbfujx on 2018/1/10.
 */
@Controller
@RequestMapping("/sys/menu")
public class MenuControllerImpl implements MenuController {

    @Autowired
    SysMenuServiceImpl sysMenuService;

    @Override
    @RequestMapping("/getListPage")
    @RequiresPermissions(value={"sys:menu:query"})
    public String  list(@RequestParam(value="moduleId",  defaultValue="") String moduleId, Model model) {
        model.addAttribute("moduleId",moduleId);
        return  "sys/menu/list";
    }

    @Override
    @RequestMapping("/addPage")
    @RequiresPermissions(value={"sys:menu:add"})
    public String  add(@PathParam("moduleId") String moduleId, Model model) {
        model.addAttribute("pageTitle","菜单新增");
        SysMenu sysMenu=new SysMenu();
        sysMenu.setModuleId(moduleId);
        model.addAttribute("sysMenu",sysMenu);
        return  "sys/menu/edit";
    }

    @Override
    @RequestMapping("/editPage")
    @RequiresPermissions(value={"sys:menu:edit"})
    public String  edit(@PathParam("menuId") String menuId, Model model) {
        SysMenu sysMenu=sysMenuService.getMenuByMenuId(menuId);
        model.addAttribute("pageTitle","菜单修改");
        model.addAttribute("sysMenu",sysMenu);
        return  "sys/menu/edit";
    }
}
