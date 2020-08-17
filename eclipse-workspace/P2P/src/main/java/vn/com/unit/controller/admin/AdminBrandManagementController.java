package vn.com.unit.controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminBrandManagementController {

}
