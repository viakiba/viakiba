package com.tdvm.bean;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.tdvm.bean.page.Pagination;

public class DataTablesParameters {
	
	private int start;
	  private int length;
	  private int orderCol;
	  private String orderDir;
	  private int draw;
	  private HttpServletRequest request;

	  public static DataTablesParameters newInstance(HttpServletRequest request)
	  {
	    return new DataTablesParameters(request);
	  }

	  public DataTablesParameters(HttpServletRequest request)
	  {
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
	  }

	  public DataTablesReply<?> getDataTablesReply(Pagination<?> pagination)
	  {
	    return new DataTablesReply(pagination, getDraw());
	  }
	  public int getStart() {
	    return this.start;
	  }

	  public void setStart(int start) {
	    this.start = start;
	  }

	  public int getLength() {
	    return this.length;
	  }

	  public void setLength(int length) {
	    this.length = length;
	  }

	  public int getDraw() {
	    return this.draw;
	  }

	  public void setDraw(int draw) {
	    this.draw = draw;
	  }

	  public int getOrderCol()
	  {
	    return this.orderCol;
	  }

	  public void setOrderCol(int orderCol) {
	    this.orderCol = orderCol;
	  }

	  public String getOrderDir() {
	    return this.orderDir;
	  }

	  public void setOrderDir(String orderDir) {
	    this.orderDir = orderDir;
	  }

	  public int getPage()
	  {
	    return this.start / this.length + 1;
	  }

	  public String getOrderColName(String[] orderColumns)
	  {
	    return this.orderCol < orderColumns.length ? orderColumns[this.orderCol] : null;
	  }

	  public String getOrderColName()
	  {
	    return this.request.getParameter("columns[" + this.orderCol + "][data]");
	  }

}
