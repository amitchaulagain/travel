package com.travel.service.impl;

import com.travel.handler.NotFoundException;
import com.travel.model.dto.HobbyInfoDto;
import com.travel.model.entities.*;
import com.travel.model.entities.AppClient;
import com.travel.model.entities.Category;
import com.travel.model.entities.Hobby;
import com.travel.model.entities.Location;
import com.travel.model.entities.enums.CategoryNameEnum;
import com.travel.model.entities.enums.LocationEnum;
import com.travel.model.repostiory.CategoryRepository;
import com.travel.model.repostiory.HobbyRepository;
import com.travel.service.*;
import com.cloudinary.Cloudinary;
import com.travel.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class HobbyServiceImplTest {
    private HobbyRepository mockHobbyRepository;
    private NotificationService notificationService;
    private HobbyService hobbyServiceToTest;
    private AppClient appClient;
    private Hobby hobby;

    @BeforeEach
    void setUp() {
        mockHobbyRepository = mock(HobbyRepository.class);
        CategoryRepository mockCategoryRepository;
        CategoryService categoryServiceTest = mock(CategoryService.class);
        LocationService locationServiceTest = mock(LocationService.class);
        mockCategoryRepository = mock(CategoryRepository.class);
        appClient = new AppClient();
        Cloudinary cloudinary = mock(Cloudinary.class);
        UserService userServiceTest = mock(UserService.class);

        hobbyServiceToTest = new HobbyServiceImpl
                (mockHobbyRepository, categoryServiceTest, userServiceTest, locationServiceTest, cloudinary);

        // prepare hobby data
        hobby = new Hobby();
        hobby.setId(1L);
        HobbyInfoDto hobbyServiceModel = new HobbyInfoDto();
        hobbyServiceModel.setCategory(CategoryNameEnum.ACTIVE);
        hobbyServiceModel.setLocation(LocationEnum.ZURICH);
        hobby.setIntro("intro");
        hobby.setSlogan("slogan");
        hobby.setDescription("description");
        hobby.setProfileImgUrl("img_url");
        hobby.setGalleryImgUrl1("img_1");
        hobby.setGalleryImgUrl2("img_2");
        hobby.setGalleryImgUrl3("img_3");
        hobby.setProfileImg_id("0");
        hobby.setGalleryImg1_id("1");
        hobby.setGalleryImg2_id("2");
        hobby.setGalleryImg3_id("3");

        Location location = new Location();
        location.setName(LocationEnum.ZURICH);
        hobby.setLocation(location);
        hobby.setCreator("businessOwner");
        hobby.setPrice(new BigDecimal("100"));
        Category category = new Category();
        category.setName(CategoryNameEnum.ACTIVE);
        hobby.setCategory(category);
        hobby.setName("hobbyName");
        hobby.setContactInfo("contact info");

        //config mock
        when(mockCategoryRepository.save(Mockito.any(Category.class)))
                .thenAnswer(i -> i.getArguments()[0]);
        when(mockHobbyRepository.save(Mockito.any(Hobby.class)))
                .thenAnswer(i -> i.getArguments()[0]);
        when(categoryServiceTest.findByName(CategoryNameEnum.ACTIVE)).
                thenReturn(new Category() {{
                    setName(CategoryNameEnum.ACTIVE);
                }});

        when(locationServiceTest.getLocationByName(LocationEnum.ZURICH)).
                thenReturn(location);
        when(mockHobbyRepository.findById(1L)).
                thenReturn(Optional.of(hobby));
        when(userServiceTest.findAppClientByUsername("username")).
                thenReturn(appClient);

    }

    @Test
    void testUserNotFound() {
        Assertions.assertThrows(
                NotFoundException.class, () -> {
                    hobbyServiceToTest.findHobbieById(null);
                    hobbyServiceToTest.deleteHobby(0L);
                }
        );
    }

    @Test
    void findHobbyById_should_Work() {
        Assertions.assertEquals(hobby, hobbyServiceToTest.findHobbieById(1L));
    }

    @Test
    void saveHobbyForClient_should_work() {
        appClient.setSaved_hobbies(new ArrayList<>());
        hobbyServiceToTest.saveHobbyForClient(hobby, "username");
        assertEquals(1, appClient.getSaved_hobbies().size());
    }

    @Test
    void removeHobbyForClient_should_work() {
        List<Hobby> saved = new ArrayList<>();
        saved.add(hobby);
        appClient.setSaved_hobbies(saved);
        hobbyServiceToTest.removeHobbyForClient(hobby, "username");
        assertEquals(0, appClient.getSaved_hobbies().size());
    }

    @Test
    void isHobbySaved_should_work() {
        appClient.setSaved_hobbies(new ArrayList<>());
        hobbyServiceToTest.saveHobbyForClient(hobby, "username");
        assertTrue(hobbyServiceToTest.isHobbySaved(1L, "username"));
    }

    @Test
    void findSavedHobbies_should_work() {
        appClient.setSaved_hobbies(new ArrayList<>());
        hobbyServiceToTest.saveHobbyForClient(hobby, "username");
        assertEquals(1, hobbyServiceToTest.findSavedHobbies(appClient).size());
    }
}