package com.entity.model;

import com.entity.BangongYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 办公设备
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BangongYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String bangongYuyueUuidNumber;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 理由
     */
    private String bangongYuyueText;


    /**
     * 请假信息时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 办公用品
     */
    private Integer bangongYuyueTypes;


    /**
     * 报名状态
     */
    private Integer bangongYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String bangongYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date bangongYuyueShenheTime;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date bangongYuyueTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：报名编号
	 */
    public String getBangongYuyueUuidNumber() {
        return bangongYuyueUuidNumber;
    }


    /**
	 * 设置：报名编号
	 */
    public void setBangongYuyueUuidNumber(String bangongYuyueUuidNumber) {
        this.bangongYuyueUuidNumber = bangongYuyueUuidNumber;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：理由
	 */
    public String getBangongYuyueText() {
        return bangongYuyueText;
    }


    /**
	 * 设置：理由
	 */
    public void setBangongYuyueText(String bangongYuyueText) {
        this.bangongYuyueText = bangongYuyueText;
    }
    /**
	 * 获取：请假信息时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：请假信息时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：办公用品
	 */
    public Integer getBangongYuyueTypes() {
        return bangongYuyueTypes;
    }


    /**
	 * 设置：办公用品
	 */
    public void setBangongYuyueTypes(Integer bangongYuyueTypes) {
        this.bangongYuyueTypes = bangongYuyueTypes;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getBangongYuyueYesnoTypes() {
        return bangongYuyueYesnoTypes;
    }


    /**
	 * 设置：报名状态
	 */
    public void setBangongYuyueYesnoTypes(Integer bangongYuyueYesnoTypes) {
        this.bangongYuyueYesnoTypes = bangongYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getBangongYuyueYesnoText() {
        return bangongYuyueYesnoText;
    }


    /**
	 * 设置：审核回复
	 */
    public void setBangongYuyueYesnoText(String bangongYuyueYesnoText) {
        this.bangongYuyueYesnoText = bangongYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getBangongYuyueShenheTime() {
        return bangongYuyueShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setBangongYuyueShenheTime(Date bangongYuyueShenheTime) {
        this.bangongYuyueShenheTime = bangongYuyueShenheTime;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getBangongYuyueTime() {
        return bangongYuyueTime;
    }


    /**
	 * 设置：预约时间
	 */
    public void setBangongYuyueTime(Date bangongYuyueTime) {
        this.bangongYuyueTime = bangongYuyueTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
