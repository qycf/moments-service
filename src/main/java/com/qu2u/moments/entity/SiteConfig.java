package com.qu2u.moments.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName site_config
 */
@TableName(value ="site_config")
@Data
public class SiteConfig implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    /**
     * 站点标题
     */
    private String title;



    /**
     * 站点头像
     */
    private String avatar;

    /**
     * 站点特色图
     */
    private String cover;

    /**
     * 站长昵称
     */
    private String nickname;

    /**
     * 个性签名
     */
    private String description;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}