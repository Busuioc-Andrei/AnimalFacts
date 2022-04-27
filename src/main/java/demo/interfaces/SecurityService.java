package demo.interfaces;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}