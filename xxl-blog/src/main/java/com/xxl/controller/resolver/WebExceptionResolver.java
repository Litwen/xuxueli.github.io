package com.xxl.controller.resolver;

import com.xxl.core.exception.WebException;
import com.xxl.core.result.ReturnT;
import com.xxl.core.util.JacksonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常解析器
 * 
 * @author xuxueli
 */
public class WebExceptionResolver implements HandlerExceptionResolver {
	private static transient Logger logger = LoggerFactory.getLogger(WebExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ModelAndView mv = new ModelAndView();
		
		// 异常封装
		ReturnT<String> result = new ReturnT<String>();
		if (ex instanceof WebException) {
			result.setCode(((WebException) ex).getExceptionKey());
			result.setMsg(((WebException) ex).getExceptionMsg());
		} else {
			result.setCode(ReturnT.FAIL);
			result.setMsg(ex.toString().replaceAll("\n", "<br/>"));
			
			logger.info("==============异常开始=============");
			logger.info("system catch exception:{}", ex);
			logger.info("==============异常结束=============");
		}
				
		// 是否JSON返回
		HandlerMethod method = (HandlerMethod)handler;
		ResponseBody responseBody = method.getMethodAnnotation(ResponseBody.class);
		if (responseBody != null) {
			try {
				mv.addObject("result", JacksonUtil.writeValueAsString(result));
			} catch (Exception e) {
				e.printStackTrace();
			}
			mv.setViewName("net/common/common.result.body");
		} else {
			mv.addObject("exceptionMsg", result.getMsg());	
			mv.setViewName("net/common/common.result.exception");
		}
		
		return mv;
	}

	
}
