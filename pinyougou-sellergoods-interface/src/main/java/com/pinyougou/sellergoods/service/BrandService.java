package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.TbBrand;

public interface BrandService {

	public List<TbBrand> findAll();

	/**
	 * 分页获取品牌列表
	 * 
	 * @param pageNum  当前页
	 * @param pageSize 每页条数
	 * @return
	 */
	public PageResult<TbBrand> findBrandByPage(int pageNum, int pageSize,TbBrand searchBrand);

	/**
	 * 新增或更新
	 * 
	 * @param tbBrand
	 */
	public void saveOrUpdate(TbBrand tbBrand);

	/**
	 * 获取一个品牌
	 * 
	 * @param id
	 * @return
	 */
	public TbBrand findOneBrand(Long id);

	/**
	    * 删除品牌
	 * @param ids
	 */
	public void deleteBrand(Long[] ids);

}
