package com.goku.coreui.sys.service;

import com.goku.coreui.sys.model.SysMenu;

import java.util.HashMap;
import java.util.List;

/**
 * Created by nbfujx on 2018/1/1.
 */
public interface SysMenuService {
    List<SysMenu> getModuleMenus(String ModuleId, String UserId);
    SysMenu getMenuByMenuId(String MenuId);
    SysMenu getMenuByUrl(String Url);
    List<SysMenu> getMenuForPaging(String ModuleId);
    int deleteMenu(String MenuId);
    int saveMenu(SysMenu sysMenu);
    List<SysMenu> getUserModuleMenus(String moduleId, String id);
    List<SysMenu> getUserModuleMenus2(String moduleId, String userid);
}
