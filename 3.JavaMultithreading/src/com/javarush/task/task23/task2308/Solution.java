package com.javarush.task.task23.task2308;

/* 
Рефакторинг, вложенные классы
*/
public class Solution {
    public final static class Constants {
        public final static String SERVER_IS_CURRENTLY_NOT_ACCESSIBLE = "The server is currently not accessible.";
        public final static String USER_IS_NOT_AUTHORIZED = "The user is not authorized.";
        public final static String USER_IS_BANNED = "The user is banned.";
        public final static String ACCESS_IS_DENIED = "Access is denied.";

    }
    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Solution.Constants.SERVER_IS_CURRENTLY_NOT_ACCESSIBLE);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Solution.Constants.SERVER_IS_CURRENTLY_NOT_ACCESSIBLE, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Solution.Constants.USER_IS_NOT_AUTHORIZED);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Solution.Constants.USER_IS_NOT_AUTHORIZED, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Solution.Constants.USER_IS_BANNED);
        }

        public BannedUserException(Throwable cause) {
            super(Solution.Constants.USER_IS_BANNED, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Solution.Constants.ACCESS_IS_DENIED);
        }

        public RestrictionException(Throwable cause) {
            super(Solution.Constants.ACCESS_IS_DENIED, cause);
        }
    }

    public static void main(String[] args) {

    }
}
