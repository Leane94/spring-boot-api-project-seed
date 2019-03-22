package com.conpany.project.util;

import com.company.project.util.QichaSession;
import com.conpany.project.Tester;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;

public class QichaSessionTester extends Tester{

    @Test
    public void loadStatusCodeTest(){
        HashMap<String, String> map = QichaSession.responseStatusMap;
        assertEquals("查询成功", map.get("200"));
        assertEquals("系统未知错误，请联系技术客服", map.get("199"));
    }
}
