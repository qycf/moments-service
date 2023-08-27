package com.qu2u.moments.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 
 * @TableName moments
 */
@TableName(value ="moments")
@Data
public class Moments implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 标签
     */

    private String tags;

    /**
     * 内容
     */
    private String content;

    /**
     * 点赞量
     */
    private Integer start;

    /**
     * 1:置顶 0:不置顶
     */
    private Integer isTop;

    /**
     * 1:发布 0:不发布
     */
    private Integer isPublish;

    /**
     * 1:删除 0:不删除
     */
    private Integer isDelete;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime updateTime;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}