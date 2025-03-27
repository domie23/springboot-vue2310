
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 外出报备
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wangfanYuyue")
public class WangfanYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(WangfanYuyueController.class);

    private static final String TABLE_NAME = "wangfanYuyue";

    @Autowired
    private WangfanYuyueService wangfanYuyueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BangongYuyueService bangongYuyueService;//办公设备
    @Autowired
    private BumenService bumenService;//部门信息
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告信息
    @Autowired
    private HuodongYuyueService huodongYuyueService;//请假信息
    @Autowired
    private KaoqinService kaoqinService;//签到信息
    @Autowired
    private LiuyanService liuyanService;//留言
    @Autowired
    private XinziService xinziService;//薪资
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZiliaoService ziliaoService;//公司资料
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = wangfanYuyueService.queryPage(params);

        //字典表数据转换
        List<WangfanYuyueView> list =(List<WangfanYuyueView>)page.getList();
        for(WangfanYuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WangfanYuyueEntity wangfanYuyue = wangfanYuyueService.selectById(id);
        if(wangfanYuyue !=null){
            //entity转view
            WangfanYuyueView view = new WangfanYuyueView();
            BeanUtils.copyProperties( wangfanYuyue , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(wangfanYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WangfanYuyueEntity wangfanYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wangfanYuyue:{}",this.getClass().getName(),wangfanYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            wangfanYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WangfanYuyueEntity> queryWrapper = new EntityWrapper<WangfanYuyueEntity>()
            .eq("yonghu_id", wangfanYuyue.getYonghuId())
            .eq("wangfan_yuyue_types", wangfanYuyue.getWangfanYuyueTypes())
            .eq("wangfan_yuyue_mudidi", wangfanYuyue.getWangfanYuyueMudidi())
            .eq("wangfan_yuyue_chufadi", wangfanYuyue.getWangfanYuyueChufadi())
            .eq("wangfan_yuyue_shenti_types", wangfanYuyue.getWangfanYuyueShentiTypes())
            .eq("wangfan_yuyue_chufa_time", new SimpleDateFormat("yyyy-MM-dd").format(wangfanYuyue.getWangfanYuyueChufaTime()))
            .eq("wangfan_yuyue_daoda_time", new SimpleDateFormat("yyyy-MM-dd").format(wangfanYuyue.getWangfanYuyueDaodaTime()))
            .in("wangfan_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WangfanYuyueEntity wangfanYuyueEntity = wangfanYuyueService.selectOne(queryWrapper);
        if(wangfanYuyueEntity==null){
            wangfanYuyue.setWangfanYuyueYesnoTypes(1);
            wangfanYuyue.setInsertTime(new Date());
            wangfanYuyue.setCreateTime(new Date());
            wangfanYuyueService.insert(wangfanYuyue);
            return R.ok();
        }else {
            if(wangfanYuyueEntity.getWangfanYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(wangfanYuyueEntity.getWangfanYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WangfanYuyueEntity wangfanYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wangfanYuyue:{}",this.getClass().getName(),wangfanYuyue.toString());
        WangfanYuyueEntity oldWangfanYuyueEntity = wangfanYuyueService.selectById(wangfanYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            wangfanYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(wangfanYuyue.getWangfanYuyueText()) || "null".equals(wangfanYuyue.getWangfanYuyueText())){
                wangfanYuyue.setWangfanYuyueText(null);
        }
        if("".equals(wangfanYuyue.getWangfanYuyueYesnoText()) || "null".equals(wangfanYuyue.getWangfanYuyueYesnoText())){
                wangfanYuyue.setWangfanYuyueYesnoText(null);
        }

            wangfanYuyueService.updateById(wangfanYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody WangfanYuyueEntity wangfanYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,wangfanYuyueEntity:{}",this.getClass().getName(),wangfanYuyueEntity.toString());

        WangfanYuyueEntity oldWangfanYuyue = wangfanYuyueService.selectById(wangfanYuyueEntity.getId());//查询原先数据

//        if(wangfanYuyueEntity.getWangfanYuyueYesnoTypes() == 2){//通过
//            wangfanYuyueEntity.setWangfanYuyueTypes();
//        }else if(wangfanYuyueEntity.getWangfanYuyueYesnoTypes() == 3){//拒绝
//            wangfanYuyueEntity.setWangfanYuyueTypes();
//        }
        wangfanYuyueEntity.setWangfanYuyueShenheTime(new Date());//审核时间
        wangfanYuyueService.updateById(wangfanYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WangfanYuyueEntity> oldWangfanYuyueList =wangfanYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        wangfanYuyueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<WangfanYuyueEntity> wangfanYuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            WangfanYuyueEntity wangfanYuyueEntity = new WangfanYuyueEntity();
//                            wangfanYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            wangfanYuyueEntity.setWangfanYuyueText(data.get(0));                    //申请理由 要改的
//                            wangfanYuyueEntity.setWangfanYuyueTypes(Integer.valueOf(data.get(0)));   //交通工具 要改的
//                            wangfanYuyueEntity.setWangfanYuyueMudidi(data.get(0));                    //去哪里 要改的
//                            wangfanYuyueEntity.setWangfanYuyueChufadi(data.get(0));                    //地址 要改的
//                            wangfanYuyueEntity.setWangfanYuyueShentiTypes(Integer.valueOf(data.get(0)));   //身体状态 要改的
//                            wangfanYuyueEntity.setWangfanYuyueChufaTime(sdf.parse(data.get(0)));          //出发时间 要改的
//                            wangfanYuyueEntity.setWangfanYuyueDaodaTime(sdf.parse(data.get(0)));          //到达时间 要改的
//                            wangfanYuyueEntity.setWangfanYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //申报状态 要改的
//                            wangfanYuyueEntity.setWangfanYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            wangfanYuyueEntity.setWangfanYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            wangfanYuyueEntity.setInsertTime(date);//时间
//                            wangfanYuyueEntity.setCreateTime(date);//时间
                            wangfanYuyueList.add(wangfanYuyueEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        wangfanYuyueService.insertBatch(wangfanYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

