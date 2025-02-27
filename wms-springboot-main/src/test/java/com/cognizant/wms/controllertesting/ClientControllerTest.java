package com.cognizant.wms.controllertesting;


import com.cognizant.wms.portfolio.controller.ClientController;
import com.cognizant.wms.portfolio.entity.ClientEntity;
import com.cognizant.wms.portfolio.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClientControllerTest {

    @InjectMocks
    private ClientController clientController;

    @Mock
    private ClientService clientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegisterClient() {
        ClientEntity client = new ClientEntity("John Doe", "john.doe@example.com", "123-456-7890", "123 Main St, Anytown, USA", new Date());
        when(clientService.registerClient(any(ClientEntity.class))).thenReturn(client);

        ResponseEntity<ClientEntity> response = clientController.registerClient(client);
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(client, response.getBody());
    }

    @Test
    public void testGetClientDetails() {
        ClientEntity client = new ClientEntity("John Doe", "john.doe@example.com", "123-456-7890", "123 Main St, Anytown, USA", new Date());
        when(clientService.getClientDetails(1L)).thenReturn(client);

        ResponseEntity<ClientEntity> response = clientController.getClientDetails(1L);
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(client, response.getBody());
    }
}
