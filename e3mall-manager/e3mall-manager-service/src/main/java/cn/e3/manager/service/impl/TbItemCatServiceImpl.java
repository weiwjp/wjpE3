package cn.e3.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import cn.e3.manager.service.TbItemCatService;
import cn.e3.mapper.TbItemCatMapper;
import cn.e3.pojo.TbItemCat;
import cn.e3.pojo.TbItemCatExample;
import cn.e3.pojo.TbItemCatExample.Criteria;
import cn.e3.utils.TreeBean;

@Service
public class TbItemCatServiceImpl implements TbItemCatService{

	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	
	/**
	 * 根据父id查询子结点
	 * 参数：parentId
	 * 返回值：List<TreeBean>
	 */
	@Override
	public List<TreeBean> findByParentId(Long ParentId) {
		
		TbItemCatExample example = new TbItemCatExample(); 
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(ParentId);
		
		List<TbItemCat> catlist = tbItemCatMapper.selectByExample(example);
		
		//将数据封装到List<TreeBean>
		List<TreeBean> list = new ArrayList<TreeBean>();
		
		for (TbItemCat tbItemCat : catlist) {
			TreeBean treeBean = new TreeBean();
			
			treeBean.setId(tbItemCat.getId());
			treeBean.setText(tbItemCat.getName());
			treeBean.setState(tbItemCat.getIsParent()? "closed":"open");
			
			list.add(treeBean);
		}
		return list;
	}

}
