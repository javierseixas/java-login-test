package javierseixas.schibsted.domain.model.user;

public class Role {
    private String roleName, pageKey;

    public Role(String roleName, String pageKey) {
        this.roleName = roleName;
        this.pageKey = pageKey;
    }

    public String roleName() {
        return roleName;
    }

    public String pageKey() {
        return pageKey;
    }
}
