package com.xloop.resourceloop.candidateprofile;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xloop.resourceloop.candidateprofile.controller.CandidateAcademicInfoController;
import com.xloop.resourceloop.candidateprofile.model.CandidatePersonalInfo;
import com.xloop.resourceloop.candidateprofile.repository.ICandidatePersonalInfoRepository;
import com.xloop.resourceloop.candidateprofile.service.CandidatePersonalInfoService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureJsonTesters
@AutoConfigureMockMvc
class CandidateprofileApplicationTests {

    private MockMvc mockMvc;

	
    // @Mock
    // private ICandidatePersonalInfoRepository personalInformationRepository;

    @Mock
    private CandidatePersonalInfoService personalInformationService;

    @InjectMocks
    private CandidateAcademicInfoController personalInformationController;
    private JacksonTester<CandidatePersonalInfo> jsonPersonalInformation;
    private JacksonTester<List<CandidatePersonalInfo>> jsonPersonalInformations;

    @BeforeEach
    public void setUp(){
        JacksonTester.initFields(this, new ObjectMapper());
        
        mockMvc = MockMvcBuilders.standaloneSetup(personalInformationController).build();
        
        
    }

    // @BeforeEach
    // public void setUp() {
    //     personalInformation = new CandidatePersonalInfo();
    //     personalInformation.setFirstName("John");
    //     personalInformation.setLastName("Doe");
    //     personalInformation.setDateOfBirth(LocalDate.of(2000, 1, 1));
    //     personalInformation.setGender("Male");
    //     personalInformation.setNationalIdentityNumber("1234567890");
    //     personalInformation.setCity("New York");
    //     personalInformation.setAddress("123 Main St");
    //     personalInformation.setLinkedProfile("https://linkedin.com/john-doe");
    //     personalInformation.setMaritalStatus("Single");
    // }

    // @Test
    // public void testCreatePersonalInformation() {
    //     CandidatePersonalInfo createdPersonalInformation = personalInformationService.createPersonalInformation(personalInformation);
    //     assertNotNull(createdPersonalInformation.getId());
    //     assertEquals(personalInformation.getFirstName(), createdPersonalInformation.getFirstName());
    //     assertEquals(personalInformation.getLastName(), createdPersonalInformation.getLastName());
    //     assertEquals(personalInformation.getDateOfBirth(), createdPersonalInformation.getDateOfBirth());
    //     assertEquals(personalInformation.getGender(), createdPersonalInformation.getGender());
    //     assertEquals(personalInformation.getNationalIdentityNumber(), createdPersonalInformation.getNationalIdentityNumber());
    //     assertEquals(personalInformation.getCity(), createdPersonalInformation.getCity());
    //     assertEquals(personalInformation.getAddress(), createdPersonalInformation.getAddress());
    //     assertEquals(personalInformation.getLinkedProfile(), createdPersonalInformation.getLinkedProfile());
    // }

    // @Test 
    // public void testGetPersonalInformation(){
    //     CandidatePersonalInfo savedPersonalInformation = personalInformationService.createPersonalInformation(personalInformation);
    //     CandidatePersonalInfo retrievedPersonalInformation =personalInformationService.getPersonalInformationById(savedPersonalInformation.getId());
    //     assertNotNull(retrievedPersonalInformation);
    //     assertEquals(savedPersonalInformation.getId(), retrievedPersonalInformation.getId());
    // }

    /**
     * @throws Exception
     */
    @Test
    public void testCreatePersonalInformation() throws Exception {
        
        CandidatePersonalInfo personalInformation = new CandidatePersonalInfo("John","Doe",Date.valueOf(LocalDate.now()),"Male","123456789","098765432","New York","123 Main St","hello","Single");
        // personalInformation.setLastName("Doe");
        // personalInformation.setDateOfBirth(Date.valueOf(LocalDate.now()));
        // personalInformation.setGender("Male");
        // personalInformation.setNationalIdentityNumber("1234567890");
        // personalInformation.setCity("New York");
        // personalInformation.setAddress("123 Main St");
        // personalInformation.setLinkedProfile("https://linkedin.com/john-doe");
        // personalInformation.setMaritalStatus("Single");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(personalInformation);
        
        when(personalInformationService.createPersonalInformation(personalInformation)).thenReturn(personalInformation);
        
        mockMvc.perform(post("/api/personal-information")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated());
                // .andExpect(content().json(jsonPersonalInformation));


    }


}
