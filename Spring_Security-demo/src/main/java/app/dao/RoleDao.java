package app.dao;

import app.model.Role;
import java.util.List;
import java.util.Set;

public interface RoleDao {
    public Set<Role> findRoles(List<Long> roles);
    public List<Role> getAllRoles();
}