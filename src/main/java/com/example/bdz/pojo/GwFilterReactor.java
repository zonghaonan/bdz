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
 * @since 2021-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="GwFilterReactor对象", description="")
public class GwFilterReactor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备的编号")
    @TableId(value = "equip_id", type = IdType.ASSIGN_ID)
    private Long equipId;

    @ApiModelProperty(value = "对应的类别id")
    private Integer modelId;

    @ApiModelProperty(value = "模型名称 滤波电抗器")
    private String modelName;

    @ApiModelProperty(value = "额定谐振频率")
    private Double ratedResonantFrequency;

    @ApiModelProperty(value = "谐振频率下的额定电感")
    private Double ratedInductanceAtResonantFrequency;

    @ApiModelProperty(value = "参数偏差")
    private Double parameterDeviation;

    @ApiModelProperty(value = "调节参数")
    private Double tuneParameter;


}
