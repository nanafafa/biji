package com.riji.easyexcelDemo;

import com.alibaba.excel.metadata.Sheet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class SingSheetExport {

    @RequestMapping("/singSheet")
    public void show() {

//        String filePath = "D:/home/chenmingjian/Downloads/测试.xlsx";
//        List<List<Object>> data = new ArrayList<>();
//        data.add(Arrays.asList("111","222","333"));
//        data.add(Arrays.asList("111","222","333"));
//        data.add(Arrays.asList("111","222","333"));
//        List<String> head = Arrays.asList("表头1", "表头2", "表头3");
//        ExcelUtil.writeBySimple(filePath,data,head);
//        System.out.println(111111);
        /**
         * 单个sheet导出，有模型的
         */
//        String filePath = "D:/home/chenmingjian/Downloads/测试.xlsx";
//        ArrayList<TableHeaderExcelProperty> data = new ArrayList<>();
//        for(int i = 0; i < 4; i++){
//            TableHeaderExcelProperty tableHeaderExcelProperty = new TableHeaderExcelProperty();
//            tableHeaderExcelProperty.setName("cmj" + i);
//            tableHeaderExcelProperty.setAge(22 + i);
//            tableHeaderExcelProperty.setSchool("清华大学" + i);
//            data.add(tableHeaderExcelProperty);
//        }
//
//        ExcelUtil.writeWithTemplate(filePath,data);
//

        /**
         * 多个Sheet导出
         */
        String filePath = "D:/home/chenmingjian/Downloads/测试.xlsx";
        ArrayList<ExcelUtil.MultipleSheelPropety> list1 = new ArrayList<>();
        ArrayList<TableHeaderExcelProperty> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            TableHeaderExcelProperty tableHeaderExcelProperty = new TableHeaderExcelProperty();
            tableHeaderExcelProperty.setName("cmj" + i);
            tableHeaderExcelProperty.setAge(22 + i);
            tableHeaderExcelProperty.setSchool("清华大学" + i);
            list.add(tableHeaderExcelProperty);
        }
        int listSize=list.size();
        int toIndex=50;
        int keyToken = 0;
            List newList=new ArrayList();
            int j = 1;
            for(int i = 0;i<list.size();i+=50){
                if(i+50>listSize){        //作用为toIndex最后没有100条数据则剩余几条newList中就装几条
                    toIndex=listSize-i;
                }
                newList = list.subList(i,i+toIndex);
                //System.out.println(newList);
                keyToken++;
                show(j,newList,list1);
                j++;

            }
        ExcelUtil.writeWithMultipleSheel(filePath,list1);
    }
    private void show(int j,List list,ArrayList<ExcelUtil.MultipleSheelPropety> list1){
        Sheet sheet = new Sheet(j, 0);
        sheet.setSheetName("sheet" + j);

        ExcelUtil.MultipleSheelPropety multipleSheelPropety = new ExcelUtil.MultipleSheelPropety();
        multipleSheelPropety.setData(list);
        multipleSheelPropety.setSheet(sheet);

        list1.add(multipleSheelPropety);
    }
}
