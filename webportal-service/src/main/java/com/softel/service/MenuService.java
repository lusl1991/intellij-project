package com.softel.service;

import com.softel.vo.Menu;
import java.util.List;

public interface MenuService {
    List<Menu> selectByLevel();
}
