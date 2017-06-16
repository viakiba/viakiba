package com.tdvm.bean.page;

public class SimplePage
{
  public static final int PAGE_SIZE = 20;
  protected int totalCount = 0;
  protected int pageSize = 20;
  protected int pageNo = 1;

  public SimplePage()
  {
  }

  public SimplePage(Integer pageNo, Integer pageSize, int totalCount)
  {
    setTotalCount(totalCount);
    setPageSize(pageSize);
    setPageNo(pageNo);
    adjustPageNo();
  }

  public void adjustPageNo()
  {
    if (this.pageNo == 1) {
      return;
    }
    int tp = getTotalPage();
    if (this.pageNo > tp)
      this.pageNo = tp;
  }

  public int getPageNo()
  {
    return this.pageNo;
  }

  public int getPageSize() {
    return this.pageSize;
  }

  public int getTotalCount() {
    return this.totalCount;
  }

  public int getTotalPage() {
    int totalPage = this.totalCount / this.pageSize;
    if ((totalPage == 0) || (this.totalCount % this.pageSize != 0)) {
      totalPage++;
    }
    return totalPage;
  }

  public boolean isFirstPage() {
    return this.pageNo <= 1;
  }

  public boolean isLastPage() {
    return this.pageNo >= getTotalPage();
  }

  public int getNextPage() {
    if (isLastPage()) {
      return this.pageNo;
    }
    return this.pageNo + 1;
  }

  public int getPrePage()
  {
    if (isFirstPage()) {
      return this.pageNo;
    }
    return this.pageNo - 1;
  }

  public void setTotalCount(int totalCount)
  {
    if (totalCount < 0)
      this.totalCount = 0;
    else
      this.totalCount = totalCount;
  }

  public void setPageSize(Integer pageSize)
  {
    if ((pageSize == null) || (pageSize.intValue() < 1))
      this.pageSize = 20;
    else
      this.pageSize = pageSize.intValue();
  }

  public void setPageNo(Integer pageNo)
  {
    if ((pageNo == null) || (pageNo.intValue() < 1))
      this.pageNo = 1;
    else
      this.pageNo = pageNo.intValue();
  }
}