package com.example.bdz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhn
 * @since 2021-09-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GwType对象", description="")
public class GwType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "类别名称")
    @NotBlank(message = "类型名不能为空")
    private String typeName;

    @ApiModelProperty(value = "类别资产个数")
    @TableField(exist = false)
    private Integer equipCount;

}
