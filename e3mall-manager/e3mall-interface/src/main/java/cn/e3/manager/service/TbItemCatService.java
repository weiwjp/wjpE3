package cn.e3.manager.service;

import java.util.List;

import cn.e3.utils.TreeBean;

public interface TbItemCatService {

	/**
	 * 根据父id查询子结点
	 * 参数：parentId
	 * 返回值：List<TreeBean>
	 */
	List<TreeBean> findByParentId(Long ParentId);
}
