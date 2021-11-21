package com.example.bdz.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@ApiModel(value="GwDrytypeTransformer对象", description="")
public class GwDrytypeTransformer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备id,assign")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "设备的编号")
    private String equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称")
    private String modelName;

    @ApiModelProperty(value = "型式/单相、自耦、三绕组")
    private String type;

    @ApiModelProperty(value = "容量")
    private Double capacity;


}
