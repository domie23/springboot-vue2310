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
 * 部门信息
 *
 * @author 
 * @email
 */
@TableName("bumen")
public class BumenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BumenEntity() {

	}

	public BumenEntity(T t) {
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
     * 部门编号
     */
    @ColumnInfo(comment="部门编号",type="varchar(200)")
    @TableField(value = "bumen_uuid_number")

    private String bumenUuidNumber;


    /**
     * 部门名称
     */
    @ColumnInfo(comment="部门名称",type="varchar(200)")
    @TableField(value = "bumen_name")

    private String bumenName;


    /**
     * 部门位置
     */
    @ColumnInfo(comment="部门位置",type="varchar(200)")
    @TableField(value = "bumen_address")

    private String bumenAddress;


    /**
     * 部门备注
     */
    @ColumnInfo(comment="部门备注",type="longtext")
    @TableField(value = "bumen_content")

    private String bumenContent;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：部门编号
	 */
    public String getBumenUuidNumber() {
        return bumenUuidNumber;
    }
    /**
	 * 设置：部门编号
	 */

    public void setBumenUuidNumber(String bumenUuidNumber) {
        this.bumenUuidNumber = bumenUuidNumber;
    }
    /**
	 * 获取：部门名称
	 */
    public String getBumenName() {
        return bumenName;
    }
    /**
	 * 设置：部门名称
	 */

    public void setBumenName(String bumenName) {
        this.bumenName = bumenName;
    }
    /**
	 * 获取：部门位置
	 */
    public String getBumenAddress() {
        return bumenAddress;
    }
    /**
	 * 设置：部门位置
	 */

    public void setBumenAddress(String bumenAddress) {
        this.bumenAddress = bumenAddress;
    }
    /**
	 * 获取：部门备注
	 */
    public String getBumenContent() {
        return bumenContent;
    }
    /**
	 * 设置：部门备注
	 */

    public void setBumenContent(String bumenContent) {
        this.bumenContent = bumenContent;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Bumen{" +
            ", id=" + id +
            ", bumenUuidNumber=" + bumenUuidNumber +
            ", bumenName=" + bumenName +
            ", bumenAddress=" + bumenAddress +
            ", bumenContent=" + bumenContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
