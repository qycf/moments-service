package com.qu2u.moments.vo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
    import com.qu2u.moments.entity.Tags;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MomentsVO  {
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
    List<Tags> tags;

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
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
