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
 * @since 2021-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GwOilfilledTransformer对象", description="")
public class GwOilfilledTransformer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备id,assign")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "设备的编号")
    @NotBlank(message = "设备编号不能为空")
    private String equipId;

    @ApiModelProperty(value = "对应的类别id")
    @NotNull(message = "类别id不能为空")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称")
    @NotBlank(message = "模型名称不能为空")
    private String modelName;

    @ApiModelProperty(value = "型式/单相、自耦、三绕组")
    @NotBlank(message = "型式不能为空")
    private String type;

    @ApiModelProperty(value = "容量")
    @NotNull(message = "容量不能为空")
    private Double capacity;

    @ApiModelProperty(value = "额定频率")
    @NotNull(message = "额定频率不能为空")
    private Double ratedFrequency;

    @ApiModelProperty(value = "单位/示例：台")
    @NotBlank(message = "单位不能为空")
    private String unit;


}
