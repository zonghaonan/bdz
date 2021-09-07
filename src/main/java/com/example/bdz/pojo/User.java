package com.example.bdz.pojo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author zhn
 * @Date 2021/8/31 20:23
 * @Version 1.0
 */
@Data
@ApiModel("用户实体类")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    //对应数据库中的主键（uuid、自增id、雪花算法、redis、zookeeper）
    @TableId(type = IdType.AUTO)
    private Long id;
    @ApiModelProperty("用户名")
    private String username;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("年龄")
    private String age;
    @Version  //乐观锁version注解
    private Integer version;
    @TableLogic //逻辑删除
    private Integer deleted;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
