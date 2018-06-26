package com.neuedu.mapper;

import com.neuedu.po.Freelisten;
import com.neuedu.po.Lesson;

import java.util.ArrayList;

public interface ClassMapper {
    ArrayList<Lesson> getAllLessonByCondition(String type, String address);

    ArrayList<Freelisten> getAllFreelistenByCondition(String type, String address);
}
