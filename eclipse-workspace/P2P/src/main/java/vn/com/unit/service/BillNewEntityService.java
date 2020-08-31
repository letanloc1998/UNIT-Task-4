package vn.com.unit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.unit.entity.BillNewEntity;
import vn.com.unit.repository.BillNewEntityRepository;

@Service
@Transactional
public class BillNewEntityService {

	@Autowired
	BillNewEntityRepository billNewEntityRepository;

	public BillNewEntity save(BillNewEntity billNewEntity) {
		return billNewEntityRepository.save(billNewEntity);
	}

	public List<BillNewEntity> findAll() {
		List<BillNewEntity> billNewEntity = new ArrayList<>();
		Iterable<BillNewEntity> temp = billNewEntityRepository.findAll();
		temp.forEach(billNewEntity::add);
		return billNewEntity;
	}

	public List<BillNewEntity> findAll(Pageable pageable) {
		List<BillNewEntity> billNewEntity = new ArrayList<>();
		Iterable<BillNewEntity> temp = billNewEntityRepository.findAll(pageable);
		temp.forEach(billNewEntity::add);
		return billNewEntity;
	}

}
