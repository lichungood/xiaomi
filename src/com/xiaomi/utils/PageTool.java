package com.xiaomi.utils;

import java.util.ArrayList;
import java.util.List;

/*
 * 分页工具类
 * */
public class PageTool<T> {
    private int  currentPage; //当前页 ： 页面传递
    private int  pageSize;  //每页记录数
    private int  prePage;  //上一页
    private int  nextPage; //下一页
    private int  totalSize; //总记录数
    private int  startIndex; //每页起始下标
    private int  totalPages; //总页数

    private List<T> result = new ArrayList<>();  //存储每页的记录数

    //初始化
    public  PageTool(String currentPage,int totalSize){
        initCurrentPage(currentPage);  //初始化当前页
        this.totalSize = totalSize; //初始化总条数，由查询数据库得到
        this.pageSize = 3; //每页记录数，固定值
        initTotalPages(); //初始化总页数
        initStartIndex(); //每页起始下标
        initPrePage();  //初始化上一页
        initNextPage(); //初始化下一页


    }

    private void initTotalPages() {
        if(this.totalSize % this.pageSize == 0){
            this.totalPages = this.totalSize / this.pageSize;
//            System.out.println(this.totalSize+"/////"+this.pageSize);
//            System.out.println(this.totalPages+"...");
        }else{
            this.totalPages = (this.totalSize / this.pageSize )+ 1;
//            System.out.println(totalPages+"-----");
        }
    }

    private void initNextPage() {
        if(this.currentPage == this.totalPages){
            this.nextPage = this.totalPages;
        }else{
            this.nextPage = this.currentPage+1;
        }
    }

    private void initPrePage() {
        if(this.currentPage == 1){
            this.prePage = 1;
        }else {
            this.prePage = this.currentPage - 1;
        }
    }

    private void initStartIndex() {
        this.startIndex = (this.currentPage-1)*pageSize;
    }

    private void initCurrentPage(String currentPage) {
        if(currentPage == null){ //第一次访问
            this.currentPage = 1;
        }else{
            this.currentPage = Integer.parseInt(currentPage);
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "PageTool{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", prePage=" + prePage +
                ", nextPage=" + nextPage +
                ", totalSize=" + totalSize +
                ", startIndex=" + startIndex +
                ", totalPages=" + totalPages +
                ", result=" + result +
                '}';
    }
}
