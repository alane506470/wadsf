package Springmvc4.Mynews1.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import Springmvc4.Mynews1.entity.Category;
import Springmvc4.Mynews1.entity.Photo;

public interface PhotoPaging extends PagingAndSortingRepository<Photo, Integer> {

	public Page<Photo> findAll(Pageable pageable);
}
