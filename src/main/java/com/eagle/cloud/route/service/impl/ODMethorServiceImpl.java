package com.eagle.cloud.route.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.eagle.cloud.route.controller.*;
import com.eagle.cloud.route.model.LSmodel;
import com.eagle.cloud.route.service.AsyncService;
//import com.eagle.cloud.route.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eagle.cloud.route.dao.SysScreenDao;
import com.eagle.cloud.route.service.ODMethorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ODMethorServiceImpl implements ODMethorService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private  SysScreenDao screenDao;

	//门架之间前后关系数据表：
	private  Map<String, List> datamap= new HashMap<String, List>(){{

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

	/**
	 * OD算法:
	 * 每10分钟运行一次
	 * 更新od_time_plate 表
	 */
	public void getODFromLS(){

		//建议在每个方法中都new一个新的SimpleDateFormat对象，因为SimpleDateFormat在多线程环境下，是线程不安全的
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		//获取前15分钟、前15分零10秒的时间
		Date date = new Date();
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(Calendar.SECOND,-60);
		Date oneMinuteBefore=c.getTime();
		c.setTime(date);
		c.add(Calendar.SECOND,-70);
		Date seventeenSecondBefore=c.getTime();
		String oneMinuteBeforeTime = simpleDateFormat.format(oneMinuteBefore);
		String seventeenSecondBeforeTime = simpleDateFormat.format(seventeenSecondBefore);

		logger.info("15分钟前时间："+oneMinuteBeforeTime);
		logger.info("15分零10秒前时间："+seventeenSecondBeforeTime);


		//从总data表中取10分钟（前11分钟到前1分钟）的出口车流水，出口：28个：10个主线：mghd01,mghd02,mghx03,mghx01,mghd11,mbshn01,mbshb05,mzcn08,mzcb01,mzcb10 18个收费站
		List<LSmodel> LSList = screenDao.getODLSFromData(oneMinuteBeforeTime,seventeenSecondBeforeTime);

		logger.info("拿到10s流水");

		for(LSmodel ls : LSList) {

			//把流水的有用信息拿出来，放入一个字符串数组
			String gantry = ls.getGantryID();
			String plate = ls.getPlate();
			String time = ls.getTime();
			String[] LSData = {gantry,plate,time};

			//判断ls实体类通过的门架是否是3个特殊门架之一（广河的东行连凤凰山段、东行连八斗立交、西行连八斗立交段门架），需要额外处理
			if(gantry.equals("mghd01")||gantry.equals("mghd02")||gantry.equals("mghx03")){

				logger.info("该流水属于特殊3流水之一，门架、车牌为："+gantry+"、"+plate);

				//该表记录3个特殊门架以及后一个门架
				HashMap<String, String> aMap = new HashMap<String, String>(){{
					put("mghd01","mghd02");
					put("mghd02","mghd03");
					put("mghx03","mghx02");
				}};
				String nextGantry = aMap.get(gantry);

				logger.info("查后一个门架："+nextGantry);

                String timeOrNull = screenDao.getTimeWithPlateAndGantry(plate, nextGantry);

                try {
					Date dateTime = simpleDateFormat.parse(time);
					Date dateTimeOrNull = simpleDateFormat.parse(timeOrNull);

					long l = dateTimeOrNull.getTime()-dateTime.getTime();

							System.out.println("plate="+plate+"l="+l+" dateTime="+dateTime+" timeOrNull="+dateTimeOrNull);
					logger.info("timeornull是："+dateTimeOrNull+plate+"l是："+l);

					//判断时间不能在通过当前门架的时间之前
					if(l>0){
						logger.info("在后门架找到,车还在路网中，不处理");
					}
					else {
						logger.info("理论上不会执行这一句，时间间隔为："+l);
					}

				}catch (Exception e){
					logger.info("没有在后门架找到，时间间隔为：");
					//没找到，即车已出，执行查起点操作,存入数据库
//                    String[] LSData2 ={gantry,plate,time};
//
//                    System.out.println("LSData:"+LSData[0]+LSData[1]+LSData[2]);

					String carOriginalGantry = carODMethor(LSData);

					logger.info("特殊3流水找到起点："+carOriginalGantry);

					add_od_time_plate(carOriginalGantry,gantry,time,plate);
				}


                continue;

//				//异步任务处理：传入： 睡多长时间，睡完查哪个门架,哪个车牌
//				asyncService.executeAsync("3000",nextGantry,LSData[1],LSData[2],LSData[0]);
			}

			logger.info("该流水门架、车牌为："+gantry+plate);

			//每个LSData过一遍算法,返回起点门架
			String carOriginalGantry = carODMethor(LSData);

			//存入od_time_plate 表,调用方法,传入车辆起点门架号、终点门架号、出口时间、车牌，存入数据库，同时，更新OD_table
			add_od_time_plate(carOriginalGantry,gantry,time,plate);

		}
		logger.info("完成一次10分钟数据处理******");

	}

//	@Autowired
//	private AsyncService asyncService;

	//存入od_time_plate 表,调用方法,传入车辆起点门架号、终点门架号、出口时间、车牌，存入数据库
	 void add_od_time_plate(String original, String destination, String time, String plate){
		//将门架号翻译成具体站名
		String reOriginal = screenDao.getEntranceByGantryID(original);
		String reDestination =  screenDao.getExitByGantryID(destination);

		screenDao.add_od_time_plate_table(reOriginal,reDestination,time,plate);

		//同时，更新OD_table
		 updateODTable(reOriginal,reDestination,time);
	 }

	//更新OD_table，传入车辆起点门架号、终点门架号
	void updateODTable(String original, String destination ,String updateTime){
	 	//获取原值
		int carNum = screenDao.getDataFromODTableNew(original, destination);
		carNum++;
		//原值+1，然后更新
		int i = screenDao.updateNewODTable(original, destination, carNum, updateTime);
		if (i==1){
			logger.info("更新OD表成功");
		}
		else {
			logger.info("#########更新OD表失败###########");
		}
	}

	/**
	 * 查车辆起点算法
	 * 传入：所有收费站出口流水实体类、2个主线出口段门架流水实体类、以及广河的东行连凤凰山段、东行连八斗立交、西行连八斗立交段门架流水
	 * 返回：该条流水的起点：入口路段的门架号。返回null时，即这辆车还没出去，还在路段内，这是3条特殊路段门架的返回结果。
	 */
	public  String carODMethor(String[] LSData){


		//准备好容器，装有用的数据
		String regantry = LSData[0];
		String replate= null;
		String retime= null;
		//循环调用查前方门架的方法，直到找不到为止，得到OD起点
		for(String[] reList = checkForntGantry(LSData) ;reList[0] !="m0";reList = checkForntGantry(LSData)){
			regantry = reList[0];
			replate = reList[1];
			retime = reList[2];
			LSData[0] = regantry;
			LSData[1] = replate;
			LSData[2] = retime;
		}
		logger.info("找到起点："+regantry);

		return regantry;

	}


//	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	/*
    查前方门架的方法
    传入：String[]:包含3个字符串：门架号、车牌、时间
    返回：String[]:包含3个字符串：前一个符合时间间隔且含有此车牌的门架号、车牌、时间；若无则返回null，代表找到OD起点了。
     */
	public  String[] checkForntGantry(String[] LSData){

		//建议在每个方法中都new一个新的SimpleDateFormat对象，因为SimpleDateFormat在多线程环境下，是线程不安全的
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

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

				String oldTime = screenDao.getTimeWithPlateAndGantry(plate, (String) forntGantry);
				//上面得到了该车牌是否在前一门架通过，如果没有则报错，抓起处理
				//下面返回该车牌通过前一门架的时间：YYYY-MM-DD hh:mm:ss

				//下面是最近一次通过前面门架与本次通过门架的时间之差，单位：天，即1小时=0.04167天
//				double doubleMargin = DateUtil.getDoubleMargin(time,oldTime);
//				System.out.println("plate "+plate+",time:"+time+", oldtime"+oldTime+", 时间间隔："+dateUtil.getDoubleMargin(time,oldTime));
				//判断有无超过1小时，1小时=0.04167天

				try {
					Date dateTime = simpleDateFormat.parse(time);
					Date dateOldTime = simpleDateFormat.parse(oldTime);
					long l = dateTime.getTime() - dateOldTime.getTime();

					System.out.println("plate="+plate+"l="+l+" dateTime="+dateTime+" dateOldTime="+dateOldTime);

					if(l<=3600000 && l>0 ){
						logger.info("返回前一个门架、车牌、时间："+forntGantry+plate+oldTime);
//					System.out.println("返回前一个门架、车牌、时间："+forntGantry+plate+oldTime);
						return new String[]{(String) forntGantry,plate,oldTime};
					}else {
						System.out.println("plate:"+plate+",判断前后门架时间没通过"+l+"<=3600为："+(l<=3600 && l>0));
						continue a;
					}


				}catch(ParseException e) {
					e.printStackTrace();
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
		logger.info("没有通过前方门架，找到起点"+gantry);
		return new String[]{"m0"};
	}


}
