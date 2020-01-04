package com.eagle.cloud.route.idgenerator;

import com.eagle.cloud.route.dao.SysScreenDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author:FWJ
 * @Date:2019-12-10
 * @Description:IntelliJ IDEA
 * @version:1.0
 */
//@RunWith(SpringRunner.class)
@SpringBootTest
public class odTest {

    @Autowired
    private SysScreenDao sysScreenDao;

    @Test
    public void test1() {

        String[] str = {
                "春岗立交",
                "广佛肇凤凰山",
                "八斗立交",
                "八斗站",
                "福山站",
                "知识城站",
                "中新站",
                "二龙站",
                "腊圃站",
                "正果站",
                "广河惠州段",
                "增莞高速",
                "荔城站",
                "朱村东站",
                "新和站",
                "杨荷立交",
                "从莞深惠州段",
                "增城站",
                "正果南站",
                "小楼站",
                "派潭站",
                "灌村站",
                "桃园站",
                "卫东立交",
                "双凤站",
                "街口连接处",
        };
        System.out.println(str[0]);
        System.out.println(str.length);

        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str.length; i++) {
//                int i1 = sysScreenDao.insertToODTable(str[i], str[j], "0", "0");
            }
        }


    }
}
