package com.smtboy.news.interceptor;


import com.smtboy.news.common.Const;
import com.smtboy.news.vo.UserLoginVo;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    //返回值true：请求会被继续运行
    //返回值false:请求将被停止
    //Object o 被拦截的请求的目标对象（控制器中的名称）
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        // 获取当前请求的路径（如：/api/user/postOneUser）
        String requestUri = request.getRequestURI();

        // 排除 postOneUser 接口（根据实际路径调整）
        if (requestUri.contains("/user/postOneUser")) {
            return true; // 直接放行，不检查登录状态
        }

        // 其他接口仍需登录验证
//        UserLoginVo userLoginVo = (UserLoginVo) request.getSession().getAttribute(Const.CURRENT_USER);
//        if (userLoginVo == null) {
//            response.sendRedirect(Const.REQUEST_PREFIX + "/user/checkLogin");
//            return false;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

}
