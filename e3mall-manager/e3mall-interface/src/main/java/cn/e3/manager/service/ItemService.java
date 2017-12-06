package cn.e3.manager.service;

import cn.e3.pojo.TbItem;
import cn.e3.utils.DatagridPagebean;

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
	
}
