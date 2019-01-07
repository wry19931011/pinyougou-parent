package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.MsgResult;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;

	@RequestMapping("/findAll")
	public List<TbBrand> findAll() {
		return brandService.findAll();
	}

	@RequestMapping("/findBrandByPage")
	public PageResult<TbBrand> findBrandByPage(Integer pageNum, Integer pageSize) {
		return brandService.findBrandByPage(pageNum, pageSize);
	}

	@RequestMapping("/saveOrUpdate")
	public MsgResult saveOrUpdate(TbBrand tbBrand) {
		MsgResult msgResult = null;
		try {
			if (tbBrand != null) {
				brandService.saveOrUpdate(tbBrand);
				msgResult = new MsgResult(true, "新增品牌成功！");
			}
		} catch (Exception e) {
			msgResult = new MsgResult(false, "新增品牌失败！");
			e.printStackTrace();
		}
		return msgResult;
	}

}
