package pkg1.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepo extends JpaRepository<StudentEntity, Integer> {
	@Query(value="select * from students where name=:name1",nativeQuery = true)    //native query means belongs to relational database
	List<StudentEntity> findByName(@Param(value = "name1") String name);
}
