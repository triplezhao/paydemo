package pay.lib.data.bean;

/**
 * Created by ztw on 2015/7/6.
 */
public class BaiduCategory {
    private String id;
    private String name;

    public BaiduCategory(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
