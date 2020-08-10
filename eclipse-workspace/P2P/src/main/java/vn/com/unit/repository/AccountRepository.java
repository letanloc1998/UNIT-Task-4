package vn.com.unit.repository;

import org.springframework.data.mirage.repository.MirageRepository;

import vn.com.unit.entity.Account;

public interface AccountRepository extends MirageRepository<Account, Long> {

	public Account findByUsername(@Param("username") String username);
	
}
