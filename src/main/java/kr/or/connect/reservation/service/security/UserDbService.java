package kr.or.connect.reservation.service.security;

import java.util.List;

import kr.or.connect.reservation.entity.UserEntity;
import kr.or.connect.reservation.entity.UserRoleEntity;

public interface UserDbService {
	public UserEntity getUser(String loginUserId);
	public List<UserRoleEntity> getUserRoles(String loginUserId);
}
