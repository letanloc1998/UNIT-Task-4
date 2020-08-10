package vn.com.unit.repository;

import org.springframework.data.mirage.repository.MirageRepository;
import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.Account;

public interface AccountRepository extends MirageRepository<Account, Long> {

	public Account findByUsername(@Param("username") String username);
	
	public void updateAccountPassword(@Param("id") Long id, @Param("password") String password);
	
}
