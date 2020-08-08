/*
 * FileName: AccessFilter
 * Author:   Akeung
 * Date:     2020/8/8
 */
package com.ak.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Akeung
 * 2020/8/8
 */
@Slf4j
@Component
public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //该过滤器顺序要 > 5，才能得到 serviceid
        return FilterConstants.PRE_DECORATION_FILTER_ORDER+1;
    }

    @Override
    public boolean shouldFilter() {
        //对指定的serviceid过滤，如果要过滤所有服务，直接返回 true
        RequestContext ctx = RequestContext.getCurrentContext();
        String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
        log.info("serviceId:{}",serviceId);
        if(!serviceId.equalsIgnoreCase("PAYMENT-SERVICE")) {
            log.info("w┭┮﹏┭┮");
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();
        String token = req.getParameter("token");
        if (token == null) {
            //此设置会阻止请求被路由到后台微服务
            ctx.setSendZuulResponse(false);
            //向客户端的响应
            ctx.setResponseStatusCode(200);
            ctx.setResponseBody("error : not token");
        }
        //zuul过滤器返回的数据设计为以后扩展使用，
        //目前该返回值没有被使用
        return null;
    }
}
