package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.sellergoods.service.SpecificationService;

@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private TbSpecificationMapper tbSpecificationMapper;

	@Autowired
	private TbSpecificationOptionMapper tbSpecificationOptionMapper;

	@Override
	public PageResult<TbSpecification> findBrandByPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<TbSpecification> tbBrandList = tbSpecificationMapper.selectAll();
		PageInfo<TbSpecification> pageInfo = new PageInfo<>(tbBrandList);
		return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
	}

	@Override
	public void saveOrUpdate(TbSpecification specification, List<TbSpecificationOption> optionList) {
		tbSpecificationMapper.insert(specification);
		for (TbSpecificationOption option : optionList) {
			option.setSpecId(specification.getId());
			tbSpecificationOptionMapper.insert(option);
		}
	}

}
