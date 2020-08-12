package vn.com.unit.repository;

import java.util.List;

import org.springframework.data.mirage.repository.MirageRepository;
import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.Account;

public interface AccountRepository extends MirageRepository<Account, Long> {

	public Account findByUsername(@Param("username") String username);
	
	public void updateAccountPassword(@Param("id") Long id, @Param("password") String password);
	
	public List<Account> findAllAccount();
	public List<Account> findAllAccountActive();

	public Long createNewAccount(@Param("username") String username, @Param("password") String password);
	
}
