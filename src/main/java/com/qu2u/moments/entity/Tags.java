package com.qu2u.moments.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 
 * @TableName tags
 */
@TableName(value ="tags")
@Data
public class Tags implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    /**
     * 标签名(英文)
     */
    private String name;

    /**
     * 背景颜色(16进制)
     */
    private String color;

    /**
     * 文字颜色(16进制)
     */
    private String textColor;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}