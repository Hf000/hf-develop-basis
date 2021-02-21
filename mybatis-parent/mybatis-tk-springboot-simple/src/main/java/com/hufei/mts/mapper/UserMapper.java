package com.hufei.mts.mapper;

import com.hufei.mts.pojo.po.User;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * <p>  </p>
 *
 * @author hufei
 * @version 1.0.0
 * @date 2021/2/21 19:09
 */
//tk通用mapper这里是需要继承Mapper<T>接口的
public interface UserMapper extends Mapper<User> {

    User getById(Long id);

}
