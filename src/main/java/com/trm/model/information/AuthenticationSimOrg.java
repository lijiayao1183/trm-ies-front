package com.trm.model.information;

public class AuthenticationSimOrg {
	    String ente_name;
	    String org_code;
	    String modify_time;
		public AuthenticationSimOrg(String ente_name, String org_code, String modify_time) {
			this.ente_name = ente_name;
			this.org_code = org_code;
			this.modify_time = modify_time;
		}
		public String getEnte_name() {
			return ente_name;
		}
		public void setEnte_name(String ente_name) {
			this.ente_name = ente_name;
		}
		public String getOrg_code() {
			return org_code;
		}
		public void setOrg_code(String org_code) {
			this.org_code = org_code;
		}
		public String getModify_time() {
			return modify_time;
		}
		public void setModify_time(String modify_time) {
			this.modify_time = modify_time;
		}
		public AuthenticationSimOrg() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	   
}
