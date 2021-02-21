package com.hufei.mpsb.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_user")
public class User {

    //指定id类型为自增长
    @TableId(type = IdType.AUTO)
    private Long id;

    private String userName;

    //查询时不返回该字段的值
    @TableField(select = false)
    private String password;

    private String name;

    private Integer age;

    //指定数据表中字段名
    @TableField(value = "email")
    private String mail;

    //在数据库表中是不存在的
    @TableField(exist = false)
    private String address;
}