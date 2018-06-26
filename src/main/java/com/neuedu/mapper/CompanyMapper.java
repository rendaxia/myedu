package com.neuedu.mapper;

import com.neuedu.po.Address;
import com.neuedu.po.Enterprise;
import com.neuedu.po.Teacher;

import java.util.ArrayList;

public interface CompanyMapper {
    ArrayList<Teacher> getAllTeacher();

    ArrayList<Address> getAllAddress();

    ArrayList<Enterprise> getAllEnterprise();
}
