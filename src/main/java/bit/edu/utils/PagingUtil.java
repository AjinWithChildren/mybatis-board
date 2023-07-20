package bit.edu.utils;

import java.util.List;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public class PagingUtil<T>  {
    private int totalCount;
    private int totalPage;
    private int pageSize;
    private int pageNum;
    private int offSet;
    private int startPage;
    private int endPage;
    private boolean hasPrev;
    private boolean hasNext;
    private List<T> contents;

    public PagingUtil(int totalCount, int pageNum, List<T> contents) {
        if (pageNum < 0) {
            pageNum = 0;
        }

        this.totalCount = totalCount;
        this.totalPage = countTotalPage(totalCount);

        if (pageNum > totalPage) {
            pageNum = totalCount;
        }

        this.pageSize = 10;
        this.pageNum = pageNum;
        this.offSet = (pageNum - 1) * 10;
        this.startPage = (pageNum - 1) / 10 * 10 + 1;
        this.endPage = Math.min(this.startPage + 9, totalPage);
        this.hasPrev = pageNum > 1;
        this.hasNext = pageNum < totalPage;
        this.contents = contents;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getOffSet() {
        return offSet;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public boolean isHasPrev() {
        return hasPrev;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public List<T> getContents() {
        return contents;
    }

    public int countTotalPage(int totalPage){
        int countPage = 0;

        if((totalPage % 10) == 0){
            countPage = totalPage / 10;
        }else {
            countPage = (totalPage / 10) + 1;
        }
        return countPage;
    }
}
