package controller;

import javax.servlet.http.HttpSession;

public class UserSessionUtils {
    public static final String USER_SESSION_KEY = "userId";

    /* 현재 로그인한 사용자의 ID를 구함 */
    public static long getLoginUserId(HttpSession session) {
    	long userId;
    	
    	if(session.getAttribute(USER_SESSION_KEY) == null) userId = 0;
    	else userId = (Long) session.getAttribute(USER_SESSION_KEY);
    	
        return userId;
    }

    /* 로그인한 상태인지를 검사 */
    public static boolean hasLogined(HttpSession session) {
        if (getLoginUserId(session) != 0) {
            return true;
        }
        return false;
    }

    /* 현재 로그인한 사용자의 ID가 userId인지 검사 */
    public static boolean isLoginUser(long leaderId, HttpSession session) {
    	long loginUser = getLoginUserId(session);
        if (loginUser == 0) {
            return false;
        }
        return loginUser == leaderId;
    }
    
    /* 로그인 */
    public static void login(long userid, HttpSession session) {
    	session.setAttribute(USER_SESSION_KEY, userid);
    }
    
    /* 로그아웃 */
    public static void logout(HttpSession session) {
    	session.removeAttribute(USER_SESSION_KEY);
    }
}
