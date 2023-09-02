package com.qu2u.moments.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.qu2u.moments.entity.Images;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class MomentsVO {

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
     * 图片
     */
    List<Images> images;


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
    private LocalDateTime updateTime;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;


}
