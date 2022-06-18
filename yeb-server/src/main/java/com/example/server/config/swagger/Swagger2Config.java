package com.example.server.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author A04153
 */
@Configuration
@EnableSwagger2
public class Swagger2Config{
	/**
	 * 规定扫描那些包下面生成文档
	 * @return
	 */
	@Bean
	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				       .select().apis(RequestHandlerSelectors.basePackage("com.example.server.controller"))
				       .paths(PathSelectors.any()).build()
				.securityContexts(securityContexts()).securitySchemes(securitySchemes());
	}

	private List<SecurityContext> securityContexts(){
		//设置请求头信息
		List<SecurityContext> result= new ArrayList<>();
		result.add(getContentByPath(""));
		return result;
	}

	private SecurityContext getContentByPath(String pathRegex){
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex(pathRegex)).build();
	}

	private List<SecurityReference> defaultAuth(){
		List<SecurityReference> result = new ArrayList<>();
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes=new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		result.add(new SecurityReference("Authorization",authorizationScopes));
		return result;

	}

	private List<ApiKey> securitySchemes(){
		//设置请求头信息
		List<ApiKey> result= new ArrayList<>();
		ApiKey apiKey = new ApiKey("Authorization", "Authorization", "header");
		result.add(apiKey);
		return result;
	}

	private ApiInfo apiInfo(){
		return new ApiInfoBuilder().title("接口文档").description("云E办接口文档").build();
	}
}
