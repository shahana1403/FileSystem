package data;

import java.io.Serializable;
import javax.swing.ImageIcon;

public class Data implements Serializable {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return name;
    }

    private String status;
    private String name;
}
