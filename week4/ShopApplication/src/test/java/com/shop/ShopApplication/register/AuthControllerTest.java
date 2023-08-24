package com.shop.ShopApplication.register;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class AuthControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AuthService authService;

    @InjectMocks
    private AuthController authController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(authController).build();
    }

    @Test
    void testRegister() throws Exception {
        RegisterRequest registerRequest = new RegisterRequest("John", "Doe", "john@example.com", "password123");
        AuthResponse authResponse = new AuthResponse("token");

        when(authService.register(any(RegisterRequest.class))).thenReturn(authResponse);

        mockMvc.perform(post("/api/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(registerRequest)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.token").value("token"));

        verify(authService, times(1)).register(any(RegisterRequest.class));
        verifyNoMoreInteractions(authService);
    }

    @Test
    void testLogin() throws Exception {
        AuthRequest authRequest = new AuthRequest("beks@gmail.com", "password123");
        AuthResponse authResponse = new AuthResponse("token");

        when(authService.login(any(AuthRequest.class))).thenReturn(authResponse);

        mockMvc.perform(post("/api/log")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(authRequest)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.token").value("token"));

        verify(authService, times(1)).login(any(AuthRequest.class));
        verifyNoMoreInteractions(authService);
    }

    @Test
    void testLoginWithInvalidCredentials() throws Exception {
        AuthRequest authRequest = new AuthRequest("invalidUsername", "invalidPassword");

        when(authService.login(any(AuthRequest.class))).thenThrow(new UsernameNotFoundException("Invalid credentials"));

        try {
            mockMvc.perform(post("/api/log")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(asJsonString(authRequest)))
                    .andExpect(status().isUnauthorized());
        } catch (NestedServletException e) {
            // Handle or assert the exception if needed
            assertThat(e.getCause()).isInstanceOf(UsernameNotFoundException.class);
        }

        verify(authService, times(1)).login(any(AuthRequest.class));
        verifyNoMoreInteractions(authService);
    }


    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}