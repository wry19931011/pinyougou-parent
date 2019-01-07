package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper tbBrandMapper;

	@Override
	public List<TbBrand> findAll() {
		return tbBrandMapper.selectAll();
	}

	@Override
	public PageResult<TbBrand> findBrandByPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<TbBrand> tbBrandList = tbBrandMapper.selectAll();
		PageInfo<TbBrand> pageInfo = new PageInfo<>(tbBrandList);
		return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
	}

	@Override
	public void saveOrUpdate(TbBrand tbBrand) {
		// 新增
		if (tbBrand.getId() == null) {
			tbBrandMapper.insert(tbBrand);
		} else {
			tbBrandMapper.updateByPrimaryKey(tbBrand);
		}
	}

}
