package com.iudigital.citas.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.iudigital.citas.data.UsuarioRepository;
import com.iudigital.citas.domain.Usuario;

@Component
public class AdditionalTokenInfo implements TokenEnhancer {

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		Usuario user = userRepository.findByCorreo(authentication.getName()).orElseGet(null);

		if (user != null) {

			Map<String, Object> info = new HashMap<String, Object>();
			info.put("user_id", user.getIdUsuario());
			info.put("email", user.getCorreo());
			info.put("role", user.getRol().getIdRol());

			((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);

		}

		return accessToken;

	}
}
