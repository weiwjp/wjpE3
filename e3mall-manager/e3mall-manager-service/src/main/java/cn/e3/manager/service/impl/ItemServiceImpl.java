package cn.e3.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3.manager.service.ItemService;
import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemExample;
import cn.e3.utils.DatagridPagebean;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private  TbItemMapper tbItemMapper;
	/**
	 * 根据id查询
	 */
	@Override
	public TbItem findById(Long id) {
		TbItem tbItem = tbItemMapper.selectByPrimaryKey(id);
		return tbItem;
	}
	
	/**
	 *需求：分页查询商品
	 * 参数：page 和rows
	 * 返回值：DatagridPagebean
	 */
	public DatagridPagebean findItemByPage(Integer page, Integer rows) {
		TbItemExample itemExample = new TbItemExample();
		
		PageHelper.startPage(page, rows);
		List<TbItem> list = tbItemMapper.selectByExample(itemExample);
		
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		
		DatagridPagebean pagebean = new DatagridPagebean();
		pagebean.setTotal(pageInfo.getTotal());
		pagebean.setRows(pageInfo.getList());
		return pagebean;
	}

}
