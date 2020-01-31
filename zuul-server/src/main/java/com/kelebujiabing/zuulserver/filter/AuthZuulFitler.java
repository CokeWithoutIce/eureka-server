package com.kelebujiabing.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthZuulFitler extends ZuulFilter {

    @Override
    ////是什么类型的filter
    public String filterType() {

        return FilterConstants.PRE_TYPE;
    }
    @Override
    public int filterOrder() {
        return 1;
    }
    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);


        return false;
    }
    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
