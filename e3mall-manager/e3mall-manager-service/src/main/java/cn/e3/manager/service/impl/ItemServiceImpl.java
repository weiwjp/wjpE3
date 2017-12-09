package cn.e3.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Data;

import cn.e3.manager.service.ItemService;
import cn.e3.mapper.TbItemDescMapper;
import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemDesc;
import cn.e3.pojo.TbItemExample;
import cn.e3.utils.DatagridPagebean;
import cn.e3.utils.E3mallResult;
import cn.e3.utils.IDUtils;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	private  TbItemMapper tbItemMapper;
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
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

	/**
	 *需求：保存商品
	 *参数： TbItem item,TbItemDesc itemDesc
	 *返回值：E3mallResult e3mallResult
	 */
	@Override
	public E3mallResult saveItem(TbItem item, TbItemDesc itemDesc) {
		long id = IDUtils.genItemId();
		item.setId(id);
		item.setStatus((byte)1);
		Date date = new Date();
		item.setCreated(date);
		item.setUpdated(date);
		
		tbItemMapper.insert(item);
		
		itemDesc.setItemId(id);
		itemDesc.setCreated(date);
		itemDesc.setUpdated(date);
		tbItemDescMapper.insert(itemDesc);
		return E3mallResult.ok();
	}

}
