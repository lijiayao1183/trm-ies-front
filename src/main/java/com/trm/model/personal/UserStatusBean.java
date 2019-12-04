package com.trm.model.personal;

public class UserStatusBean {
    private String isLogin;
    private String isAuth;

    public String getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(String isLogin) {
        this.isLogin = isLogin;
    }

    public String getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(String isAuth) {
        this.isAuth = isAuth;
    }

    @Override
    public String toString() {
        return "UserStatusBean [isLogin=" + isLogin + ", isAuth=" + isAuth + "]";
    }

}
