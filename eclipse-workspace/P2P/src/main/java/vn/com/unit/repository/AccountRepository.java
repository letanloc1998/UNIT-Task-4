package vn.com.unit.repository;

import java.util.List;

import org.springframework.data.mirage.repository.MirageRepository;
import org.springframework.data.mirage.repository.query.Modifying;
import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.Account;

public interface AccountRepository extends MirageRepository<Account, Long> {

	public Account findByUsername(@Param("username") String username);
	
	@Modifying
	public void updateAccountPassword(@Param("id") Long id, @Param("password") String password);
	
	public List<Account> findAllAccount();
	public List<Account> findAllAccountActive(@Param("sizeOfPage") Integer sizeOfPage,@Param("offset") Integer offset);

	public Long createNewAccount(@Param("username") String username, @Param("password") String password);
	
	@Modifying
	public void setAccountPassword(@Param("account_id") Long account_id, @Param("password") String password);
	
	@Modifying
	public void saveAccount(@Param("account_id") Long account_id, @Param("name") String name , @Param("email") String email, @Param("phone") String phone);
	
	@Modifying
	public void setRoleByAccountId(@Param("id_account") Long id_account, @Param("id_role") Long id_role );
	
	public Account findAccountById(@Param("id") Long id);
	
	public int countAccountActive();
	
	@Modifying
	public void setDisableAccount(@Param("account_id") Long account_id,@Param("disable") Long disable );
}
