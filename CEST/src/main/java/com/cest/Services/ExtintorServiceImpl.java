package com.cest.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cest.Dao.ExtintorDAO;
import com.cest.Models.Extintor;

@Transactional
@Service("extintorService")
public class ExtintorServiceImpl implements ExtintorService{

	@Autowired
	private ExtintorDAO extintorDao;
	
	@Override
	public Extintor update(Extintor extintor) {
		return extintorDao.save(extintor);
	}
	
}
