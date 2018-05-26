package com.test.zuul.filter

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.springframework.stereotype.Component

@Component
class MyFilter: ZuulFilter() {
    /**
     *  run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     * */
    override fun run(): Any? {
        val ctx = RequestContext.getCurrentContext()
        val request = ctx.request
        System.out.println("${request.method} >>> ${request.requestURL}")
        val accessToken = request.getParameter("token")
        if (null == accessToken) {
            System.out.println("token is empty")
            ctx.setSendZuulResponse(false)
            ctx.responseStatusCode = 401
            try {
                ctx.response.writer.write("token is empty")
            } catch (e: Exception) {}
            return null
        }
        System.out.println("ok")
        return null
    }

    /**
     * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     * */
    override fun shouldFilter(): Boolean = true

    /**
     * pre：路由之前
    * routing：路由之时
    * post： 路由之后
    * error：发送错误调用
     * */
    override fun filterType(): String = "pre"

    /**
     *  filterOrder：过滤的顺序
     */
    override fun filterOrder(): Int = 0
}