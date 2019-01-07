package com.pinyougou.pojo;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "tb_content_category")
public class TbContentCategory implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4834278391950820302L;

	/**
     * 类目ID
     */
    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 分类名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 获取类目ID
     *
     * @return id - 类目ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置类目ID
     *
     * @param id 类目ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分类名称
     *
     * @return name - 分类名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置分类名称
     *
     * @param name 分类名称
     */
    public void setName(String name) {
        this.name = name;
    }
}