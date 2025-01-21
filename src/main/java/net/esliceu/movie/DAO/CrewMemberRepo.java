package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.CrewMember;
import net.esliceu.movie.Model.CrewMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrewMemberRepo extends JpaRepository<CrewMember, CrewMemberId> {
}
