package tiger.mapper;


import org.apache.ibatis.annotations.Param;
import tiger.dataobject.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    Users selectByUser(@Param("user") Users record);
}