package com.softel.service.impl;

import com.softel.dao.TbMenuMapper;
import com.softel.model.TbMenu;
import com.softel.service.MenuService;
import com.softel.vo.SubMenu;
import com.softel.vo.Menu;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private TbMenuMapper tbMenuMapper;

    @Override
    public List<Menu> selectByLevel() {
        List<Menu> menuList = new ArrayList<>();
        //一级菜单
        List<TbMenu> tbMenuList = tbMenuMapper.selectByLevel(1);
        for(TbMenu tbMenu : tbMenuList){
            Menu menu = new Menu();
            List<SubMenu> subMenuList1 = new ArrayList<>();
            Integer id = tbMenu.getId();
            boolean isleaf = tbMenu.getIsleaf() == 0 ? true : false;
            if(!isleaf){
                //二级菜单
                List<TbMenu> tbMenuList1 = tbMenuMapper.selectByParentId(id);
                for(TbMenu tbMenu1 : tbMenuList1){
                    SubMenu subMenu2 = new SubMenu();
                    List<SubMenu> subMenuList2 = new ArrayList<>();
                    Integer id2 = tbMenu1.getId();
                    boolean isleaf2 = tbMenu1.getIsleaf() == 0 ? true : false;
                    if(!isleaf2){
                        //三级菜单
                        List<TbMenu> tbMenuList2 = tbMenuMapper.selectByParentId(id2);
                        for(TbMenu tbMenu2 : tbMenuList2){
                            SubMenu subMenu3 = new SubMenu();
                            boolean isleaf3 = tbMenu2.getIsleaf() == 0 ? true : false;
                            subMenu3.setTitle(tbMenu2.getTitle());
                            subMenu3.setIcon(tbMenu2.getIcon());
                            subMenu3.setPath(tbMenu2.getPath());
                            subMenu3.setIsleaf(isleaf3);
                            subMenuList2.add(subMenu3);
                        }
                    }
                    subMenu2.setTitle(tbMenu1.getTitle());
                    subMenu2.setIcon(tbMenu1.getIcon());
                    subMenu2.setPath(tbMenu1.getPath());
                    subMenu2.setSubs(subMenuList2);
                    subMenu2.setIsleaf(isleaf2);
                    subMenuList1.add(subMenu2);
                }
            }
            menu.setId(id);
            menu.setTitle(tbMenu.getTitle());
            menu.setIcon(tbMenu.getIcon());
            menu.setSubs(subMenuList1);
            menu.setIsleaf(isleaf);
            menuList.add(menu);
        }
        return menuList;
    }
}
