package com.example.bdz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhn
 * @since 2021-11-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GwModel对象", description="")
public class GwModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "所有类别的id")
    @TableId(value = "model_id", type = IdType.AUTO)
    private Integer modelId;

    @ApiModelProperty(value = "类别的名字")
    @NotBlank(message = "类别名称不能为空")
    private String modelName;

    @ApiModelProperty(value = "该类别的总数")
    @NotNull(message = "数量不能为空")
    private Integer amount;


}
