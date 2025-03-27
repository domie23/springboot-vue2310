package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WangfanYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 外出报备
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("wangfan_yuyue")
public class WangfanYuyueView extends WangfanYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 交通工具的值
	*/
	@ColumnInfo(comment="交通工具的字典表值",type="varchar(200)")
	private String wangfanYuyueValue;
	/**
	* 身体状态的值
	*/
	@ColumnInfo(comment="身体状态的字典表值",type="varchar(200)")
	private String wangfanYuyueShentiValue;
	/**
	* 申报状态的值
	*/
	@ColumnInfo(comment="申报状态的字典表值",type="varchar(200)")
	private String wangfanYuyueYesnoValue;

	//级联表 用户
							/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;



	public WangfanYuyueView() {

	}

	public WangfanYuyueView(WangfanYuyueEntity wangfanYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, wangfanYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 交通工具的值
	*/
	public String getWangfanYuyueValue() {
		return wangfanYuyueValue;
	}
	/**
	* 设置： 交通工具的值
	*/
	public void setWangfanYuyueValue(String wangfanYuyueValue) {
		this.wangfanYuyueValue = wangfanYuyueValue;
	}
	//当前表的
	/**
	* 获取： 身体状态的值
	*/
	public String getWangfanYuyueShentiValue() {
		return wangfanYuyueShentiValue;
	}
	/**
	* 设置： 身体状态的值
	*/
	public void setWangfanYuyueShentiValue(String wangfanYuyueShentiValue) {
		this.wangfanYuyueShentiValue = wangfanYuyueShentiValue;
	}
	//当前表的
	/**
	* 获取： 申报状态的值
	*/
	public String getWangfanYuyueYesnoValue() {
		return wangfanYuyueYesnoValue;
	}
	/**
	* 设置： 申报状态的值
	*/
	public void setWangfanYuyueYesnoValue(String wangfanYuyueYesnoValue) {
		this.wangfanYuyueYesnoValue = wangfanYuyueYesnoValue;
	}


	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "WangfanYuyueView{" +
			", wangfanYuyueValue=" + wangfanYuyueValue +
			", wangfanYuyueShentiValue=" + wangfanYuyueShentiValue +
			", wangfanYuyueYesnoValue=" + wangfanYuyueYesnoValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
