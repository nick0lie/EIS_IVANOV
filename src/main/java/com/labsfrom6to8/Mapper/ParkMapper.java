package com.labsfrom6to8.Mapper;

import com.labsfrom6to8.Model.Park;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ParkMapper {

    @Insert("INSERT INTO station_parks (name, location, capacity, is_open) VALUES (#{name}, #{location}, #{capacity}, #{isOpen})")
    void insertPark(Park park);

    @Update("UPDATE station_parks SET name = #{name}, location = #{location}, capacity = #{capacity}, is_open = #{isOpen} WHERE id = #{id}")
    void updatePark(Park park);

    @Select("SELECT * FROM station_parks")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "location", column = "location"),
            @Result(property = "isOpen", column = "is_open")
    })
    List<Park> selectAllParks();

    @Delete("DELETE FROM station_parks WHERE id = #{id}")
    void deletePark(Long id);
}
