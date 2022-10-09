package pl.jaceksysiak.model;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteUserDao extends PagingAndSortingRepository<SiteUser, Long> {
	
	SiteUser findByEmail(String email);

}


//@Repository
//public interface SiteUserDao extends CrudRepository<SiteUser, Long> {
//	SiteUser findByEmail(String email);
//}
