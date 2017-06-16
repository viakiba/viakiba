package com.hrmsys.model;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */

public class Menu implements java.io.Serializable {

	// Fields

	private Integer menuId;
	private String menuTitle;
	private Integer menuParentId;
	private Integer menuLeaf;
	private String menuUrl;
	private String menuIcon;

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** minimal constructor */
	public Menu(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	/** full constructor */
	public Menu(String menuTitle, Integer menuParentId, Integer menuLeaf,
			String menuUrl, String menuIcon) {
		this.menuTitle = menuTitle;
		this.menuParentId = menuParentId;
		this.menuLeaf = menuLeaf;
		this.menuUrl = menuUrl;
		this.menuIcon = menuIcon;
	}

	// Property accessors

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuTitle() {
		return this.menuTitle;
	}

	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}

	public Integer getMenuParentId() {
		return this.menuParentId;
	}

	public void setMenuParentId(Integer menuParentId) {
		this.menuParentId = menuParentId;
	}

	public Integer getMenuLeaf() {
		return this.menuLeaf;
	}

	public void setMenuLeaf(Integer menuLeaf) {
		this.menuLeaf = menuLeaf;
	}

	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getMenuIcon() {
		return this.menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

}