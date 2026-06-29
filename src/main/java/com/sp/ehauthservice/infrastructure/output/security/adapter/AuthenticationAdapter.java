package com.sp.ehauthservice.infrastructure.output.security.adapter;

import com.sp.ehauthservice.domain.api.IAuthenticationServicePort;
import com.sp.ehauthservice.domain.constants.DomainConstants;
import com.sp.ehauthservice.domain.model.Role;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthenticationAdapter implements IAuthenticationServicePort {
    @Override
    public Role getCurrentUserRole() {
        Map<String, Object> claims = getClaimsFromAuthentication();
        if (claims == null) {
            return null;
        }
        String roleName = claims.get(DomainConstants.KEY_ROLE_NAME).toString();
        try {
            return Role.valueOf(roleName);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static Map<String, Object> getClaimsFromAuthentication() {
        var authentication = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }
        return (Map<String, Object>) authentication.getDetails();
    }

}
