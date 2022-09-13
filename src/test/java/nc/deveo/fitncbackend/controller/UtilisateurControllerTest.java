package nc.deveo.fitncbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import nc.deveo.fitncbackend.domain.utilisateur.Entraineur;
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

import java.time.LocalDate;

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

    private Entraineur getEntraineur() {
        final Entraineur entraineur = new Entraineur();
        entraineur.setEmail("o@gmail.com");
        entraineur.setNom("OLIVE");
        entraineur.setPrenom("JP");
        entraineur.setDateNaissance(LocalDate.now());
        return entraineur;
    }

    @Test
    public void testNothingInRepository() throws Exception {

        //When
        mvc.perform(get("/utilisateur")).andExpect(status().isOk());
    }

    @Test
    public void testPost_shouldSuccess() throws Exception {
        final Utilisateur utilisateur = getEntraineur();

        var utilisateurString = objectMapper.writeValueAsString(utilisateur);

        //When
        mvc.perform(post("/utilisateur")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(utilisateurString))
                .andExpect(status().isCreated());
    }

    @Test
    public void testPut_shouldSuccess() throws Exception {
        final Utilisateur utilisateur = getEntraineur();

        var utilisateurString = objectMapper.writeValueAsString(utilisateur);

        mvc.perform(put("/utilisateur/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(utilisateurString))
                .andExpect(status().isOk());
    }
}
