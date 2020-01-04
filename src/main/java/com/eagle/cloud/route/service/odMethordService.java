package com.eagle.cloud.route.service;
/**
 * @title: odMethor
 * @projectName odMethor
 * @description: TODO
 * @date 2019-12-11 10:35
 */

public interface odMethordService {

    //存入od_time_plate 表,调用方法,传入车辆起点门架号、终点门架号、出口时间、车牌，存入数据库
    public   void add_od_time_plate(String original, String destination, String time, String plate);

    /**
     * 查车辆起点算法
     * 传入：所有收费站出口流水实体类、2个主线出口段门架流水实体类、以及广河的东行连凤凰山段、东行连八斗立交、西行连八斗立交段门架流水
     * 返回：该条流水的起点：入口路段的门架号。返回null时，即这辆车还没出去，还在路段内，这是3条特殊路段门架的返回结果。
     */
    public String carODMethor(String[] LSData);

    /**
   查前方门架的方法
   传入：String[]:包含3个字符串：门架号、车牌、时间
   返回：String[]:包含3个字符串：前一个符合时间间隔且含有此车牌的门架号、车牌、时间；若无则返回null，代表找到OD起点了。
    */
    public String[] checkForntGantry(String[] LSData);
}
