package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 办公设备
 *
 * @author 
 * @email
 */
@TableName("bangong_yuyue")
public class BangongYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BangongYuyueEntity() {

	}

	public BangongYuyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 报名编号
     */
    @ColumnInfo(comment="报名编号",type="varchar(200)")
    @TableField(value = "bangong_yuyue_uuid_number")

    private String bangongYuyueUuidNumber;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 理由
     */
    @ColumnInfo(comment="理由",type="longtext")
    @TableField(value = "bangong_yuyue_text")

    private String bangongYuyueText;


    /**
     * 请假信息时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="请假信息时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 办公用品
     */
    @ColumnInfo(comment="办公用品",type="int(11)")
    @TableField(value = "bangong_yuyue_types")

    private Integer bangongYuyueTypes;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "bangong_yuyue_yesno_types")

    private Integer bangongYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "bangong_yuyue_yesno_text")

    private String bangongYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "bangong_yuyue_shenhe_time")

    private Date bangongYuyueShenheTime;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="timestamp")
    @TableField(value = "bangong_yuyue_time")

    private Date bangongYuyueTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BangongYuyue{" +
            ", id=" + id +
            ", bangongYuyueUuidNumber=" + bangongYuyueUuidNumber +
            ", yonghuId=" + yonghuId +
            ", bangongYuyueText=" + bangongYuyueText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", bangongYuyueTypes=" + bangongYuyueTypes +
            ", bangongYuyueYesnoTypes=" + bangongYuyueYesnoTypes +
            ", bangongYuyueYesnoText=" + bangongYuyueYesnoText +
            ", bangongYuyueShenheTime=" + DateUtil.convertString(bangongYuyueShenheTime,"yyyy-MM-dd") +
            ", bangongYuyueTime=" + DateUtil.convertString(bangongYuyueTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
