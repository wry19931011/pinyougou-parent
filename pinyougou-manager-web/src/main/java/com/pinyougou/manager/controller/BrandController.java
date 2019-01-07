package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.MsgResult;
import com.pinyougou.pojo.PageResult;
import com.pinyougou.pojo.QueryInfo;
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
	public PageResult<TbBrand> findBrandByPage(@RequestBody QueryInfo<TbBrand> queryInfo) {
		return brandService.findBrandByPage(queryInfo.getPageNum(), queryInfo.getPageSize(),
				queryInfo.getSearchEntity());
	}

	@RequestMapping("/saveOrUpdate")
	public MsgResult saveOrUpdate(TbBrand tbBrand) {
		MsgResult msgResult = null;
		try {
			if (tbBrand != null) {
				brandService.saveOrUpdate(tbBrand);
				msgResult = new MsgResult(true, "操作品牌成功！");
			}
		} catch (Exception e) {
			msgResult = new MsgResult(false, "操作品牌失败！");
			e.printStackTrace();
		}
		return msgResult;
	}

	@RequestMapping("findOneBrand")
	public TbBrand findOneBrand(Long id) {
		return brandService.findOneBrand(id);
	}

	@RequestMapping("deleteBrand")
	public MsgResult deleteBrand(@RequestParam(value = "ids[]") Long[] ids) {
		MsgResult msgResult = null;
		try {
			brandService.deleteBrand(ids);
			msgResult = new MsgResult(true, "删除品牌成功！");
		} catch (Exception e) {
			msgResult = new MsgResult(true, "删除品牌失败！");
			e.printStackTrace();
		}
		return msgResult;
	}

}
