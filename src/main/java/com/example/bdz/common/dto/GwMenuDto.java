package com.example.bdz.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author zhn
 * @Date 2021/9/6 20:04
 * @Version 1.0
 */
@Data
public class GwMenuDto implements Serializable {
    private Integer id;
    private String name;
    private String title;
    private String path;
    private Integer type;
    private List<GwMenuDto> children;
}
