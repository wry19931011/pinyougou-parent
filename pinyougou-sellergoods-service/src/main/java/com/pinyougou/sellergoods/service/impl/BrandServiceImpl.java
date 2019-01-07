package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import tk.mybatis.mapper.entity.Example;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper tbBrandMapper;

	@Override
	public List<TbBrand> findAll() {
		return tbBrandMapper.selectAll();
	}

	@Override
	public PageResult<TbBrand> findBrandByPage(int pageNum, int pageSize, TbBrand searchBrand) {
		PageHelper.startPage(pageNum, pageSize);
		Example example = new Example(TbBrand.class);
		if (StringUtils.isNotEmpty(searchBrand.getName())) {
			example.createCriteria().andLike("name", "%" + searchBrand.getName() + "%");
		}
		if (StringUtils.isNotEmpty(searchBrand.getFirstChar())) {
			example.createCriteria().andLike("firstChar", "%" + searchBrand.getFirstChar() + "%");
		}
		List<TbBrand> tbBrandList = tbBrandMapper.selectByExample(example);
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

	@Override
	public TbBrand findOneBrand(Long id) {
		TbBrand tbBrand = tbBrandMapper.selectByPrimaryKey(id);
		return tbBrand;
	}

	@Override
	public void deleteBrand(Long[] ids) {
		for (Long id : ids) {
			tbBrandMapper.deleteByPrimaryKey(id);
		}
	}

}
