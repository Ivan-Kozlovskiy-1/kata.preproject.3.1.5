package app.service;

import app.model.Role;
import java.util.List;
import java.util.Set;

public interface RoleService {
    public Set<Role> findRoles(List<Long> roles);
    public List<Role> getAllRoles();
}
