package com.eagle.cloud.route.service.impl;
/**
 * @title: odMethordServiceImpl
 * @projectName odMethor
 * @description: TODO
 * @date 2019-12-11 10:37
 */

import com.eagle.cloud.route.dao.SysScreenDao;
import com.eagle.cloud.route.model.SysScreen;
import com.eagle.cloud.route.service.odMethordService;
import com.eagle.cloud.route.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class odMethordServiceImpl implements odMethordService {

    @Autowired
    private SysScreenDao sysScreenDao;

    //门架之间前后关系数据表：
    public Map<String, List> datamap= new HashMap<String, List>(){{

        put("mghd01",new ArrayList(){{add("m0");}});
        put("mghd02",new ArrayList(){{add("mghd01");}});
        put("mghd03",new ArrayList(){{add("mghd02");}});
        put("mghd04",new ArrayList(){{add("mghd03");}});
        put("mghd05",new ArrayList(){{add("mghd04");}});
        put("mghd06",new ArrayList(){{add("mghd05");}});
        put("mghd07",new ArrayList(){{add("mghd06");add("mbshb03");add("mbshn04");}});
        put("mghd08",new ArrayList(){{add("mghd07");}});
        put("mghd09",new ArrayList(){{add("mghd08");}});
        put("mghd10",new ArrayList(){{add("mghd09");add("mzcb05");add("mzcn04");}});
        put("mghd11",new ArrayList(){{add("mghd10");}});

        put("mghx01",new ArrayList(){{add("mghx02");}});
        put("mghx02",new ArrayList(){{add("mghx03");}});
        put("mghx03",new ArrayList(){{add("mghx04");}});
        put("mghx04",new ArrayList(){{add("mghx05");}});
        put("mghx05",new ArrayList(){{add("mghx06");}});
        put("mghx06",new ArrayList(){{add("mghx07");add("mbshb03");add("mbshn04");}});
        put("mghx07",new ArrayList(){{add("mghx08");}});
        put("mghx08",new ArrayList(){{add("mghx09");}});
        put("mghx09",new ArrayList(){{add("mghx10");add("mzcb05");add("mzcn04");}});
        put("mghx10",new ArrayList(){{add("mghx11");}});
        put("mghx11",new ArrayList(){{add("m0");}});

        put("mbshb01",new ArrayList(){{add("m0");}});
        put("mbshb02",new ArrayList(){{add("mbshb01");}});
        put("mbshb03",new ArrayList(){{add("mbshb02");}});
        put("mbshb04",new ArrayList(){{add("mbshb03");add("mghd06");add("mghx07");}});
        put("mbshb05",new ArrayList(){{add("mbshb04");}});

        put("mbshn01",new ArrayList(){{add("mbshn02");}});
        put("mbshn02",new ArrayList(){{add("mbshn03");}});
        put("mbshn03",new ArrayList(){{add("mbshn04");add("mghd06");add("mghx07");}});
        put("mbshn04",new ArrayList(){{add("mbshn05");}});
        put("mbshn05",new ArrayList(){{add("m0");}});

        put("mzcb01",new ArrayList(){{add("mzcb02");}});
        put("mzcb02",new ArrayList(){{add("mzcb03");}});
        put("mzcb03",new ArrayList(){{add("mzcb04");}});
        put("mzcb04",new ArrayList(){{add("mzcb05");add("mghd09");add("mghx10");}});
        put("mzcb05",new ArrayList(){{add("mzcb06");}});
        put("mzcb06",new ArrayList(){{add("mzcb07");}});
        put("mzcb07",new ArrayList(){{add("mzcb08");}});
        put("mzcb08",new ArrayList(){{add("m0");}});
        put("mzcb09",new ArrayList(){{add("mzcb04");}});
        put("mzcb10",new ArrayList(){{add("mzcb09");}});

        put("mzcn01",new ArrayList(){{add("m0");}});
        put("mzcn02",new ArrayList(){{add("mzcn01");}});
        put("mzcn03",new ArrayList(){{add("mzcn02");}});
        put("mzcn04",new ArrayList(){{add("mzcn03");add("mzcn09");}});
        put("mzcn05",new ArrayList(){{add("mzcn04");add("mghd09");add("mghx10");}});
        put("mzcn06",new ArrayList(){{add("mzcn05");}});
        put("mzcn07",new ArrayList(){{add("mzcn06");}});
        put("mzcn08",new ArrayList(){{add("mzcn07");}});
        put("mzcn09",new ArrayList(){{add("mzcn10");}});
        put("mzcn10",new ArrayList(){{add("m0");}});

        put("mbdz",new ArrayList(){{add("mghd03");add("mghx04");}});
        put("mfsz",new ArrayList(){{add("mghd04");add("mghx05");}});
        put("mzscz",new ArrayList(){{add("mghd05");add("mghx06");}});
        put("mzxz",new ArrayList(){{add("mghd06");add("mghx07");add("mbshb03");add("mbshn04");}});
        put("melz",new ArrayList(){{add("mghd07");add("mghx08");}});
        put("mlpz",new ArrayList(){{add("mghd08");add("mghx09");}});
        put("mzgz",new ArrayList(){{add("mghd10");add("mghx11");}});

        put("mlcz",new ArrayList(){{add("mbshb01");add("mbshn02");}});
        put("mzcdz",new ArrayList(){{add("mbshb02");add("mbshn03");}});
        put("mxhz",new ArrayList(){{add("mbshb04");add("mbshn05");}});

        put("mzcz",new ArrayList(){{add("mzcb08");add("mzcn07");}});
        put("mzgnz",new ArrayList(){{add("mzcb07");add("mzcn06");}});
        put("mxlz",new ArrayList(){{add("mzcb06");add("mzcn05");}});
        put("mptz",new ArrayList(){{add("mzcb04");add("mzcn03");add("mzcn09");}});
        put("mgcz",new ArrayList(){{add("mzcb03");add("mzcn02");}});
        put("mtyz",new ArrayList(){{add("mzcb02");add("mzcn01");}});
        put("msfz",new ArrayList(){{add("mzcb09");add("mzcn10");}});
        put("mjkz",new ArrayList(){{add("mzcb10");}});
    }};


    @Override
    public void add_od_time_plate(String original, String destination, String time, String plate) {
        //将门架号翻译成具体站名
        System.out.println("dao对象："+sysScreenDao);
        System.out.println("传入起到"+original);

        String reOriginal = sysScreenDao.getEntranceByGantryID(original);
        String reDestination = sysScreenDao.getExitByGantryID(destination);

        sysScreenDao.add_od_time_plate_table(reOriginal,reDestination,time,plate);
    }

    @Override
    public String carODMethor(String[] LSData) {
        //准备好容器，装有用的数据
        String regantry = LSData[0];
        String replate= null;
        String retime= null;
//        logger.info("LSData:"+LSData[0]+LSData[1]+LSData[2]);

        //循环调用查前方门架的方法，直到找不到为止，得到OD起点
        for(String[] reList = checkForntGantry(LSData) ;reList[0] !="m0";reList = checkForntGantry(LSData)){
            regantry = reList[0];
            replate = reList[1];
            retime = reList[2];
            LSData[0] = regantry;
            LSData[1] = replate;
            LSData[2] = retime;
        }
//        logger.info("找到起点："+regantry);

        return regantry;

    }

    @Override
    public String[] checkForntGantry(String[] LSData) {
        //拿到此次门架编号、车牌、时间
        String gantry = LSData[0];
        String plate = LSData[1];
        String time = LSData[2];

        //数据表：当前门架的前方门架列表:datamap。
        //获取当前门架的前方门架列表
        List dataList = datamap.get(gantry);
        //最多有3种前方门架，需要全部遍历该列表
        int i = 0;//用于记录循环次数，以便获知合适遍历到最后一个
        a:for(Object forntGantry: dataList){
            i= i+1;

            try {

                String oldTime = sysScreenDao.getTimeWithPlateAndGantry(plate, (String) forntGantry);
                //上面得到了该车牌是否在前一门架通过，如果没有则报错，抓起处理
                //下面返回该车牌通过前一门架的时间：YYYY-MM-DD hh:mm:ss

                //下面是最近一次通过前面门架与本次通过门架的时间之差，单位：天，即1小时=0.04167天
                double doubleMargin = DateUtil.getDoubleMargin(time,oldTime);
                System.out.println("时间间隔："+doubleMargin);
                //判断有无超过1小时，1小时=0.04167天
                if(doubleMargin<=0.04167 && doubleMargin >0 ){
//                    logger.info("返回前一个门架、车牌、时间："+forntGantry+plate+oldTime);
//					System.out.println("返回前一个门架、车牌、时间："+forntGantry+plate+oldTime);
                    return new String[]{(String) forntGantry,plate,oldTime};
                }
                else {
                    continue a;
                }
            } catch (NullPointerException e) {
                if (i==dataList.size()){
                    break a;
                }
                else {
                    continue a;
                }
            }
        }
//        logger.info("没有通过前方门架，找到起点"+gantry);
        return new String[]{"m0"};
    }
}
