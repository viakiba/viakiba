package com.tdvm.bean.page;


import java.io.Serializable;
import java.util.List;

public class Pagination<T> extends SimplePage
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private List<T> list;

  public Pagination(Integer pageNo, Integer pageSize, int totalCount)
  {
    super(pageNo, pageSize, totalCount);
  }

  public Pagination(Integer pageNo, Integer pageSize, int totalCount, List<T> list)
  {
    super(pageNo, pageSize, totalCount);
    this.list = list;
  }

  public int getFirstResult()
  {
    return (this.pageNo - 1) * this.pageSize;
  }

  public List<T> getList()
  {
    return this.list;
  }

  public void setList(List<T> list)
  {
    this.list = list;
  }
}
