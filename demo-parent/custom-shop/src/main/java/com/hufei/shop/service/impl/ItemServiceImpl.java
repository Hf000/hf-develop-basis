package com.hufei.shop.service.impl;

import com.hufei.shop.dao.ItemDao;
import com.hufei.shop.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>  </p>
 * @author hufei
 * @date 2022/7/17 20:01
*/
@Slf4j
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    /***
     * 修改库存
     */
    @Override
    public int modify(Integer count, String id){
        int modifyCount = itemDao.modify(count,id);
        return modifyCount;
    }

}
