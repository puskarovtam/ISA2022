package com.isa.transfuzija.enums;

public enum RoleName {
	REGISTERED_CLIENT, SYSTEM_ADMINISTRATOR, CENTER_ADMINISTRATOR;

	public static String roleToString(RoleName role) {
		switch (role) {
		case REGISTERED_CLIENT:
			return "Registered client";
		case SYSTEM_ADMINISTRATOR:
			return "System administrator";
		case CENTER_ADMINISTRATOR:
			return "Center administrator";
		default:
			return "Unknown role";
		}
	}

	public static RoleName stringToRole(String role) {
		switch (role) {
		case "Registered client":
			return RoleName.REGISTERED_CLIENT;
		case "System administrator":
			return RoleName.SYSTEM_ADMINISTRATOR;
		case "Center administrator":
			return RoleName.CENTER_ADMINISTRATOR;
		default:
			return RoleName.REGISTERED_CLIENT;
		}
	}
}
