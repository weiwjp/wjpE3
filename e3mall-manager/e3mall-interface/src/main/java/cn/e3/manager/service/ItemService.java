package cn.e3.manager.service;

import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.utils.DatagridPagebean;
import cn.e3.utils.E3mallResult;

public interface ItemService {

	/**
	 * 根据id查询
	 */
	TbItem findById(Long id);
	
	/**
	 *需求：分页查询商品
	 * 参数：page 和rows
	 * 返回值：DatagridPagebean
	 */
	DatagridPagebean findItemByPage(Integer page,Integer rows);
	/**
	 *需求：保存商品
	 *参数： TbItem item,TbItemDesc itemDesc
	 *返回值：E3mallResult e3mallResult
	 */
	public E3mallResult saveItem(TbItem item,TbItemDesc itemDesc);
}
