package cn.edu.zucc.util;

import cn.edu.zucc.model.TbUserEntity;
import cn.edu.zucc.service.UserService;
import cn.edu.zucc.service.UserServiceImpl;

/**
 * Created by shentao on 2016/5/3.
 */
public class test {
    public static void main(String[] args) {

//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
 //        session.beginTransaction();
 //        List list = session.createQuery("from TbUserEntity ").list();
 //        Iterator iterator = list.iterator();
 //        while(iterator.hasNext()){
 //            TbUserEntity userEntity = (TbUserEntity) iterator.next();
 //            System.out.println(userEntity.getUsername()+ "\t");
 //            System.out.println(userEntity.getPwd());
 //
 //        }
 //        session.getTransaction().commit();
 /**
 * 判断密码是否正确
 */
        UserService userDao = new UserServiceImpl();
        if(userDao.login("12","12")!=null){
        System.out.print("账号密码正确");
        }else{
            System.out.print("账号密码错误");
        }

/**
 *在添加账号时判断数据库中是否有此账号，1为没有，-1为有
 */
        TbUserEntity user = new TbUserEntity();
        user.setUsername("13");
        user.setPwd("1");
        int i =userDao.add(user);
        System.out.print(i);



    }
}
