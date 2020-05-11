package com.example.demo.usersystem.security;


import com.example.demo.usersystem.domain.User;
import java.util.concurrent.ConcurrentHashMap;
import javax.naming.OperationNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserSessionManager {

	@Autowired
	private CacheManager cacheManager;

	@Cacheable(value = "online_user", key = "#sessionId")
	public User getOnlineUser(String sessionId, User user) {
		return user;
	}

	@CacheEvict(value = "online_user", key = "#sessionId")
	public void removeOnlineUser(String sessionId) {
	}

	public int getOnlineUserNum() throws OperationNotSupportedException {
		Cache cache = this.cacheManager.getCache("online_user");
		if (cache == null) {
			return 0;
		}
		Object nativeCache = cache.getNativeCache();
		if (nativeCache instanceof ConcurrentHashMap) {
			ConcurrentHashMap map = (ConcurrentHashMap) nativeCache;
			return map.size();
		}
		throw new OperationNotSupportedException("缓存不支持");
	}

}
