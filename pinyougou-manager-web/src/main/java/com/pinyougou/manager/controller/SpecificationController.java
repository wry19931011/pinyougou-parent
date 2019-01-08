package com.pinyougou.manager.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.MsgResult;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.QueryInfo;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.sellergoods.service.SpecificationService;

@RestController
@RequestMapping("/spec")
public class SpecificationController {

	@Reference
	private SpecificationService specificationService;

	@RequestMapping("/findBrandByPage")
	public PageResult<TbSpecification> findBrandByPage(@RequestBody QueryInfo<TbSpecification> queryInfo) {
		return specificationService.findBrandByPage(queryInfo.getPageNum(), queryInfo.getPageSize());
	}

	@RequestMapping("/saveOrUpdate")
	public MsgResult saveOrUpdate(@RequestBody TbSpecification specification) {
		MsgResult msgResult = null;
		try {
			specificationService.saveOrUpdate(specification, specification.getOptionList());
			msgResult = new MsgResult(true, "操作成功！");
		} catch (Exception e) {
			e.printStackTrace();
			msgResult = new MsgResult(true, "操作失败！");
		}
		return msgResult;

	}

}
