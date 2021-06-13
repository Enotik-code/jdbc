package by.logistics.controller.rest.api;

import by.logistics.bean.api.Gems;
import by.logistics.client.GemsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GemsRestController {

    @Autowired
    GemsClient gemsClient;

    @GetMapping("api/users")
    public ResponseEntity<List<Gems>> fetchUsers() {
        return ResponseEntity.ok(gemsClient.getAllUsers());
    }
}
