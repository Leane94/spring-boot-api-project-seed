package com.company.project.service;
import com.company.project.model.BaseInfo;
import com.company.project.core.Service;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.json.JSONObject;

/***
 * Provide service for BaseInfoController
 * @author Chao Li
 */
public interface BaseInfoService extends Service<BaseInfo> {
    /***
     * 根据统一社会信用代码删除企业信息
     * @param credit_code 统一社会信用代码
     */
    void deleteByCreditCode(String credit_code);

    /***
     * 将jsonObject转换为baseInfo object
     * @param jsonObj json object
     * @return baseInfo object
     */
    BaseInfo jsonToBaseInfo(JSONObject jsonObj);
}
