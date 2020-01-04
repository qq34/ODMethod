package com.eagle.cloud.route.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.eagle.cloud.route.model.LSmodel;
import com.eagle.cloud.route.dto.resultModelDto;
import com.eagle.cloud.route.model.ODTableModel;
import org.apache.ibatis.annotations.Mapper;

import com.eagle.cloud.route.dto.requestDto;
import com.eagle.cloud.route.model.SysScreen;
import com.eagle.cloud.route.vo.Section;
import com.eagle.cloud.route.vo.StepsRecord;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysScreenDao {

	List<SysScreen> getScreenList(Map<String, Object> params);

	void deleteScreen(Long id);

	void addScreen(SysScreen sysScreen);

	List<Section> getTbl_sectionInfo();

	/**
	 * 更新tbl_section
	 * @param tbl_section
	 * @return
	 */
	int updateSectionBysectionId(Section section);

	/**
	 * 插入记录表
	 * @param tbl_steps_record
	 * @return
	 */
	int addRecordInfo(StepsRecord stepsrecord);

	/**
	 * 获取时间和距离总数
	 * @return
	 */
	List<requestDto> getScrtionCountBypathId();

	/**
	 * 更新tbl_path
	 * @param dto
	 * @return
	 */
	int updatePathDurationAndDistance(requestDto dto);
	/**
	 * 得到最大的 sort 值
	 * @return
	 */
	BigDecimal getSortMax();

	/**
	 * 通过最大的 sort 值  查询所有路况信息
	 * @param bigDecimal
	 * @return
	 */
	List<StepsRecord> getRoadAll(BigDecimal bigDecimal);

	/**
	 * 统计一次路段的数量
	 * @param bigDecimal
	 * @return
	 */
	int getSortMaxCount(BigDecimal bigDecimal);

	/*
	 * 得到第二大的 sort 值
	 */
	BigDecimal getSortSecondMax();

	/*
	读取54个区间的实时车辆数
	 */
	List<resultModelDto> getAllGantryNumber();

	/*
	获得某一个区间的实时车辆数
 	*/
	int getCarNumberByGantryName(String gantryID);

	/*
	更新某区间的实时车辆数
	 */
	int updateGantryCarNumber(String gantryID,int carnumber);

	/*
	OD算法
	 */
	//测试

	//从data表中获取近11分钟到1分钟这10分钟的28个门架ID的流水
	List<LSmodel> getODLSFromData(String oneMinuteBeforeTime, String eleventMinuteBeforeTime);

	//查此车牌在此门架通过的时刻（在异步任务中使用）
	String getTimeWithPlateAndGantry(String plate,String gantryID);

	//存入od_time_plate表，传入车辆起点门架号、终点门架号、出口时间、车牌，存入数据库
	int add_od_time_plate_table(String original,String destination,String time,String plate);

	//查入口翻译表，将门架ID翻译为入口名称
	String getEntranceByGantryID(String gantryID);

	//查出口翻译表，将门架ID翻译为出口名称
	String getExitByGantryID(String gantryID);

	//从数据库拿OD表,全部676条OD
	List<Map> getODFromTable();

	//获取od_table表的某行某列数据
	int getDataFromODTable(String original, String destination);

	//更新od_table表的某行某列数据
	int updateODTableWithData(String original, String destination,int caeNum);


	//获取od_table_new表的某行某列数据
	int getDataFromODTableNew(String original, String destination);
	//更新od_table_new表的某行数据
	int updateNewODTable(String Original ,String destination,int number,String time);


//	//测试，临时
//	int insertToNewTable(String Original ,String destination,String number,String time);

	//获得画线数据
	Map<String,String> getODPolyline(String original,String destination);

	//随机展示10条流水信息
	List<Map> showLSData();

}
