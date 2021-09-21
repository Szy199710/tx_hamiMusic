package cn.tx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	/**
	 * restful第一种形式
	 * 风格实现通用多页面跳转
	 *
	 *restful第二种形式
	 * 根据不同的请求类型，执行不同的业务操作
	 * GET 查询操作
	 * POST新增操作
	 * PUT更新操作
	 * DELETE删除操作
	 * @param moduleName
	 * @return
	 */
	@RequestMapping("/page/{moduleName}")
	public String module(@PathVariable String moduleName) {

		return moduleName;
	}

}
