package com.conpany.project.service;

import com.company.project.model.BaseInfo;
import com.company.project.service.BaseInfoService;
import com.company.project.util.DataFormatter;
import com.conpany.project.Tester;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class BaseInfoServiceTester extends Tester {
    @Autowired
    private BaseInfoService baseInfoService;

    /***
     * Complete info
     */
    @Test
    public void jsonToBaseInfoTest_1() throws JSONException{
        String jsonStr = "{\n" +
                "  \"Status\": \"200\",\n" +
                "  \"Message\": \"查询成功\",\n" +
                "  \"OrderNumber\": \"ECI2017122517540689191217\",\n" +
                "  \"Result\": {\n" +
                "    \"KeyNo\": \"4659626b1e5e43f1bcad8c268753216e\",\n" +
                "    \"Name\": \"北京小桔科技有限公司\",\n" +
                "    \"No\": \"110108015068911\",\n" +
                "    \"BelongOrg\": \"海淀分局\",\n" +
                "    \"OperName\": \"程维\",\n" +
                "    \"StartDate\": \"2012-07-10T00:00:00+08:00\",\n" +
                "    \"EndDate\": null,\n" +
                "    \"Status\": \"存续（在营、开业、在册）\",\n" +
                "    \"Province\": \"BJ\",\n" +
                "    \"UpdatedDate\": \"2017-12-23T13:25:39.338+08:00\",\n" +
                "    \"CreditCode\": \"9111010859963405XW\",\n" +
                "    \"RegistCapi\": \"1000万元人民币\",\n" +
                "    \"EconKind\": \"有限责任公司(自然人投资或控股)\",\n" +
                "    \"Address\": \"北京市海淀区东北旺西路8号院35号楼5层501室\",\n" +
                "    \"Scope\": \"技术开发、技术咨询、技术服务、技术推广；基础软件服务；应用软件服务；设计、制作、代理、发布广告；软件开发；销售自行开发后的产品；企业管理咨询；计算机系统服务；组织文化艺术交流活动（不含营业性演出）；公共关系服务；企业策划、设计；会议服务；市场调查；货物进出口、技术进出口、代理进出口；从事互联网文化活动；互联网信息服务；经营电信业务。（企业依法自主选择经营项目，开展经营活动；从事互联网文化活动、互联网信息服务、经营电信业务以及依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动；不得从事本市产业政策禁止和限制类项目的经营活动。）\",\n" +
                "    \"TermStart\": \"2012-07-10T00:00:00+08:00\",\n" +
                "    \"TeamEnd\": \"2032-07-09T00:00:00+08:00\",\n" +
                "    \"CheckDate\": \"2017-12-11T00:00:00+08:00\",\n" +
                "    \"OrgNo\": \"59963405-X\",\n" +
                "    \"IsOnStock\": \"0\",\n" +
                "    \"StockNumber\": null,\n" +
                "    \"StockType\": null,\n" +
                "    \"OriginalName\": null\n" +
                "  }\n" +
                "}";
        JSONObject jsonObj = new JSONObject(jsonStr);
        BaseInfo baseInfo = baseInfoService.jsonToBaseInfo(jsonObj);
        assertEquals("9111010859963405XW", baseInfo.getCreditCode());
        assertEquals("北京小桔科技有限公司", baseInfo.getTitle());
        assertEquals ("程维",baseInfo.getLegalRep());
        assertEquals("有限责任公司(自然人投资或控股)",baseInfo.getType());
        assertEquals("1000万元人民币",baseInfo.getRegCap());
        assertEquals("存续（在营、开业、在册）",baseInfo.getStatus());
        assertEquals(DataFormatter.strToDate("2012-07-10"),baseInfo.getEstDate());
        assertEquals(DataFormatter.strToDate("2012-07-10"),baseInfo.getStartDate());
        assertEquals(DataFormatter.strToDate("2032-07-09"),baseInfo.getEndDate());
        assertEquals("海淀分局",baseInfo.getRegAuth());
        assertEquals(DataFormatter.strToDate("2017-12-11"),baseInfo.getPassDate());
        assertEquals("技术开发、技术咨询、技术服务、技术推广；基础软件服务；应用软件服务；设计、制作、代理、发布广告；软件开发；销售自行开发后的产品；企业管理咨询；计算机系统服务；组织文化艺术交流活动（不含营业性演出）；公共关系服务；企业策划、设计；会议服务；市场调查；货物进出口、技术进出口、代理进出口；从事互联网文化活动；互联网信息服务；经营电信业务。（企业依法自主选择经营项目，开展经营活动；从事互联网文化活动、互联网信息服务、经营电信业务以及依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动；不得从事本市产业政策禁止和限制类项目的经营活动。）",baseInfo.getBizScope());
    }

    /***
     * credit code is ""
     */
    @Test
    public void jsonToBaseInfoTest_2() throws JSONException{
        String jsonStr = "{\n" +
                "  \"Status\": \"200\",\n" +
                "  \"Message\": \"查询成功\",\n" +
                "  \"OrderNumber\": \"ECI2017122517540689191217\",\n" +
                "  \"Result\": {\n" +
                "    \"KeyNo\": \"4659626b1e5e43f1bcad8c268753216e\",\n" +
                "    \"Name\": \"北京小桔科技有限公司\",\n" +
                "    \"No\": \"110108015068911\",\n" +
                "    \"BelongOrg\": \"海淀分局\",\n" +
                "    \"OperName\": \"程维\",\n" +
                "    \"StartDate\": \"2012-07-10T00:00:00+08:00\",\n" +
                "    \"EndDate\": null,\n" +
                "    \"Status\": \"存续（在营、开业、在册）\",\n" +
                "    \"Province\": \"BJ\",\n" +
                "    \"UpdatedDate\": \"2017-12-23T13:25:39.338+08:00\",\n" +
                "    \"CreditCode\": \"\",\n" +
                "    \"RegistCapi\": \"1000万元人民币\",\n" +
                "    \"EconKind\": \"有限责任公司(自然人投资或控股)\",\n" +
                "    \"Address\": \"北京市海淀区东北旺西路8号院35号楼5层501室\",\n" +
                "    \"Scope\": \"技术开发、技术咨询、技术服务、技术推广；基础软件服务；应用软件服务；设计、制作、代理、发布广告；软件开发；销售自行开发后的产品；企业管理咨询；计算机系统服务；组织文化艺术交流活动（不含营业性演出）；公共关系服务；企业策划、设计；会议服务；市场调查；货物进出口、技术进出口、代理进出口；从事互联网文化活动；互联网信息服务；经营电信业务。（企业依法自主选择经营项目，开展经营活动；从事互联网文化活动、互联网信息服务、经营电信业务以及依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动；不得从事本市产业政策禁止和限制类项目的经营活动。）\",\n" +
                "    \"TermStart\": \"2012-07-10T00:00:00+08:00\",\n" +
                "    \"TeamEnd\": \"2032-07-09T00:00:00+08:00\",\n" +
                "    \"CheckDate\": \"2017-12-11T00:00:00+08:00\",\n" +
                "    \"OrgNo\": \"59963405-X\",\n" +
                "    \"IsOnStock\": \"0\",\n" +
                "    \"StockNumber\": null,\n" +
                "    \"StockType\": null,\n" +
                "    \"OriginalName\": null\n" +
                "  }\n" +
                "}";
        JSONObject jsonObj = new JSONObject(jsonStr);
        BaseInfo baseInfo = baseInfoService.jsonToBaseInfo(jsonObj);
        assertEquals("110108015068911", baseInfo.getCreditCode());
    }

    /***
     * credit code is null
     */
    @Test
    public void jsonToBaseInfoTest_3() throws JSONException{
        String jsonStr = "{\n" +
                "  \"Status\": \"200\",\n" +
                "  \"Message\": \"查询成功\",\n" +
                "  \"OrderNumber\": \"ECI2017122517540689191217\",\n" +
                "  \"Result\": {\n" +
                "    \"KeyNo\": \"4659626b1e5e43f1bcad8c268753216e\",\n" +
                "    \"Name\": \"北京小桔科技有限公司\",\n" +
                "    \"No\": \"110108015068911\",\n" +
                "    \"BelongOrg\": \"海淀分局\",\n" +
                "    \"OperName\": \"程维\",\n" +
                "    \"StartDate\": \"2012-07-10T00:00:00+08:00\",\n" +
                "    \"EndDate\": null,\n" +
                "    \"Status\": \"存续（在营、开业、在册）\",\n" +
                "    \"Province\": \"BJ\",\n" +
                "    \"UpdatedDate\": \"2017-12-23T13:25:39.338+08:00\",\n" +
                "    \"CreditCode\": null,\n" +
                "    \"RegistCapi\": \"1000万元人民币\",\n" +
                "    \"EconKind\": \"有限责任公司(自然人投资或控股)\",\n" +
                "    \"Address\": \"北京市海淀区东北旺西路8号院35号楼5层501室\",\n" +
                "    \"Scope\": \"技术开发、技术咨询、技术服务、技术推广；基础软件服务；应用软件服务；设计、制作、代理、发布广告；软件开发；销售自行开发后的产品；企业管理咨询；计算机系统服务；组织文化艺术交流活动（不含营业性演出）；公共关系服务；企业策划、设计；会议服务；市场调查；货物进出口、技术进出口、代理进出口；从事互联网文化活动；互联网信息服务；经营电信业务。（企业依法自主选择经营项目，开展经营活动；从事互联网文化活动、互联网信息服务、经营电信业务以及依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动；不得从事本市产业政策禁止和限制类项目的经营活动。）\",\n" +
                "    \"TermStart\": \"2012-07-10T00:00:00+08:00\",\n" +
                "    \"TeamEnd\": \"2032-07-09T00:00:00+08:00\",\n" +
                "    \"CheckDate\": \"2017-12-11T00:00:00+08:00\",\n" +
                "    \"OrgNo\": \"59963405-X\",\n" +
                "    \"IsOnStock\": \"0\",\n" +
                "    \"StockNumber\": null,\n" +
                "    \"StockType\": null,\n" +
                "    \"OriginalName\": null\n" +
                "  }\n" +
                "}";
        JSONObject jsonObj = new JSONObject(jsonStr);
        BaseInfo baseInfo = baseInfoService.jsonToBaseInfo(jsonObj);
        assertEquals("110108015068911", baseInfo.getCreditCode());
    }

    /***
     * credit code is null
     */
    @Test
    public void jsonToBaseInfoTest_4() throws JSONException{
        String jsonStr = "{\n" +
                "  \"Status\": \"200\",\n" +
                "  \"Message\": \"查询成功\",\n" +
                "  \"OrderNumber\": \"ECI2017122517540689191217\",\n" +
                "  \"Result\": {\n" +
                "    \"KeyNo\": \"4659626b1e5e43f1bcad8c268753216e\",\n" +
                "    \"Name\": \"北京小桔科技有限公司\",\n" +
                "    \"No\": \"110108015068911\",\n" +
                "    \"BelongOrg\": \"海淀分局\",\n" +
                "    \"OperName\": \"程维\",\n" +
                "    \"StartDate\": \"2012-07-10T00:00:00+08:00\",\n" +
                "    \"EndDate\": null,\n" +
                "    \"Status\": \"存续（在营、开业、在册）\",\n" +
                "    \"Province\": \"BJ\",\n" +
                "    \"UpdatedDate\": \"2017-12-23T13:25:39.338+08:00\",\n" +
                "    \"CreditCode\": null,\n" +
                "    \"RegistCapi\": \"1000万元人民币\",\n" +
                "    \"EconKind\": \"有限责任公司(自然人投资或控股)\",\n" +
                "    \"Address\": \"北京市海淀区东北旺西路8号院35号楼5层501室\",\n" +
                "    \"Scope\": \"技术开发、技术咨询、技术服务、技术推广；基础软件服务；应用软件服务；设计、制作、代理、发布广告；软件开发；销售自行开发后的产品；企业管理咨询；计算机系统服务；组织文化艺术交流活动（不含营业性演出）；公共关系服务；企业策划、设计；会议服务；市场调查；货物进出口、技术进出口、代理进出口；从事互联网文化活动；互联网信息服务；经营电信业务。（企业依法自主选择经营项目，开展经营活动；从事互联网文化活动、互联网信息服务、经营电信业务以及依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动；不得从事本市产业政策禁止和限制类项目的经营活动。）\",\n" +
                "    \"TermStart\": \"2012-07-10T00:00:00+08:00\",\n" +
                "    \"TeamEnd\": null,\n" +
                "    \"CheckDate\": \"2017-12-11T00:00:00+08:00\",\n" +
                "    \"OrgNo\": \"59963405-X\",\n" +
                "    \"IsOnStock\": \"0\",\n" +
                "    \"StockNumber\": null,\n" +
                "    \"StockType\": null,\n" +
                "    \"OriginalName\": null\n" +
                "  }\n" +
                "}";
        JSONObject jsonObj = new JSONObject(jsonStr);
        BaseInfo baseInfo = baseInfoService.jsonToBaseInfo(jsonObj);
        assertEquals(null, baseInfo.getEndDate());
    }

    /***
     * Convert jsonstr to baseInfo, save to database and load inserted data from database
     * @throws JSONException
     */
    @Test
    public void saveFindTest()throws JSONException{
        String jsonStr = "{\n" +
                "  \"Status\": \"200\",\n" +
                "  \"Message\": \"查询成功\",\n" +
                "  \"OrderNumber\": \"ECI2017122517540689191217\",\n" +
                "  \"Result\": {\n" +
                "    \"KeyNo\": \"4659626b1e5e43f1bcad8c268753216e\",\n" +
                "    \"Name\": \"北京小桔科技有限公司\",\n" +
                "    \"No\": \"110108015068911\",\n" +
                "    \"BelongOrg\": \"海淀分局\",\n" +
                "    \"OperName\": \"程维\",\n" +
                "    \"StartDate\": \"2012-07-10T00:00:00+08:00\",\n" +
                "    \"EndDate\": null,\n" +
                "    \"Status\": \"存续（在营、开业、在册）\",\n" +
                "    \"Province\": \"BJ\",\n" +
                "    \"UpdatedDate\": \"2017-12-23T13:25:39.338+08:00\",\n" +
                "    \"CreditCode\": \"9111010859963405XW\",\n" +
                "    \"RegistCapi\": \"1000万元人民币\",\n" +
                "    \"EconKind\": \"有限责任公司(自然人投资或控股)\",\n" +
                "    \"Address\": \"北京市海淀区东北旺西路8号院35号楼5层501室\",\n" +
                "    \"Scope\": \"技术开发、技术咨询、技术服务、技术推广；基础软件服务；应用软件服务；设计、制作、代理、发布广告；软件开发；销售自行开发后的产品；企业管理咨询；计算机系统服务；组织文化艺术交流活动（不含营业性演出）；公共关系服务；企业策划、设计；会议服务；市场调查；货物进出口、技术进出口、代理进出口；从事互联网文化活动；互联网信息服务；经营电信业务。（企业依法自主选择经营项目，开展经营活动；从事互联网文化活动、互联网信息服务、经营电信业务以及依法须经批准的项目，经相关部门批准后依批准的内容开展经营活动；不得从事本市产业政策禁止和限制类项目的经营活动。）\",\n" +
                "    \"TermStart\": \"2012-07-10T00:00:00+08:00\",\n" +
                "    \"TeamEnd\": \"2032-07-09T00:00:00+08:00\",\n" +
                "    \"CheckDate\": \"2017-12-11T00:00:00+08:00\",\n" +
                "    \"OrgNo\": \"59963405-X\",\n" +
                "    \"IsOnStock\": \"0\",\n" +
                "    \"StockNumber\": null,\n" +
                "    \"StockType\": null,\n" +
                "    \"OriginalName\": null\n" +
                "  }\n" +
                "}";
        JSONObject jsonObj = new JSONObject(jsonStr);
        BaseInfo baseInfo = baseInfoService.jsonToBaseInfo(jsonObj);
        if (baseInfoService.findBy("creditCode",baseInfo.getCreditCode())==null){
            baseInfoService.save(baseInfo);
        }
        else {
            baseInfo.setId(baseInfoService.findBy("creditCode",baseInfo.getCreditCode()).getId());
            baseInfoService.update(baseInfo);
        }
        BaseInfo baseInfoRead = baseInfoService.findById(baseInfo.getId());
        assertEquals(baseInfo.getId(), baseInfoRead.getId());
        assertEquals(baseInfo.getCreditCode(), baseInfoRead.getCreditCode());
    }
}
