package com.gfl.excels;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class ExcelUtils {

        public static void exportExcel(List list, HttpServletResponse response){
            try {
                /*获得对象*/
                Object oooooo = list.get(0);
                /*反射机制中的对象.getClass,获取当前类*/
                Class oClass = oooooo.getClass();
     /*标题*/
                /*获取当前类上的注解*/
                ExcelTitle annotation = (ExcelTitle) oClass.getAnnotation(ExcelTitle.class);
                /*获取注解值*/
                String title = annotation.title();
                /*创建workbook*/
                XSSFWorkbook workbook=new XSSFWorkbook();
                /*创建sheet,同时将获取到的注解信息放进去,也就是sheet名*/
                XSSFSheet sheet = workbook.createSheet(title);
    /*列头*/
                int cellCount=0;
                XSSFRow row = sheet.createRow(0);
                /*获取所有字段的数组*/
                Field[] fields = oClass.getDeclaredFields();
                for (int i = 0; i <fields.length ; i++) {
                    Field field = fields[i];
                    /*获取字段上的注解*/
                    ExcelField fieldAnnotation = field.getAnnotation(ExcelField.class);
                    /*判断是否为空*/
                    if(fieldAnnotation!=null){
                        /*获取注解值*/
                        String s = fieldAnnotation.fieldName();
                        XSSFCell cell = row.createCell(cellCount);
                        cell.setCellValue(s);
                        cellCount++;
                    }
                }
    /*数据*/
                for (int i = 0; i < list.size() ; i++) {
                    Object o1 = list.get(i);
                    XSSFRow row1 = sheet.createRow(i + 1);
                    int cellCount1=0;
                    for (int j = 0; j < fields.length; j++) {
                        Field field = fields[j];
                        /*判断当前字段是否存在该注解*/
                        boolean annotationPresent = field.isAnnotationPresent(ExcelField.class);
                        if(annotationPresent==true){
                            XSSFCell cell = row1.createCell(cellCount1);
                            field.setAccessible(true);
                            Object o2 = field.get(o1);
                            if(o2!=null){
                                /*获取字段的类型*/
                                Class type = field.getType();
                                if(type== Date.class){
                                    SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
                                    Date date=(Date) o2;
                                    String s = sim.format(date);
                                    cell.setCellValue(s);
                                }else {
                                    cell.setCellValue(o2.toString());
                                }
                            }else {
                                    cell.setCellValue("");
                            }
                            cellCount1++;
                        }
                    }
                }




                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/octet-stream");
                response.addHeader("Content-Disposition", "attachment; filename=\""+ UUID.randomUUID().toString()+".xlsx\"");

                ServletOutputStream outputStream = null;
                try {
                    outputStream = response.getOutputStream();
                    workbook.write(outputStream);
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }catch(Exception e){
                e.printStackTrace();
            }

        }

}
