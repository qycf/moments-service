package com.qu2u.moments.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName moments_tags
 */
@TableName(value ="moments_tags")
@Data
public class MomentsTags implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer momentsId;

    /**
     * 
     */
    private Integer tagsId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}