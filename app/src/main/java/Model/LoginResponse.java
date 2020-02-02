package Model;

public class LoginResponse {

    private String token;
    private String status;
    private String result;

    public LoginResponse(String token, String status, String result) {
        this.token = token;
        this.status = status;
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
