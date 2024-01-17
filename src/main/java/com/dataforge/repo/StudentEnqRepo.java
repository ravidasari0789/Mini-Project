package com.dataforge.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dataforge.entity.StudentEnqInfo;


@Repository
public interface StudentEnqRepo extends JpaRepository<StudentEnqInfo, Integer> {

	   
	         public  List<StudentEnqInfo> findByCid(Integer cid);
}
