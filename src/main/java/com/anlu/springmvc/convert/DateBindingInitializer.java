package com.anlu.springmvc.convert;

import com.anlu.springmvc.convert.DateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**   
 * @Description: 
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */

// 实现WebBindingInitializer接口
public class DateBindingInitializer implements WebBindingInitializer {


	public void initBinder(WebDataBinder binder, WebRequest request) {
		// 注册自定义编辑器
		binder.registerCustomEditor(Date.class, new DateEditor());
	}

}
