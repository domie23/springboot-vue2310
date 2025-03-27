package com.entity.vo;

import com.entity.BangongYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 办公设备
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bangong_yuyue")
public class BangongYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "bangong_yuyue_uuid_number")
    private String bangongYuyueUuidNumber;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 理由
     */

    @TableField(value = "bangong_yuyue_text")
    private String bangongYuyueText;


    /**
     * 请假信息时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 办公用品
     */

    @TableField(value = "bangong_yuyue_types")
    private Integer bangongYuyueTypes;


    /**
     * 报名状态
     */

    @TableField(value = "bangong_yuyue_yesno_types")
    private Integer bangongYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "bangong_yuyue_yesno_text")
    private String bangongYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "bangong_yuyue_shenhe_time")
    private Date bangongYuyueShenheTime;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "bangong_yuyue_time")
    private Date bangongYuyueTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：报名编号
	 */
    public String getBangongYuyueUuidNumber() {
        return bangongYuyueUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setBangongYuyueUuidNumber(String bangongYuyueUuidNumber) {
        this.bangongYuyueUuidNumber = bangongYuyueUuidNumber;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：理由
	 */
    public String getBangongYuyueText() {
        return bangongYuyueText;
    }


    /**
	 * 获取：理由
	 */

    public void setBangongYuyueText(String bangongYuyueText) {
        this.bangongYuyueText = bangongYuyueText;
    }
    /**
	 * 设置：请假信息时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：请假信息时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：办公用品
	 */
    public Integer getBangongYuyueTypes() {
        return bangongYuyueTypes;
    }


    /**
	 * 获取：办公用品
	 */

    public void setBangongYuyueTypes(Integer bangongYuyueTypes) {
        this.bangongYuyueTypes = bangongYuyueTypes;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getBangongYuyueYesnoTypes() {
        return bangongYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setBangongYuyueYesnoTypes(Integer bangongYuyueYesnoTypes) {
        this.bangongYuyueYesnoTypes = bangongYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getBangongYuyueYesnoText() {
        return bangongYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setBangongYuyueYesnoText(String bangongYuyueYesnoText) {
        this.bangongYuyueYesnoText = bangongYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getBangongYuyueShenheTime() {
        return bangongYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setBangongYuyueShenheTime(Date bangongYuyueShenheTime) {
        this.bangongYuyueShenheTime = bangongYuyueShenheTime;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getBangongYuyueTime() {
        return bangongYuyueTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setBangongYuyueTime(Date bangongYuyueTime) {
        this.bangongYuyueTime = bangongYuyueTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
