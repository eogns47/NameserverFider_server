package potato.nsfServer.DataCenter.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import potato.nsfServer.DataCenter.domain.RootDomain;

@Repository
public interface RootDomainRepository extends JpaRepository<RootDomain,String> {

}
