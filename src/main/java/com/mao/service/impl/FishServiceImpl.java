package com.mao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mao.dao.FishMapper;
import com.mao.proj.Fish;
import com.mao.service.FishService;

@Service
public class FishServiceImpl implements FishService{

	@Autowired
	private FishMapper fishMapper;
	
	
	@Override
	public void updataSetting(int id, int smart, int water, int wendu, int o2) {
		// TODO Auto-generated method stub
		
		Fish fish=new Fish();
		fish.setId(id);
		fish.setSmart(smart);
		fish.setWater(water);
		fish.setWendu(wendu);
		fish.setO2(o2);
		
		fishMapper.updateByPrimaryKey(fish);
	}
}
