package net.esliceu.movie.DAO;

import net.esliceu.movie.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrewMemberRepo extends JpaRepository<CrewMember, CrewMemberId> {
    List<CrewMember> findAllByIdMovie(Movie movie);

    List<CrewMember> findAllByIdPerson(Person person);

    List<CrewMember> findAllByIdDepartment(Department id);
}
