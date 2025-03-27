package com.entity.vo;

import com.entity.BumenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 部门信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("bumen")
public class BumenVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 部门编号
     */

    @TableField(value = "bumen_uuid_number")
    private String bumenUuidNumber;


    /**
     * 部门名称
     */

    @TableField(value = "bumen_name")
    private String bumenName;


    /**
     * 部门位置
     */

    @TableField(value = "bumen_address")
    private String bumenAddress;


    /**
     * 部门备注
     */

    @TableField(value = "bumen_content")
    private String bumenContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：部门编号
	 */
    public String getBumenUuidNumber() {
        return bumenUuidNumber;
    }


    /**
	 * 获取：部门编号
	 */

    public void setBumenUuidNumber(String bumenUuidNumber) {
        this.bumenUuidNumber = bumenUuidNumber;
    }
    /**
	 * 设置：部门名称
	 */
    public String getBumenName() {
        return bumenName;
    }


    /**
	 * 获取：部门名称
	 */

    public void setBumenName(String bumenName) {
        this.bumenName = bumenName;
    }
    /**
	 * 设置：部门位置
	 */
    public String getBumenAddress() {
        return bumenAddress;
    }


    /**
	 * 获取：部门位置
	 */

    public void setBumenAddress(String bumenAddress) {
        this.bumenAddress = bumenAddress;
    }
    /**
	 * 设置：部门备注
	 */
    public String getBumenContent() {
        return bumenContent;
    }


    /**
	 * 获取：部门备注
	 */

    public void setBumenContent(String bumenContent) {
        this.bumenContent = bumenContent;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
