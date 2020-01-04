package com.eagle.cloud.route.controller;
/**
 * @title: RoadController
 * @projectName display-route-sync
 * @description: TODO
 * @date 2019-11-8 15:24
 */

//import com.eagle.cloud.route.service.RoadService;

import com.eagle.cloud.route.dao.SysScreenDao;
import com.eagle.cloud.route.service.ODMethorService;
import com.eagle.cloud.route.service.ScreenService;
import com.eagle.cloud.route.utils.DateUtil;
import com.eagle.cloud.route.utils.randomByWeightUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

//import com.eagle.cloud.route.vo.StepsRecordNew;

/**
 *@Description: TODO
 *@Author: fwj
 *@Date: 2019-11-8 15:24
 *@Verion: 1.0
 **/
@RestController
@RequestMapping(value = "/roadInfo")
public class RoadController {

    @Autowired
    private SysScreenDao screenDao;

    @Autowired
    private ScreenService screenService;

    //OD表
    @RequestMapping(value = "/ODMethod",method = RequestMethod.GET)
    public List<Map> ODMethod() throws SQLException {

        //从数据库获取
        List<Map> mapList = screenDao.getODFromTable();

        //只展示前100
        return mapList.subList(0,100);
    }


    //OD画线,测试
    @RequestMapping(value = "/ODPolyline", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public StringBuilder ODPolyline(@RequestBody String[] object) {
        StringBuilder strBur = screenService.getGDReadInfo(object[0], object[1]);
        System.out.println("gdReadInfo="+strBur);
        return strBur;
    }

    //OD画线,测试2
    @RequestMapping(value = "/ODPolyline1", method = RequestMethod.GET)
    @ResponseBody
    public double ODPolyline1() {
        double doubleMargin = DateUtil.getDoubleMargin("2019-12-24 10:34:27","2019-12-24 10:34:26");

//        StringBuilder strBur = screenService.getGDReadInfo("113.366337,23.208694","113.389761,23.211431");
//        System.out.println("gdReadInfo="+strBur);

        return doubleMargin;
    }


    /**
     * OD画线
     */
    @RequestMapping(value = "/getObject", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public Map<String,Object> getObject(@RequestBody String[] object) {
//        logger.info(" 进入 gettdyxfdajllsInfo 函数 获取党员先锋档案展示信息 ");
        System.out.println("post返回1："+object[0]);
        System.out.println("post返回2："+object[1]);
        String original=object[0];
        String destination=object[1];

        Map<String,String> od = screenDao.getODPolyline(original, destination);

        if (od==null){

            System.out.println("OD互换"+object[0]+object[1]);
            original=object[1];
            destination=object[0];
            od = screenDao.getODPolyline(original, destination);
        }

        System.out.println("od:"+od);

        StringBuilder odPolyline = screenService.getGDReadInfo(od.get("ori"),od.get("des"));

        Map<String,StringBuilder> modelMap  = new HashMap<String,StringBuilder>();
        modelMap.put("polyline",odPolyline);
        List<Map> list = new ArrayList();
        list.add(modelMap);
        Map<String,Object> resulrMap  = new HashMap<String,Object>();
        resulrMap.put("roadInfo",list);
        return  resulrMap;
        //return new ControllerResult<?>(, ErrorCode.SUCCESS);
    }

    //随机展示10条流水信息
    @RequestMapping(value = "/showLSData",method = RequestMethod.GET)
    public List<Map> showLSData() throws SQLException {

        //从数据库获取
        List<Map> mapList = screenDao.showLSData();

        for (Map map:mapList){
            //按权重生成车种和车型
            int[][] cartype = {{1,8},{2,2}};
            int[][] carmodel = {{1,7},{3,1},{4,1}};

            int carTyp = randomByWeightUtil.RandomByWeight(cartype);
            int carModel = randomByWeightUtil.RandomByWeight(carmodel);
            //随机生成费用
            Random random = new Random();
            int fare = random.nextInt(50)*3;
            System.out.println("车种车型费用："+carTyp+","+carModel+","+fare);

            String carTypeStr ="客";

            if (carTyp==2){
                carTypeStr="货";
            }
            map.put("carType",carTypeStr+carModel);
            map.put("fare",fare);
            map.put("tradingStatus","成功");
            map.replace("time",((String)map.get("time")).substring(0,16));
        }

        System.out.println(mapList);
        //只展示前10
        return mapList;
    }

}
