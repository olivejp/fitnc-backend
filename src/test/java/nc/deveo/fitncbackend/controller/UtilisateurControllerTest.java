package nc.deveo.fitncbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import nc.deveo.fitncbackend.domain.utilisateur.Utilisateur;
import nc.deveo.fitncbackend.repository.UtilisateurRepository;
import nc.deveo.fitncbackend.service.UtilisateurService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UtilisateurController.class)
public class UtilisateurControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private UtilisateurService service;

    @MockBean
    private UtilisateurRepository repository;

    private Utilisateur getUtilisateur() {
        final Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail("o@gmail.com");
        utilisateur.setNom("OLIVE");
        utilisateur.setPrenom("JP");
        utilisateur.setDateNaissance(LocalDate.now());
        return utilisateur;
    }

    @Test
    public void testNothingInRepository() throws Exception {

        //When
        mvc.perform(get("/utilisateur")).andExpect(status().isOk());
    }

    @Test
    public void testPost_shouldSuccess() throws Exception {
        final Utilisateur utilisateur = getUtilisateur();

        var utilisateurString = objectMapper.writeValueAsString(utilisateur);

        //When
        mvc.perform(post("/utilisateur")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(utilisateurString))
                .andExpect(status().isCreated());
    }

    @Test
    public void testPut_shouldSuccess() throws Exception {
        final Utilisateur utilisateur = getUtilisateur();

        var utilisateurString = objectMapper.writeValueAsString(utilisateur);

        mvc.perform(put("/utilisateur/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(utilisateurString))
                .andExpect(status().isOk());
    }
}
