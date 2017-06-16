package com.tdvm.bean;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.tdvm.base.UpdateConst;


public class PageInfo {
	
	private int start;
	private int length;
    private int orderCol;
    private String orderDir;
    private String orderName;
    private int draw;
    
    private HttpServletRequest request;

    public static PageInfo newInstance(HttpServletRequest request) {
      return new PageInfo(request);
    }

    public PageInfo(HttpServletRequest request) {
      this.request = request;

      this.start = Integer.parseInt(request.getParameter("start"));
      this.length = Integer.parseInt(request.getParameter("length"));
      String orderColumn = request.getParameter("order[0][column]");

      if (StringUtils.isNotBlank(orderColumn)) {
        this.orderCol = Integer.parseInt(orderColumn);
        this.orderCol = (this.orderCol < 0 ? 0 : this.orderCol);
      } else {
        this.orderCol = 9999999;
      }

      String dir = request.getParameter("order[0][dir]");
      if (StringUtils.isNotBlank(dir)) {
        this.orderDir = dir.trim().toUpperCase();
        if ((!this.orderDir.equals("ASC")) && (!this.orderDir.equals("DESC")))
          this.orderDir = "ASC";
      }
      else {
        this.orderDir = "ASC";
      }

      this.draw = Integer.parseInt(request.getParameter("draw"));
      this.orderName  = this.request.getParameter("columns[" + this.orderCol + "][data]");
    }
//    
//    public String getOrderColName(String[] orderColumns) {
//      return this.orderCol < orderColumns.length ? orderColumns[this.orderCol] : null;
//    }
//
//    public String getOrderColName()  {
//      return this.request.getParameter("columns[" + this.orderCol + "][data]");
//    }
      

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
    

    
	/**
	 * 开始位置
	 */
	private Integer startPage = 0;


	/**
	 * 结束位置
	 */
	private Integer endPage = 10;

	/**
	 * 总记录数
	 */
	private Integer totolPage;
	
	private Integer totalNum;

	/**
	 * 每页数量
	 */
	private Integer pageSize = 10;

	/**
	 * 错误信息
	 */
	private String data;

	/**
	 * 请求状�?
	 */
	private String state = UpdateConst.RESULT_BEAN_STATE_FAIL;

	/**
	 * 查询结果
	 */
	private Object object;

	/**
	 * 排序
	 */
	private String order;
	
	/**
	 * 当前页数
	 */
	private Integer currPage =1;
	
	
	public int getFirstResult() {//分页数据第一条数据的RowNum
		return (currPage-1) * pageSize;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public Integer getTotolPage() {
		return totolPage;
	}

	public void setTotolPage(Integer totolPage) {
		this.totolPage = totolPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Integer getCurrPage() {
		return start/length + 1;
//		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getOrderCol() {
		return orderCol;
	}

	public void setOrderCol(int orderCol) {
		this.orderCol = orderCol;
	}

	public String getOrderDir() {
		return orderDir;
	}

	public void setOrderDir(String orderDir) {
		this.orderDir = orderDir;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	

}
