package com.company.project.controller;
import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.core.ResultGenerator;
import com.company.project.model.BaseInfo;
import com.company.project.service.BaseInfoService;
import com.company.project.util.DataValidator;
import com.company.project.util.QichaSession;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/***
 * Controller related to all actions on baseInfo object
 * @author Chao Li
 */
@RestController
@RequestMapping("/base_info")
public class BaseInfoController {
    @Resource
    private BaseInfoService baseInfoService;

    @Value("${qichacha.address}")
    private String qichaUrl;

    @PostMapping("/add")
    public Result add(BaseInfo baseInfo) {
        baseInfoService.save(baseInfo);
        return ResultGenerator.genSuccessResult();
    }

    /***
     * 根据id或credit code删除企业数据
     * @param id 本地数据库内id
     * @param credit_code 统一社会信用代码
     * @return 是否成功删除
     */
    @GetMapping("/delete")
    public Result delete(@RequestParam(required = false, defaultValue = "0") Integer id,
                         @RequestParam(required = false, defaultValue = "0") String credit_code) {
        if (id != 0){
            baseInfoService.deleteById(id);
            return ResultGenerator.genSuccessResult("Successfully delete record with id=" + id.toString());
        }
        else if (!credit_code.equals("0")){
            baseInfoService.deleteByCreditCode(credit_code);
            return ResultGenerator.genSuccessResult("Successfully delete record with credit_code="+credit_code);
        }
        return ResultGenerator.genErrorResult(ResultCode.PARAMERROR,"Please provide id or credit code.");
    }

    @PostMapping("/update")
    public Result update(BaseInfo baseInfo) {
        baseInfoService.update(baseInfo);
        return ResultGenerator.genSuccessResult();
    }

    /***
     * 使用id或社会信用代码查询企业详情
     * @param id 本地数据库内id
     * @param credit_code 统一社会信用代码
     * @return 查询结果
     */
    @GetMapping("/detail")
    public Result detail(@RequestParam(required = false, defaultValue = "0") Integer id,
                         @RequestParam(required = false, defaultValue = "0") String credit_code) {
        BaseInfo baseInfo = null;
        // 本地数据库查询
        if (id != 0){
            baseInfo = baseInfoService.findById(id);
            if (baseInfo != null) return ResultGenerator.genSuccessResult(baseInfo);
        }
        else if (!credit_code.equals("0")){
            baseInfo = baseInfoService.findBy("creditCode", credit_code);
            if (baseInfo != null) return ResultGenerator.genSuccessResult(baseInfo);
        }
        // 本地无结果则使用企查查api
        if (baseInfo == null && !credit_code.equals("0")) {
//            "http://api.qichacha.com/ECIV4/GetBasicDetailsByName?key=AppKey&keyword=credit_code";
            JSONObject jsonObj = new JSONObject(QichaSession.search(credit_code));
            if (DataValidator.isSuccessResponse(jsonObj)){
                baseInfo = baseInfoService.jsonToBaseInfo(jsonObj);
                if (baseInfoService.findBy("creditCode",credit_code)==null){
                    baseInfoService.save(baseInfo);
                }
                else {
                    baseInfo.setId(baseInfoService.findBy("creditCode",credit_code).getId());
                    baseInfoService.update(baseInfo);
                }
                return ResultGenerator.genSuccessResult(baseInfo);
            }
            else{
                return ResultGenerator.genErrorResult(ResultCode.QICHACHAFAIL,
                        QichaSession.responseStatusMap.get(jsonObj.getString("Status")));
            }
        }
        return ResultGenerator.genErrorResult(ResultCode.PARAMERROR,"Please provide id or credit code");
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<BaseInfo> list = baseInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
