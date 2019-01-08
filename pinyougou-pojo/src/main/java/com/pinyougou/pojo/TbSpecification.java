package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_specification")
public class TbSpecification implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5963544798517861298L;

	/**
	 * 主键
	 */
	@Id
	@Column(name = "id")
	private Long id;

	/**
	 * 名称
	 */
	@Column(name = "spec_name")
	private String specName;

	private List<TbSpecificationOption> optionList;

	public List<TbSpecificationOption> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<TbSpecificationOption> optionList) {
		this.optionList = optionList;
	}

	/**
	 * 获取主键
	 *
	 * @return id - 主键
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置主键
	 *
	 * @param id 主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 获取名称
	 *
	 * @return spec_name - 名称
	 */
	public String getSpecName() {
		return specName;
	}

	/**
	 * 设置名称
	 *
	 * @param specName 名称
	 */
	public void setSpecName(String specName) {
		this.specName = specName;
	}
}