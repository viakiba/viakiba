package com.tdvm.cjgl.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="T_COMMONCODE")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CommonCode implements Serializable{

    /** 
    * @Fields serialVersionUID : TODO
    */ 
    private static final long serialVersionUID = -5160393272030682082L;

    @Id   
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name="ID",length=32)
	private String id;
	
	/**
	 * 代码
	 */
	@Column(name="CODE",length=32)
	private String code;
	/**
	 * 名称
	 */
	@Column(name="NAME",length=64)
	private String name;
	/**
	 * 备注
	 */
	@Column(name="NOTE",length=64)
	private String note;
	
	/**
	 * 排序号
	 */
	@Column(name = "order_field", length = 6, nullable = false)
	private long orderField=999;
	/**
	 * 父级
	 */
	@ManyToOne
	@JoinColumn(name="TYPE")
	private CommonCode pCode;
	
	/**
	 * 子级
	 */
	@OneToMany(mappedBy="pCode",cascade={CascadeType.REMOVE},fetch=FetchType.EAGER)
	private Set<CommonCode> cCode;
	public CommonCode getpCode() {
		return pCode;
	}
	public void setpCode(CommonCode pCode) {
		this.pCode = pCode;
	}
	public Set<CommonCode> getcCode() {
		return cCode;
	}
	public void setcCode(Set<CommonCode> cCode) {
		this.cCode = cCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public long getOrderField() {
		return orderField;
	}
	public void setOrderField(long orderField) {
		this.orderField = orderField;
	}
}
