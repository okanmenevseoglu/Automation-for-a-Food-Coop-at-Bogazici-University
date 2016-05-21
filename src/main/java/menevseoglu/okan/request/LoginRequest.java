package menevseoglu.okan.request;

import lombok.Data;

/**
 * This class is used for login requests.
 */
@Data
public class LoginRequest {
    private String name;
    private String password;
}
