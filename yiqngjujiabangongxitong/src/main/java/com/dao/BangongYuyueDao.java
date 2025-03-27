package com.dao;

import com.entity.BangongYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BangongYuyueView;

/**
 * 办公设备 Dao 接口
 *
 * @author 
 */
public interface BangongYuyueDao extends BaseMapper<BangongYuyueEntity> {

   List<BangongYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
