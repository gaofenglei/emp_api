package com.gfl.bean;

import lombok.Data;

import java.util.List;

@Data
public class DataTable<T> {

     private Integer start;//    开始下表start
     private Integer length;//       每页条数length
     private Integer draw=1;//       绘制次数draw=1
     private Long    recordsTotal=0l;//       总长度recordsTotal
     private Long    recordsFiltered=0l;//       过滤后的长度recordsFiltered
     private List<T> data;//包含的数据data

}
