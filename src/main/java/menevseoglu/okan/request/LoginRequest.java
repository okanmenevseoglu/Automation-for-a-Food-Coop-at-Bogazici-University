package menevseoglu.okan.request;

import lombok.Data;

/**
 * Created by Okan Men on 19.05.2016.
 */
@Data
public class LoginRequest {
    private String name;
    private String password;
}
