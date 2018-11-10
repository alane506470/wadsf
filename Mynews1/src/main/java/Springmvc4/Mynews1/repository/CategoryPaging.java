package Springmvc4.Mynews1.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import Springmvc4.Mynews1.entity.Category;

public interface CategoryPaging extends PagingAndSortingRepository<Category, Integer> {

	
	public Page<Category> findAll(Pageable pageable);
	
}
