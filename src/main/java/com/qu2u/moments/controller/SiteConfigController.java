package com.qu2u.moments.controller;


import com.qu2u.moments.domain.Response;
import com.qu2u.moments.entity.SiteConfig;
import com.qu2u.moments.service.SiteConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/siteConfig")
public class SiteConfigController {

    @Resource
    private SiteConfigService siteConfigService;

    @GetMapping("")
    public Response<SiteConfig> getSiteConfig() {
        SiteConfig siteConfig = siteConfigService.getById(1);
        return Response.success(siteConfig);
    }

}
