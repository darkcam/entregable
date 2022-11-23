package com.bankSys.BankSsy.util.paginacion;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageRender<T> {

    private String url;
    private Page<T> page;
    private int totalPaginas;
    private int numElementosPorPagina;
    private int pagianActual;
    private List<PageItem> paginas;

    public PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        this.paginas = new ArrayList<PageItem>();

        numElementosPorPagina = 4;
        totalPaginas = page.getTotalPages();
        pagianActual = page.getNumber() +1;

        int desde, hasta;
        if(totalPaginas <= numElementosPorPagina){
            desde = 1;
            hasta = totalPaginas;
        }else{
            if(pagianActual <= numElementosPorPagina/2){
                desde = 1;
                hasta = numElementosPorPagina;
            }
            else if(pagianActual >= totalPaginas - numElementosPorPagina/2){
                desde = totalPaginas -numElementosPorPagina+1;
                hasta = numElementosPorPagina;
            }else {
                desde = pagianActual - numElementosPorPagina/2;
                hasta = numElementosPorPagina;
            }
        }

        for (int i = 0; i < hasta; i++){
            paginas.add(new PageItem(desde + i, pagianActual == desde + i));
        }

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public int getPagianActual() {
        return pagianActual;
    }

    public void setPagianActual(int pagianActual) {
        this.pagianActual = pagianActual;
    }

    public List<PageItem> getPaginas() {
        return paginas;
    }

    public void setPaginas(List<PageItem> paginas) {
        this.paginas = paginas;
    }

    public boolean isFirst(){
        return page.isFirst();
    }

    public boolean isLast(){
        return page.isLast();
    }

    public boolean isHasNext(){
        return page.hasNext();
    }

    public boolean isHasPrevius(){
        return page.hasPrevious();
    }

}
