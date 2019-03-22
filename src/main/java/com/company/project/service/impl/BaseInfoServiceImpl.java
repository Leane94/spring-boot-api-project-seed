package com.company.project.service.impl;

import com.company.project.dao.BaseInfoMapper;
import com.company.project.model.BaseInfo;
import com.company.project.service.BaseInfoService;
import com.company.project.core.AbstractService;
import com.company.project.util.DataFormatter;
import com.company.project.util.DataValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import org.json.JSONObject;


/***
 * Implementation of BaseInfoService
 * @author Chao Li
 */
@Service
@Transactional
public class BaseInfoServiceImpl extends AbstractService<BaseInfo> implements BaseInfoService {
    // baseInfo model mapper
    @Resource
    private BaseInfoMapper baseInfoMapper;

    @Override
    public void deleteByCreditCode(String credit_code){
        baseInfoMapper.deleteByCreditCode(credit_code);
    }

    @Override
    public BaseInfo jsonToBaseInfo(JSONObject jsonObj){
        BaseInfo baseInfo = new BaseInfo();
        JSONObject resultObj = jsonObj.getJSONObject("Result");
        if (DataValidator.isValidKey(resultObj, "CreditCode")){
            baseInfo.setCreditCode(resultObj.getString("CreditCode"));
        }
        else {
            baseInfo.setCreditCode(resultObj.getString("No"));
        }
        baseInfo.setTitle(resultObj.getString("Name"));
        baseInfo.setLegalRep(resultObj.getString("OperName"));
        baseInfo.setType(resultObj.getString("EconKind"));
        baseInfo.setRegCap(resultObj.getString("RegistCapi"));
        baseInfo.setStatus(resultObj.getString("Status"));
        if (DataValidator.isValidKey(resultObj, "StartDate")){
            baseInfo.setEstDate(DataFormatter.strToDate(resultObj.getString("StartDate").split("T")[0]));
        }
        if (DataValidator.isValidKey(resultObj, "TermStart")) {
            baseInfo.setStartDate(DataFormatter.strToDate(resultObj.getString("TermStart").split("T")[0]));
        }
        if (DataValidator.isValidKey(resultObj, "TeamEnd")) {
            baseInfo.setEndDate(DataFormatter.strToDate(resultObj.getString("TeamEnd").split("T")[0]));
        }
        baseInfo.setRegAuth(resultObj.getString("BelongOrg"));
        if (DataValidator.isValidKey(resultObj, "CheckDate")){
            baseInfo.setPassDate(DataFormatter.strToDate(resultObj.getString("CheckDate").split("T")[0]));
        }
        baseInfo.setAddress(resultObj.getString("Address"));
        baseInfo.setBizScope(resultObj.getString("Scope"));
        return baseInfo;
    }

}
