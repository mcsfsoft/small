package com.qf.minchang.dao;

import java.util.List;

import com.qf.minchang.entity.Address;

public interface AddressDao {

	public List<Address> findAddressByUid(int id);

	public int UserfindIdByName(String username);

	public int updateAddressInfo(String name, String phone, String detail,int uid);
	
}
