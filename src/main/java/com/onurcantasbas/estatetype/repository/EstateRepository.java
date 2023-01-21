package com.onurcantasbas.estatetype.repository;
import com.onurcantasbas.estatetype.core.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EstateRepository extends JpaRepository<Estate,Long> {
// , JpaSpecificationExecutor

//    List<Estate> findAllByType(String type);
//    List<Estate> findAllBySquareMetersBetween(int first,int second);

    @Query(value = "SELECT sum(PRICE) FROM Estates",nativeQuery = true)
    public Double getPriceSumOfAll();

    @Query(value = "SELECT sum(PRICE) FROM Estates WHERE TYPE = :type",nativeQuery = true)
    public Double getPriceSumByType(@Param("type")String type);

    @Query(value = "SELECT avg(SQUARE_METERS) FROM Estates",nativeQuery = true)
    public Double getSqueraMetersAverageOfAll();

    @Query(value = "SELECT avg(SQUARE_METERS) FROM Estates WHERE TYPE = :type",nativeQuery = true)
    public Double getSqueraMetersAverageByType(@Param("type")String type);

    List<Estate> findAllByNumberOfRoomsBetweenAndNumberOfHallsBetween(int minRooms,int maxRooms,int minHalls,int maxHalls);



}
