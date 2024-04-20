package com.OCCB.OCCB.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class tokenGen {
	public static List<UUID> james = new ArrayList<UUID>();
	public static UUID generateToken() {
		UUID uuid = UUID.randomUUID();
		james.add(uuid);
		return uuid;
	}
	public static Boolean verifyToken(UUID uuid) {
		if(james.contains(uuid)) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean loggout(UUID uuid){
		return james.remove(uuid);
	}
}
