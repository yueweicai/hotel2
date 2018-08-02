package com.orilore.biz;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.orilore.mapper.AdminMapper;
import com.orilore.mapper.RuleMapper;
import com.orilore.model.Admin;
import com.orilore.model.Rule;
@Service
public class AdminBiz implements IAdminBiz {
	@Resource
	private AdminMapper mapper;
	@Resource
	private RuleMapper dao;
	//数据库的事务处理  原子性，隔离性，持久性，一致性 (ACID)
	//Spring事务处理方式：编程式事务管理，声明式事务管理
	//Isolation   事务的隔离级别(脏读，幻读，不可重复读)
	//Propagation 事务的传播行为(嵌套式事务在执行过程中的解决方案)
	//RollbackFor 事务的回滚原则
	//timeout     事务的超时时间
	//readOnly    事务的只读状态
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean save(Admin bean,int pids[]) {
		boolean flag = true;
		if(bean.getId()!=null){
			if(mapper.update(bean)){
				if(dao.delete(bean.getId())){
					for(int pid : pids){
						Rule rule = new Rule(bean.getId(),pid);
						if(!dao.insert(rule)){
							flag = false;
							break;
						}
					}
				}
			}
		}else{
			if(mapper.insert(bean)){
				int aid = bean.getId();
				for(int pid : pids){
					Rule rule = new Rule(aid,pid);
					if(!dao.insert(rule)){
						flag = false;
						break;
					}
				}
			}else{
				flag = false;
			}
		}
		return flag;
	}

	@Override
	public boolean remove(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin find(Admin bean) {
		return mapper.selectOne(bean);
	}

	@Override
	public List<Admin> query() {
		return mapper.select();
	}

}
