package com.hufei.mps.pojo.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> 用户实体 </p>
 *
 * @author hufei
 * @date 2021/2/21 17:43
 * @version 1.0.0
 */
@Data
//注解在类上，为类提供一个无参的构造
@NoArgsConstructor
//为类提供一个全参的构造
@AllArgsConstructor
@TableName("tb_user")
public class User {
    private Long id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private String email;
}
