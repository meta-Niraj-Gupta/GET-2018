package com.metacube.training.service;

import com.metacube.training.model.UserToken;

public interface UserTokenService {
	boolean deleteUserToken(UserToken userToken);

	boolean createUserToken(UserToken userToken);

	UserToken getUserTokenByEmail(String emailId);

	UserToken getUserTokenByUserToken(String userToken);
}
