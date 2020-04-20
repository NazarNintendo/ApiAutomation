public class Card {
    private String idList = "5e9d837cf17f181b382f8c27";
    private String id;
    private String name;
    private String key = "dedfae186b010ca2d55c1c61cf646fb9";
    private String token = "359d0423f839677f31c4041e0d89c60f8b152fd777ef15a375f21027ce5421b0";

    Card(String name) {
        this.name = name;
    }

    public String getIdList() {
        return idList;
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

    public String getKey() {
        return key;
    }

    public String getToken() {
        return token;
    }
}
