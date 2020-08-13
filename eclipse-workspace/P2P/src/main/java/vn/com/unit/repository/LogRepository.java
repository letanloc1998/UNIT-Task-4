package vn.com.unit.repository;

import org.springframework.data.mirage.repository.MirageRepository;
import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.Log;

public interface LogRepository extends MirageRepository<Log, Long> {

	public void saveLog(@Param("log") String log, @Param("type") String type, @Param("author") String author);

}
