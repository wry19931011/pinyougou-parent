package com.pinyougou.sellergoods.service;


import java.util.List;

import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;

public interface SpecificationService {
	/**
	 * 分页获取品牌列表
	 * 
	 * @param pageNum  当前页
	 * @param pageSize 每页条数
	 * @return
	 */
	public PageResult<TbSpecification> findBrandByPage(int pageNum, int pageSize);

	/**
	 * 保存或者新增
	 * @param specification
	 * @param optionList
	 */
	public void saveOrUpdate(TbSpecification specification, List<TbSpecificationOption> optionList);
}
