package group15.intranet.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import group15.intranet.entity.Role;
import group15.intranet.model_request.RolesDetailsModelRequest;

public interface RoleService {

	List<Role> getRoles();
}
