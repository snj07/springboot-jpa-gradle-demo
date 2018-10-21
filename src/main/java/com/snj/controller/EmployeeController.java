package com.snj.controller;


import com.snj.entities.Employee;
import com.snj.services.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/employee")
@Api(value = "employee management", description = "employee management system")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TokenStore tokenStore;
    @Value("${config.oauth2.resource.jwt.key-pair.store-password}")
    private String keyStorePass;

    @Value("${config.oauth2.resource.jwt.key-pair.alias}")
    private String keyPairAlias;


/*
    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {

        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        KeyStoreKeyFactory keyStoreKeyFactory =
                new KeyStoreKeyFactory(new ClassPathResource("public.key"), keyStorePass.toCharArray());
        converter.setKeyPair(keyStoreKeyFactory.getKeyPair(keyPairAlias));
        return converter;
    }

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }
*/

    @PreAuthorize("#oauth2.hasScope('write')")
    @ApiOperation(value = "Add a employee data")
    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createCustomer(employee);
    }

    @ApiOperation(value = "View a list of available products", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Resource access is forbidden"),
            @ApiResponse(code = 404, message = "The resource is not found")
    }
    )
    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public Iterable<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(method = RequestMethod.GET, value = "/users/extra")
    @ResponseBody
    public Map<String, Object> getExtraInfo(OAuth2Authentication auth) {
        final OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) auth.getDetails();
        final OAuth2AccessToken accessToken = tokenStore.readAccessToken(details.getTokenValue());
        System.out.println(accessToken);
        return accessToken.getAdditionalInformation();
    }
}