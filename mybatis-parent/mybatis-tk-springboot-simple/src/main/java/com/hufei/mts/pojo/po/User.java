package com.hufei.mts.pojo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

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
//将实体映射到数据库中对应的表
@Table(name = "tb_user")
public class User {

    //设置主键id
    @Id
    //主键回填，在数据库插入完数据后将自增主键id的值保存到插入的实体对象中
    @KeySql(useGeneratedKeys = true)
    private Long id;

    //如果数据字段和实体对应字段一致或者实体字段符合驼峰规则（user_name --> userName）的这个注解@Column可以省略不写
    @Column(name = "user_name")
    private String userName;

    private String password;

    private String name;

    private Integer age;

    private String email;
}
