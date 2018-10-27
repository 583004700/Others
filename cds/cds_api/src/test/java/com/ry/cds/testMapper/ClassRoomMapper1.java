package com.ry.cds.testMapper;

import com.ry.cds.user.bo.ClassRoom;
import com.ry.cds.user.mapper.IBaseMapperClass;
import org.springframework.stereotype.Component;

@Component
public class ClassRoomMapper1 extends IBaseMapperClass<ClassRoom> {
	public ClassRoomMapper1() {
		super("classroom","classRoomID");
	}

}
