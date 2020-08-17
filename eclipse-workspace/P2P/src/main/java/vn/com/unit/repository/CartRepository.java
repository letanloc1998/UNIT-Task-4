package vn.com.unit.repository;

import java.util.List;

import org.springframework.data.mirage.repository.MirageRepository;
import org.springframework.data.repository.query.Param;

import vn.com.unit.entity.CartItem;

public interface CartRepository extends MirageRepository<CartItem, Long> {

	public List<CartItem> findAllCartItemByAccountId(@Param("account_id") Long account_id);

}