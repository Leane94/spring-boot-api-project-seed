package com.company.project.model;

import com.company.project.util.DataFormatter;

import java.util.Date;
import javax.persistence.*;

@Table(name = "base_info")
public class BaseInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 统一社会信用代码/注册号
     */
    @Column(name = "credit_code")
    private String creditCode = null;

    /**
     * 企业名称
     */
    private String title = null;

    /**
     * 法人代表
     */
    @Column(name = "legal_rep")
    private String legalRep = null;

    /**
     * 企业类型
     */
    private String type = null;

    /**
     * 注册资本
     */
    @Column(name = "reg_cap")
    private String regCap = null;

    /**
     * 状态
     */
    private String status = null;

    /**
     * 失信标签
     */
    @Column(name = "expt_label")
    private String exptLabel = null;

    /**
     * 成立日期
     */
    @Column(name = "est_date")
    private Date estDate;

    /**
     * 经营起始
     */
    @Column(name = "start_date")
    private Date startDate = null;

    /**
     * 经营结束
     */
    @Column(name = "end_date")
    private Date endDate = null;

    /**
     * 登记机关
     */
    @Column(name = "reg_auth")
    private String regAuth = null;

    /**
     * 核准日期
     */
    @Column(name = "pass_date")
    private Date passDate = null;

    /**
     * 住所
     */
    private String address = null;

    /**
     * 清算负责人
     */
    @Column(name = "clear_leader")
    private String clearLeader = null;

    /**
     * 清算成员
     */
    @Column(name = "clear_memebers")
    private String clearMemebers = null;

    /**
     * 经营范围
     */
    @Column(name = "biz_scope")
    private String bizScope = null;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取统一社会信用代码/注册号
     *
     * @return credit_code - 统一社会信用代码/注册号
     */
    public String getCreditCode() {
        return creditCode;
    }

    /**
     * 设置统一社会信用代码/注册号
     *
     * @param creditCode 统一社会信用代码/注册号
     */
    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    /**
     * 获取企业名称
     *
     * @return title - 企业名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置企业名称
     *
     * @param title 企业名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取法人代表
     *
     * @return legal_rep - 法人代表
     */
    public String getLegalRep() {
        return legalRep;
    }

    /**
     * 设置法人代表
     *
     * @param legalRep 法人代表
     */
    public void setLegalRep(String legalRep) {
        this.legalRep = legalRep;
    }

    /**
     * 获取企业类型
     *
     * @return type - 企业类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置企业类型
     *
     * @param type 企业类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取注册资本
     *
     * @return reg_cap - 注册资本
     */
    public String getRegCap() {
        return regCap;
    }

    /**
     * 设置注册资本
     *
     * @param regCap 注册资本
     */
    public void setRegCap(String regCap) {
        this.regCap = regCap;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取失信标签
     *
     * @return expt_label - 失信标签
     */
    public String getExptLabel() {
        return exptLabel;
    }

    /**
     * 设置失信标签
     *
     * @param exptLabel 失信标签
     */
    public void setExptLabel(String exptLabel) {
        this.exptLabel = exptLabel;
    }

    /**
     * 获取成立日期
     *
     * @return est_date - 成立日期
     */
    public Date getEstDate() {
        return estDate;
    }

    /**
     * 设置成立日期
     *
     * @param estDate 成立日期
     */
    public void setEstDate(Date estDate) {
        this.estDate = estDate;
    }

    /**
     * 获取经营起始
     *
     * @return start_date - 经营起始
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置经营起始
     *
     * @param startDate 经营起始
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取经营结束
     *
     * @return end_date - 经营结束
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置经营结束
     *
     * @param endDate 经营结束
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取登记机关
     *
     * @return reg_auth - 登记机关
     */
    public String getRegAuth() {
        return regAuth;
    }

    /**
     * 设置登记机关
     *
     * @param regAuth 登记机关
     */
    public void setRegAuth(String regAuth) {
        this.regAuth = regAuth;
    }

    /**
     * 获取核准日期
     *
     * @return pass_date - 核准日期
     */
    public Date getPassDate() {
        return passDate;
    }

    /**
     * 设置核准日期
     *
     * @param passDate 核准日期
     */
    public void setPassDate(Date passDate) {
        this.passDate = passDate;
    }

    /**
     * 获取住所
     *
     * @return address - 住所
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置住所
     *
     * @param address 住所
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取清算负责人
     *
     * @return clear_leader - 清算负责人
     */
    public String getClearLeader() {
        return clearLeader;
    }

    /**
     * 设置清算负责人
     *
     * @param clearLeader 清算负责人
     */
    public void setClearLeader(String clearLeader) {
        this.clearLeader = clearLeader;
    }

    /**
     * 获取清算成员
     *
     * @return clear_memebers - 清算成员
     */
    public String getClearMemebers() {
        return clearMemebers;
    }

    /**
     * 设置清算成员
     *
     * @param clearMemebers 清算成员
     */
    public void setClearMemebers(String clearMemebers) {
        this.clearMemebers = clearMemebers;
    }

    /**
     * 获取经营范围
     *
     * @return biz_scope - 经营范围
     */
    public String getBizScope() {
        return bizScope;
    }

    /**
     * 设置经营范围
     *
     * @param bizScope 经营范围
     */
    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }
}