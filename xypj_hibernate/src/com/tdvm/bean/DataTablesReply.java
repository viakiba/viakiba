package com.tdvm.bean;

import java.util.ArrayList;
import java.util.List;

import com.tdvm.bean.page.Pagination;

public class DataTablesReply<T>
{
  private int recordsTotal;
  private int recordsFiltered;
  private int draw;
  private List<T> data;

  public DataTablesReply()
  {
  }

  public DataTablesReply(Pagination<T> page)
  {
    setData(page.getList());
    setRecordsFiltered(page.getTotalCount());
    setRecordsTotal(page.getTotalCount());
  }

  public DataTablesReply(Pagination<T> page, int draw)
  {
    setData(page.getList());
    setRecordsFiltered(page.getTotalCount());
    setRecordsTotal(page.getTotalCount());
    this.draw = draw;
  }

  public int getRecordsTotal() {
    return this.recordsTotal;
  }

  public void setRecordsTotal(int recordsTotal) {
    this.recordsTotal = recordsTotal;
  }

  public int getRecordsFiltered() {
    return this.recordsFiltered;
  }

  public void setRecordsFiltered(int recordsFiltered) {
    this.recordsFiltered = recordsFiltered;
  }

  public int getDraw() {
    return this.draw;
  }

  public void setDraw(int draw) {
    this.draw = draw;
  }

  public List<T> getData() {
    if (this.data == null) {
      this.data = new ArrayList();
    }
    return this.data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }
}
