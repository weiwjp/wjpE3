package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.manager.service.ItemService;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.utils.DatagridPagebean;
import cn.e3.utils.E3mallResult;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	/**
	 * 通过id查询
	 */
	@RequestMapping("item/list/{itemId}")
	@ResponseBody
	public TbItem findById(@PathVariable Long itemId){
		TbItem tbItem = itemService.findById(itemId);
		return tbItem;
	}
	/**
	 *需求：分页查询商品
	 * 参数：page 和rows
	 * 返回值：DatagridPagebean
	 */
	@RequestMapping("item/list")
	@ResponseBody
	public DatagridPagebean findItemByPage(@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="30") Integer rows) {
		
		DatagridPagebean pagebean = itemService.findItemByPage(page, rows);
		
		return pagebean;
	}
	
	/**
	 *需求：保存商品
	 *参数： TbItem item,TbItemDesc itemDesc
	 *返回值：E3mallResult e3mallResult
	 */
	@RequestMapping("/item/save")
	@ResponseBody
	public E3mallResult saveItem(TbItem item, TbItemDesc itemDesc) {
		E3mallResult e3mallResult = itemService.saveItem(item, itemDesc);
		return e3mallResult;
	}
}
