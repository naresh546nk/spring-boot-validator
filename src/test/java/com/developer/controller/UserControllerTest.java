package com.developer.controller;


import com.developer.model.User;
import com.developer.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.hibernate.validator.constraints.Length;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc

public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private  ObjectMapper objectMapper=new ObjectMapper();

    private User user1=User.builder()
            .id(3)
            .name("Abinash")
            .email("abinash@gmail.com")
            .age(25)
            .build();
    private User user2= User.builder()
            .id(2)
            .name("Ramesh Kumar")
            .email("ramesh.nk@gmail.com")
            .age(27)
            .build();



    @Test
    public  void  addUserTest() throws Exception {
        String json=objectMapper.writeValueAsString(user1);
        Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(user1);
        String contentAsString = mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Assertions.assertEquals(contentAsString.contains("abinash@gmail.com"),true);
    }


    @Test
    public  void  addUserBadUserTest() throws Exception {
        user1.setName("");
        user1.setEmail("email");
        String json=objectMapper.writeValueAsString(user1);
        Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(user1);
        String contentAsString = mockMvc.perform(post("/user").contentType(MediaType.APPLICATION_JSON).characterEncoding("utf-8")
                .content(json).accept(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest())
                .andReturn().getResponse().getContentAsString();
                assertEquals(contentAsString.contains("Name is mandatory"),true);


    }


    @Test
    public  void  getUsersTest() throws Exception {
        Mockito.when(userService.getUsers()).thenReturn(List.of(user1,user2));
        String response = mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        Assertions.assertEquals(response.contains("abinash@gmail.com"),true);
    }
}
