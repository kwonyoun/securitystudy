package com.example.securitystudy.config;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//이건 SpringSecurityConfig에서 
//.requestMatchers(new AntPathRequestMatcher("/view/setting/admin")).hasAnyRole("ADMIN")을 사용하지 않으려고 
//이렇게 따로 파일을 만든거임.
//지정해주었으면 이 파일을 필요없음.
//결론 난 지금 이 파일이 필요없지만 그냥 둔다. 
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAnyRole('ADMIN')")
public @interface AdminAuthorize {
}
