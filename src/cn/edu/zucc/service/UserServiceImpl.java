package cn.edu.zucc.service;

import cn.edu.zucc.dao.UserDao;
import cn.edu.zucc.dao.UserDaoImpl;
import cn.edu.zucc.model.TbUserEntity;
import cn.edu.zucc.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by shentao on 2016/5/3.
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao = new UserDaoImpl();

    @Override
    public int add(TbUserEntity user) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        int i=-1;
        if(userDao.checkAcount(user.getUsername()) == false){
            i =  userDao.add(user);
            tx.commit();
       }

        return i;
    }

    @Override
    public TbUserEntity login(String username, String password) {
        return userDao.login(username,password);
    }


}
