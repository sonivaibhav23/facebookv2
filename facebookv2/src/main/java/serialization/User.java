package serialization;

import java.io.Serializable;

import lombok.Data;

/**
 * Created by vaibhav.soni on 5/2/2017.
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;

}
