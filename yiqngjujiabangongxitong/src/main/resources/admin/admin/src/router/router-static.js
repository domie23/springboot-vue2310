import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import bangongYuyue from '@/views/modules/bangongYuyue/list'
    import bumen from '@/views/modules/bumen/list'
    import dictionary from '@/views/modules/dictionary/list'
    import gonggao from '@/views/modules/gonggao/list'
    import huodongYuyue from '@/views/modules/huodongYuyue/list'
    import kaoqin from '@/views/modules/kaoqin/list'
    import liuyan from '@/views/modules/liuyan/list'
    import wangfanYuyue from '@/views/modules/wangfanYuyue/list'
    import xinzi from '@/views/modules/xinzi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import ziliao from '@/views/modules/ziliao/list'
    import dictionaryBangongYuyue from '@/views/modules/dictionaryBangongYuyue/list'
    import dictionaryBangongYuyueYesno from '@/views/modules/dictionaryBangongYuyueYesno/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryHuodongYuyueYesno from '@/views/modules/dictionaryHuodongYuyueYesno/list'
    import dictionaryKaoqin from '@/views/modules/dictionaryKaoqin/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryWangfanYuyue from '@/views/modules/dictionaryWangfanYuyue/list'
    import dictionaryWangfanYuyueShenti from '@/views/modules/dictionaryWangfanYuyueShenti/list'
    import dictionaryWangfanYuyueYesno from '@/views/modules/dictionaryWangfanYuyueYesno/list'
    import dictionaryZiliao from '@/views/modules/dictionaryZiliao/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryBangongYuyue',
        name: '办公用品',
        component: dictionaryBangongYuyue
    }
    ,{
        path: '/dictionaryBangongYuyueYesno',
        name: '报名状态',
        component: dictionaryBangongYuyueYesno
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryHuodongYuyueYesno',
        name: '报名状态',
        component: dictionaryHuodongYuyueYesno
    }
    ,{
        path: '/dictionaryKaoqin',
        name: '考勤结果',
        component: dictionaryKaoqin
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryWangfanYuyue',
        name: '交通工具',
        component: dictionaryWangfanYuyue
    }
    ,{
        path: '/dictionaryWangfanYuyueShenti',
        name: '身体状态',
        component: dictionaryWangfanYuyueShenti
    }
    ,{
        path: '/dictionaryWangfanYuyueYesno',
        name: '申报状态',
        component: dictionaryWangfanYuyueYesno
    }
    ,{
        path: '/dictionaryZiliao',
        name: '公司资料类型',
        component: dictionaryZiliao
    }


    ,{
        path: '/bangongYuyue',
        name: '办公设备',
        component: bangongYuyue
      }
    ,{
        path: '/bumen',
        name: '部门信息',
        component: bumen
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/gonggao',
        name: '公告信息',
        component: gonggao
      }
    ,{
        path: '/huodongYuyue',
        name: '请假信息',
        component: huodongYuyue
      }
    ,{
        path: '/kaoqin',
        name: '签到信息',
        component: kaoqin
      }
    ,{
        path: '/liuyan',
        name: '留言',
        component: liuyan
      }
    ,{
        path: '/wangfanYuyue',
        name: '外出报备',
        component: wangfanYuyue
      }
    ,{
        path: '/xinzi',
        name: '薪资',
        component: xinzi
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/ziliao',
        name: '公司资料',
        component: ziliao
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
