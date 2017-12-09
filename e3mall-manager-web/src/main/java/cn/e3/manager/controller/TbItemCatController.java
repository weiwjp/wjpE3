package cn.e3.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.manager.service.TbItemCatService;
import cn.e3.utils.TreeBean;

@Controller
public class TbItemCatController {

	@Autowired
	private TbItemCatService tbItemCatService;
	
	/**
	 * 根据父id查询子结点
	 * 参数：parentId
	 * 返回值：List<TreeBean>
	 */
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<TreeBean> findByParentId(@RequestParam(defaultValue="0",value="id") Long parentId){
		List<TreeBean> list = tbItemCatService.findByParentId(parentId);
		return list;
	}
}
